package com.example.manu.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    Button btn_new_game, btn_exit, btn_help;
    PopupWindow popUp;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start_screen);
        btn_new_game = (Button) findViewById(R.id.btn_newgame);
        btn_exit = (Button) findViewById(R.id.btn_exitgame);
        btn_help = (Button) findViewById(R.id.btn_help);
        linearLayout = (LinearLayout)findViewById(R.id.start_screen_layout);
        popUp = new PopupWindow(this);

        btn_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StartScreen.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitGame(0);
            }
        });
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Help_text_message="Tic-tac-toe (also known as Noughts and crosses or Xs and Os) is a  game for two players, X and O, who take turns marking the spaces in a 3×3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.\n" +
                        "\n" +
                        "The following example game is won by the first player, X:\n" +
                        "\n" +
                        "\n" +
                        "Game of Tic-tac-toe, won by X\n" +
                        "\n" +
                        "The winner will get a gift."+
                        "\n";
                showHelp(Help_text_message, 0);



            }
        });
    }


    public int exitGame(int exitCode){
        if(exitCode == 0 ){
            finish();
            return 1;
        }
        return 0;
    }

    public int showHelp(String helpText,int helpCode){
        if(helpCode == 0 ){
            CustomDialogClass cdd=new CustomDialogClass(StartScreen.this,helpText);
            cdd.show();
            return 1;
        }
        return 0;
    }

    }

