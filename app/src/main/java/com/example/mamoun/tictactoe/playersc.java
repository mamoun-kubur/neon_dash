package com.example.mamoun.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by mamoun on 30/03/18.
 */

public class playersc extends Activity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.players);
        View dv=getWindow().getDecorView();
        int uop=View.SYSTEM_UI_FLAG_FULLSCREEN;
        dv.setSystemUiVisibility(uop);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(playersc.this,MainActivity.class);
                playersc.this.startActivity(mainIntent);
                playersc.this.finish();
            }
        }, 3000);

    }


}
