/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author davido
 */
public class DrawingBoard extends JPanel implements Updatable {
    
    private WormGame wormGame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        // draw worm
        g.setColor(Color.BLACK);
        for (Piece piece : this.wormGame.getWorm().getPieces()) {
            int x = piece.getX() * this.pieceLength;
            int y = piece.getY() * this.pieceLength;
            g.fill3DRect(x, y, this.pieceLength, this.pieceLength, true);
        }
        
        // draw apple
        g.setColor(Color.RED);
        Piece apple = wormGame.getApple();
        int x = apple.getX() * this.pieceLength;
        int y = apple.getY() * this.pieceLength;
        g.fillOval(x, y, this.pieceLength, this.pieceLength);
    }

    @Override
    public void update() {
        this.repaint();
    }
}
