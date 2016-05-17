/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Dhruv
 */
public class TicTac extends JFrame
{
    
    //JPanel p = new JPanel();
    JPanel panel =new JPanel();
    Cells buttons[]=new Cells[9];
    JLabel jlbstatus = new JLabel("X' turn");
    //JButton reset = new JButton("reset");
    //JButton help = new JButton("help");
    JMenuBar menuBar;
    JMenu game,help;
    JMenuItem reset,ins1,ins2,ins3,exit;
   
    public TicTac()
    {
        menuBar =  new JMenuBar();
        game = new JMenu("Game");
        help = new JMenu("Guide");
        reset = new JMenuItem("Reset");
        exit = new JMenuItem("exit");
        ins1 = new JMenuItem("On first click player will be able to draw X");
        ins2 = new JMenuItem("On second click player will be able to draw O");
       ins3 = new JMenuItem("Reset game board option is there under game menu");
        menuBar.add(game);
        menuBar.add(help);
        game.add(reset);
        game.add(exit);
        help.add(ins1);
        help.add(ins2);
        help.add(ins3);
        this.setJMenuBar(menuBar);
        
        panel.setLayout(new GridLayout(3,3));
        //p.setLayout(new FlowLayout(FlowLayout.CENTER));
        //p.add(new JLabel("bottom"));
        //p.add(reset);
        //p.add(help);
        for(int i=0;i<9;i++)
                {
                    buttons[i]=new Cells();
                    panel.add(buttons[i]);
		} 
        add(panel,BorderLayout.CENTER);
        //add(p,BorderLayout.NORTH);
        add(jlbstatus, BorderLayout.SOUTH);
        reset.addActionListener(new Res());
        exit.addActionListener(new Close());
            
        }
    
    public class Close implements ActionListener{
        @Override
      public void actionPerformed(ActionEvent e){
          System.exit(0);
      }
    }
  /**
   * Class is used to reset the board
   */
  public class Res implements ActionListener
  {
      /**
       * When reset button is hit all the buttons in panel 2 which is the main
       * board are set to value null thus the board is reset.
       * @param e 
       */
      @Override
      public void actionPerformed(ActionEvent e){
          for(int i=0 ; i <9 ; i++){
              buttons[i].setIcon(null);
          }
          jlbstatus.setText("board has been reset");
      }
  }      
  
  
        
    
  public class Cells extends JButton implements ActionListener
  {
    
    ImageIcon X,O;
    byte value=0;
   /**
    * No-argument constructor used to load the images from resource
    * Used to trigger the action on click event
    */	
    public Cells()
        {
	X=new ImageIcon(this.getClass().getResource("X.png"));
	O=new ImageIcon(this.getClass().getResource("O.png"));
        // Player or us is the one trigerring the action and listening to it
        // thus we use this
	this.addActionListener(this);
        }

    /**
    * This main purpose of this function is  to perform the action, based on the 
    * click event
    * @param e 
    */
    public void actionPerformed(ActionEvent e)
    {
        
        /* X is assinged value = 1
           O is assinged value = 0
           That is for click one value is 1 and click 2 value is 0
           Therefore for single click value X will be entered by the user
           and when user clicks twice in the cell value will be O
        */
	value++;
        // Following will reset value to 0 if it is greater than or equal to 2
	value%=2;
        
	switch(value)
        {
                
		case 0:
			setIcon(O);
                        jlbstatus.setText("Player O made a move");
			break;
		case 1:
                        setIcon(X);
                        jlbstatus.setText("Player X made a move");
			break;
	}
    }
    
  }//end of cell class
}//end of TicTac class

