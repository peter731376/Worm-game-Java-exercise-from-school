/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author AnDong Mac
 */
public class DrawingBoard extends JPanel implements Updatable  {
    private WormGame wg;
    private int pieceLength;
    public DrawingBoard(WormGame w,int pL){
        wg=w;
        pieceLength=pL;
        super.setBackground(Color.GRAY);
    }
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        for(Piece p:wg.getWorm().getPieces()){
            graphics.fill3DRect(p.getX()*pieceLength, p.getY()*pieceLength, pieceLength, pieceLength, true);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(wg.getApple().getX()*pieceLength,wg.getApple().getY()*pieceLength,pieceLength,pieceLength);
        
    }
    @Override
    public void update() {
        super.repaint();
    }
    
}
