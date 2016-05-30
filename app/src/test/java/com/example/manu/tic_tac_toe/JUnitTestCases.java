package com.example.manu.tic_tac_toe;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class JUnitTestCases extends MainActivity{

    private MainActivity mainActivity;
    private StartScreen startScreen;
    private char board[][] = new char[3][3];



    @Before
    public void initializeGameState(){

        mainActivity = new MainActivity();
        startScreen = new StartScreen();
        Intent myIntent = new Intent(mainActivity, MainActivity.class);
        mainActivity.startActivity(myIntent);
    }


    // Testing the exit game function()
    @Test
    public void testExitGame(){
        assertEquals(1, startScreen.exitGame(0));
    }

    // Testing Help function
    @Test
    public void testHelpGame(){
        assertEquals(1, startScreen.showHelp(null,0));
    }

    // Testing Verify player (winner)
    @Test
    public void verifyGetPlayer()
    {
        MainActivity main=new MainActivity();
        main.setPlayer('O');
        assertEquals(main.getPlayer(),'O');
        main.setPlayer('X');
        assertEquals(main.getPlayer(),'X');
    }

    // Testing the Turn of player
    @Test
    public void verifyGetTurn()
    {
        MainActivity main=new MainActivity();
        main.setTurn("X's Turn");
        assertEquals(main.getTurn(), "X's Turn");
        main.setTurn("O's Turn");
        assertEquals(main.getTurn(),"O's Turn");
    }

    private void setboardAsXWinner()
    {
        board [0][0]= 'X';
        board [0][1]= 'O';
        board [0][2]= 'O';
        board [1][0]= 'X';
        board [1][1]= 'X';
        board [1][2]= 'X';
        board [2][0]= 'O';
        board [2][1]= 'X';
        board [2][2]= 'O';
    }

    private void setboardAsNoWinner()
    {

        board [0][0]= 'X';
        board [0][1]= 'O';
        board [0][2]= 'O';
        board [1][0]= 'O';
        board [1][1]= 'X';
        board [1][2]= 'X';
        board [2][0]= 'O';
        board [2][1]= 'X';
        board [2][2]= 'O';
    }

    // Testing Game Winner
    @Test
    public void checkwinnerTestWin() throws Exception {

        setboardAsXWinner();
        int size=3;
        char player='X';

        boolean Result = mainActivity.checkWinner(board,size,player);
        assertEquals(Result, true);

        new MainActivity();

    }
    // Testing who loose
    @Test
    public void checkwinnerTestLoose() throws Exception {

        setboardAsNoWinner();
        int size=3;
        char player='X';

        boolean Result = mainActivity.checkWinner(board,size,player);
        assertEquals(Result, false);

    }
}