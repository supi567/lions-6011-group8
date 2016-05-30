package com.example.manu.tic_tac_toe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

    // it shows the game state:
    private boolean PlayerTurn = false; // Who's turn is it? false=X true=O
    private char board[][] = new char[3][3]; // it will represent the board as an array of characters
    TextView turn_status,Matches_won_X,Matches_won_O;
    int Total_matches_won_by_X=0,Total_matches_won_by_O=0;
    private TableLayout Table_layout1;
    private static MainActivity mainActivity;
    String[][] xoValues = new String[3][3];
    String Turn="";
    char Player;
    public void setTurn(String turn){this.Turn=turn;}
    public String getTurn(){return this.Turn;}
    public void setPlayer(char player){this.Player=player;}
    public char getPlayer(){return this.Player;}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupOnClickListeners();
        Matches_won_X=(TextView)findViewById(R.id.matches_won_by_x);
        Matches_won_O=(TextView)findViewById(R.id.matches_won_by_o);
        resetButtons();
        mainActivity = this;
    }



    public void newGame(View view) {
        PlayerTurn = false;
        board = new char[3][3];
        resetButtons();
    }


    private void resetButtons() {

        TableLayout Table_layout1 = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < Table_layout1.getChildCount(); y++) {
            if (Table_layout1.getChildAt(y) instanceof TableRow) {
                TableRow TableRow = (TableRow) Table_layout1.getChildAt(y);
                for (int x = 0; x < TableRow.getChildCount(); x++) {
                    if (TableRow.getChildAt(x) instanceof Button) {
                        Button Btn = (Button) TableRow.getChildAt(x);
                        Btn.setText("");
                        Btn.setBackgroundResource(android.R.drawable.btn_default);
                        Btn.setEnabled(true);
                    }
                }
            }
        }
        turn_status = (TextView) findViewById(R.id.title_txt);
        turn_status.setText("X's Turn");
    }

    //this method return true if anyone has won and false if nobody win.
    private boolean checkWin() {
        if(PlayerTurn==false)
        {
            setTurn("X's Turn");
            turn_status.setText(Turn);
        }
        else {
            setTurn("O's Turn");
            turn_status.setText(Turn);
        }

        char winner = '\0';
        if (checkWinner(board, 3, 'X'))
        {
            setPlayer('X');
            winner = Player;
            Total_matches_won_by_X++;
            Matches_won_X.setText("Total Match Won by 'X' - "+Total_matches_won_by_X);

        } else if (checkWinner(board, 3, 'O')) {
            setPlayer('O');
            winner = Player;
            Total_matches_won_by_O++;
            Matches_won_O.setText("Total Match Won by 'O' - "+Total_matches_won_by_O);
        }
        else if( winner =='\0'){
        }

        if (winner == '\0') {

            return false; // nobody won
        } else {
            // display winner on the text
            TextView T = (TextView) findViewById(R.id.title_txt);
            T.setText(winner + " wins");
            if(Total_matches_won_by_O==5)
            {
                DialogeueBox( "Player O is the Winner of this Series");
                Total_matches_won_by_O=0;
                Total_matches_won_by_X=0;
            }
            else if(Total_matches_won_by_X==5)
            {
                DialogeueBox("Player X is the Winner of this Series");
                Total_matches_won_by_O=0;
                Total_matches_won_by_X=0;
            }
            else {
                DialogeueBox("Player "+winner+" Won This Match");
            }
            return true;
        }
    }


    /**
     * To Check if someone has won or not
     * size is the width or height of board
     * players 'X' or 'O'
     * it return true if someone has won
     */
    public boolean checkWinner(char[][] board, int size, char player) {
        // check each column
        for (int x = 0; x < size; x++) {
            int total = 0;
            for (int y = 0; y < size; y++) {
                if (board[x][y] == player) {
                    total++;
                }
            }
            if (total >= size) {
                return true; // Someone has won
            }
        }

        // check each row
        for (int y = 0; y < size; y++) {
            int total = 0;
            for (int x = 0; x < size; x++) {
                if (board[x][y] == player) {
                    total++;
                }
            }
            if (total >= size) {
                return true; // they win
            }
        }

        // forward diagonal
        int total = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x == y  &&  board[x][y] == player) {
                    total++;
                }
            }
        }
        if (total >= size) {
            return true; // they win
        }

        // backward diagonal
        total = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x + y == size - 1 && board[x][y] == player) {
                    total++;
                }
            }
        }
        if (total >= size) {
            return true; // Someone won
        }

        return false; // nobody won
    }

    /**
     * Disables all the buttons
     */
    private void disableButtons() {
        TableLayout Tbl_layout = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < Tbl_layout.getChildCount(); y++) {
            if (Tbl_layout.getChildAt(y) instanceof TableRow) {
                TableRow table_row = (TableRow) Tbl_layout.getChildAt(y);
                for (int x = 0; x < table_row.getChildCount(); x++) {
                    if (table_row.getChildAt(x) instanceof Button) {
                        Button B = (Button) table_row.getChildAt(x);
                        B.setEnabled(false);
                    }
                }
            }
        }
    }

    /**
     * to add onClicklisetener to each button inside the tablelayout
     */
    private void setupOnClickListeners() {
        TableLayout Table_layout = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < Table_layout.getChildCount(); y++) {
            if (Table_layout.getChildAt(y) instanceof TableRow) {
                TableRow TableRow = (TableRow) Table_layout.getChildAt(y);
                for (int x = 0; x < TableRow.getChildCount(); x++) {
                    View V = TableRow.getChildAt(x);
                    V.setOnClickListener(new PlayOnClick(x, y));
                }
            }
        }
    }

    /**
     * This is Custom OnClickListener for Noughts and Crosses
     */
    private class PlayOnClick implements View.OnClickListener {

        private int x = 0;
        private int y = 0;

        public PlayOnClick(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View view) {
            if (view instanceof Button) {
                Button B = (Button) view;
                board[x][y] = PlayerTurn ? 'O' : 'X';
                B.setText(PlayerTurn ? "O" : "X");
                B.setTextSize(0);
                if(B.getText()=="O") {
                    B.setBackgroundResource(R.drawable.new_circle);
                }
                else
                {
                      B.setBackgroundResource(R.drawable.new_cross);
                }
                B.setEnabled(false);
                PlayerTurn = !PlayerTurn;

                // check if anyone has won
                if (checkWin()) {
                    disableButtons();
                }
            }
        }
    }

   public void DialogeueBox (String winner)
    {
        CustomDialogClass cdd=new CustomDialogClass(MainActivity.this,winner);
        cdd.show();
    }
}