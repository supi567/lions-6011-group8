package com.example.manu.tic_tac_toe;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Manu on 5/25/2016.
 */
public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

public Activity c;
public Dialog d;
public Button Ok;
    TextView help_txt;
        String Message_to_show;



public CustomDialogClass(Activity a,String msg) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.Message_to_show=msg;
        }

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_window);
        Ok = (Button) findViewById(R.id.btn_okpopup);
    help_txt= (TextView)findViewById(R.id.help_txt);
    help_txt.setText(Message_to_show);

        Ok.setOnClickListener(this);





        }

@Override
public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn_okpopup:
        dismiss();

        break;
default:
        break;
        }
        dismiss();
        }


}