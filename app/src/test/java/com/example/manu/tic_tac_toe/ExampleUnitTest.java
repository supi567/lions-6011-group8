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
public class ExampleUnitTest extends MainActivity{

    private MainActivity mainActivity;
    private StartScreen startScreen;



    @Before
    public void initializeGameState(){

        mainActivity = new MainActivity();
        startScreen = new StartScreen();
        Intent myIntent = new Intent(mainActivity, MainActivity.class);
        mainActivity.startActivity(myIntent);
    }

    @Test
    public void testExitGame(){
        assertEquals(1, startScreen.exitGame(0));
    }

    @Test
    public void testHelpGame(){
        assertEquals(1, startScreen.showHelp(null,0));
    }

    @Test
    public void testResetButtons() throws Exception {
        mainActivity.resetButtons();
        TableLayout tableLayout = mainActivity.getTable_layout();
        for (int y = 0; y < tableLayout.getChildCount(); y++) {
            if (tableLayout.getChildAt(y) instanceof TableRow) {
                TableRow TableRow = (TableRow) tableLayout.getChildAt(y);
                for (int x = 0; x < TableRow.getChildCount(); x++) {
                    if (TableRow.getChildAt(x) instanceof Button) {
                        Button Btn = (Button) TableRow.getChildAt(x);
                        assertEquals("", Btn.getText());
                        assertEquals(true, Btn.isEnabled());
                    }
                }
            }

        }
    }
}