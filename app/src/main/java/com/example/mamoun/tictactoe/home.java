package com.example.mamoun.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mamoun on 31/03/18.
 */

public class home extends Activity {
    final Context context = this;


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("NEON DASH")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


    public void about() {

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.aboout);
        dialog.setTitle("ABOUT");

        // set the custom dialog components - text, image and button


        //image.setImageResource(R.drawable.ic_launcher);



        dialog.show();
    }


    public void player1(View v){
        Toast.makeText(this,"will be available soon", Toast.LENGTH_SHORT).show();


    }
    public void online(View v){
        Toast.makeText(this,"working on it", Toast.LENGTH_SHORT).show();


    }
    public void about(View v){
       about();


    }
    public void player2(View v){
        Intent mainIntent = new Intent(home.this,playersc.class);
        home.this.startActivity(mainIntent);
        home.this.finish();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        View dv = getWindow().getDecorView();
        int uop = View.SYSTEM_UI_FLAG_FULLSCREEN;
        dv.setSystemUiVisibility(uop);

    }
}