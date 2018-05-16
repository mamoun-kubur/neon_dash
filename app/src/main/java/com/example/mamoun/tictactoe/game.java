package com.example.mamoun.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

/**
 * Created by mamoun on 27/03/18.
 */

public class game extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        View dv=getWindow().getDecorView();
        int uop=View.SYSTEM_UI_FLAG_FULLSCREEN;
        dv.setSystemUiVisibility(uop);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(game.this,home.class);
                game.this.startActivity(mainIntent);
                game.this.finish();
            }
        }, 3000);

}


}
