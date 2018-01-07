package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    
    private Worm worm;
    private Apple apple;
    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
        
        worm= new Worm(width/2,height/2,Direction.DOWN);
        int x=width/2;
        int y=height/2;
        while(true){
            x=new Random().nextInt(width);
            y= new Random().nextInt(height);
            if(x!=width/2||y!=height/2){
                break;
            }
        }
            
        apple= new Apple(x,y);

    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        worm.move();
        if(worm.runsInto(apple)){
            worm.grow();
            while(true){
                apple= new Apple(new Random().nextInt(width),new Random().nextInt(height));
                if(!worm.runsInto(apple)){
                    break;
                }
            }
        }
        if(worm.runsIntoItself()){
            continues=false;
        }
        for(Piece p:worm.getPieces()){
            if(p.getX()<0||p.getX()>=width||p.getY()<0||p.getY()>=height){
                continues=false;
            }
        }
        updatable.update();
        setDelay(1000 / worm.getLength());

    }
    
    public Worm getWorm(){
        return worm;
    }
    public void setWorm(Worm worm){
        this.worm=worm;
    }
    public Apple getApple(){
        return apple;
    }
    public void setApple(Apple apple){
        this.apple=apple;
    }
    
    

}
