/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import javax.swing.JFrame;

/**
 *
 * @author Dhruv
 */
public class Ttt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame tic = new TicTac();
                //set location of panel to center of the screen
                tic.setLocationRelativeTo(null);
                //set the board size to 400X400 
                tic.setSize(400,400);
                //Player cannot resize the window
                tic.setResizable(false);
                //setting titile for our game
                tic.setTitle("LIONS-TIC-TAC-TOE");
                // to successfully close exit the application
                tic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // To make the panel visible
                tic.setVisible(true);
    }
    
}
