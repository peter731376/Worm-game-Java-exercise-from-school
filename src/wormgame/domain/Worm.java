/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author AnDong Mac
 */
public class Worm {
    private List<Piece> list;
    private Direction d;
    private boolean gr;
    public Worm(int originalX, int originalY, Direction originalDirection){
        list= new ArrayList<Piece>();
        list.add( new Piece(originalX,originalY));
        d=originalDirection;
        gr=false;
    }
    public Direction getDirection(){
        return d;
    }
    public void setDirection(Direction dir){
        d=dir;
    }
    public int getLength(){
        return list.size();
    }
    public List<Piece> getPieces() {
        return list;
    }
    public void move(){
        if(this.getLength()<3||gr==true){
            if(d==Direction.DOWN){
                Piece p = new Piece(list.get(list.size()-1).getX(),list.get(list.size()-1).getY()+1);
                list.add(p);
                gr=false;
            }else if(d==Direction.LEFT){
                Piece p = new Piece(list.get(list.size()-1).getX()-1,list.get(list.size()-1).getY());
                list.add(p);
                gr=false;
            }else if(d==Direction.RIGHT){
                Piece p = new Piece(list.get(list.size()-1).getX()+1,list.get(list.size()-1).getY());
                list.add(p);
                gr=false;
            }else if(d==Direction.UP){
                Piece p = new Piece(list.get(list.size()-1).getX(),list.get(list.size()-1).getY()-1);
                list.add(p);
                gr=false;
            }
        }else{
            if(d==Direction.DOWN){
                Piece p = new Piece(list.get(list.size()-1).getX(),list.get(list.size()-1).getY()+1);
                list.add(p);
                list.remove(0);
            }else if(d==Direction.LEFT){
                Piece p = new Piece(list.get(list.size()-1).getX()-1,list.get(list.size()-1).getY());
                list.add(p);
                list.remove(0);
            }else if(d==Direction.RIGHT){
                Piece p = new Piece(list.get(list.size()-1).getX()+1,list.get(list.size()-1).getY());
                list.add(p);
                list.remove(0);
            }else if(d==Direction.UP){
                Piece p = new Piece(list.get(list.size()-1).getX(),list.get(list.size()-1).getY()-1);
                list.add(p);
                list.remove(0);
            }
        }
    }
    public void grow() {
        gr=true;
    }
    public boolean runsInto(Piece piece){
        for(Piece p:list){
            if(p.getX()==piece.getX()&&p.getY()==piece.getY()){
                return true;
            }
        }
        return false;
    }
    public boolean runsIntoItself(){
        List<Piece> checklist= new ArrayList<Piece>();
        for(int i=0;i<list.size()-2;i++){
            checklist.add(list.get(i));
        }
        for (Piece p:checklist){
            if(list.get(list.size()-1).getX()==p.getX()&&list.get(list.size()-1).getY()==p.getY()){
                return true;
            }
                    
        }
        return false;
    }
    
    
    
    
    
    
}
