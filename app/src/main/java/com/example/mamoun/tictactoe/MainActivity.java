package com.example.mamoun.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    private Button b00,b01,b02,b03,b04,b11,b12,b13,b14,b10,b21,b22,b23,b24,b20,b31,b32,b33,b34,b30
            ,b41,b42,b43,b44,b40,res;
    private boolean pt=true;
    private int rc;
    private int p1p;
    private int p2p;
    private TextView w1;
    private TextView w2;
    public boardcc a=new boardcc();
    public String[] turnss={"o","x"};
    public String[] colors={"green","yellow"};
    public Button[] pink=new Button[12];
    public Button[] purp=new Button[12];

    public Button[][] cr=new Button[5][5];
    public View w2r;
    public View w1r;
    public View linout;
    final Context context = this;
    public void dia2() {

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog2);
        //dialog.setTitle("THE WINNER IS");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("NEW GAME");
        if (a.getYscore()==12){
            ImageView image = (ImageView) dialog.findViewById(R.id.image);
        }else{

        }


        //image.setImageResource(R.drawable.ic_launcher);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        Button home = (Button) dialog.findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this,home.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
                dialog.dismiss();
            }
        });

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newg();
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("BACK TO HOME!")
                .setMessage("Are you sure you want to leave the game?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mainIntent = new Intent(MainActivity.this,home.class);
                        MainActivity.this.startActivity(mainIntent);
                        MainActivity.this.finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }



    public void dia() {

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog);
        //dialog.setTitle("THE WINNER IS");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("NEW GAME");
        if (a.getGscore()==12){
            ImageView image = (ImageView) dialog.findViewById(R.id.image);
        }else{

        }
        Button home = (Button) dialog.findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this,home.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
                dialog.dismiss();
            }
        });


        //image.setImageResource(R.drawable.ic_launcher);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newg();
                dialog.dismiss();

            }
        });

        dialog.show();
    }




    public int plays=2;

    public void bclicked(View v){
        Button btn = (Button)v;
        final MediaPlayer nm = MediaPlayer.create(this, R.raw.nm);
        final MediaPlayer dm = MediaPlayer.create(this, R.raw.dm);
        final MediaPlayer clap = MediaPlayer.create(this, R.raw.clap);
        int dbcx=Integer.parseInt(btn.getTag().toString().charAt(1)+"");
        int dbcy=Integer.parseInt(btn.getTag().toString().charAt(2)+"");

        if(btn.getText().toString()==" " && a.getMovetype()==2 && cr[(dbcx+a.getSx())/2][(dbcy+a.getSy())/2].getText().toString()==turnss[plays%2]
              && ((Math.abs(dbcx-a.getSx())==2 && Math.abs(dbcy-a.getSy())==0) | (Math.abs(dbcy-a.getSy())==2 && Math.abs(dbcx-a.getSx())==0))){

            a.setdrawb((dbcx+a.getSx())/2,(dbcy+a.getSy())/2," ");

            a.setfx(a.getSx());
            a.setfy(a.getSy());
            a.setsx(dbcx);
            a.setsy(dbcy);
            //cr[(dbcx+a.getSx())/2][(dbcy+a.getSy())/2].setText(" ");
            a.drawb();


            if(a.getMovetype()==2){
                    if(a.getturn()=="x"){
                        a.setYscore(a.getYscore()+1);

                        btn.setBackgroundResource(R.drawable.gc);
                        cr[(a.getFx()+a.getSx())/2][(a.getFy()+a.getSy())/2].setBackgroundResource(R.drawable.p1c);
                    }if(a.getturn()=="o"){
                    a.setGscore(a.getGscore()+1);

                        btn.setBackgroundResource(R.drawable.yc);

                        cr[(a.getFx()+a.getSx())/2][(a.getFy()+a.getSy())/2].setBackgroundResource(R.drawable.p2c);
                    }
                cr[a.getFx()][a.getFy()].setBackgroundResource(R.drawable.emp);

                a.setdrawb(a.getSx(),a.getSy(),turnss[(plays-1)%2]);


                for (int i=0;i<a.getYscore();i++){
                    pink[i].setBackgroundResource(R.drawable.p1);
                }
                for (int i=0;i<a.getGscore();i++){
                    purp[i].setBackgroundResource(R.drawable.p2);
                }

                dm.start();
                    if (a.getGscore()==12){
                        Intent svc=new Intent(this, clllap.class);
                        startService(svc);
                        dia2();

                        w1.setVisibility(View.VISIBLE);
                        w1r.setVisibility(View.GONE);

                    }else if(a.getYscore()==12){
                        Intent svc=new Intent(this, clllap.class);
                        startService(svc);
                        dia();
                        w2r.setVisibility(View.GONE);
                        w2.setVisibility(View.VISIBLE);

                    }





            }

        }else if(btn.getText().toString()==a.getturn()){
            if(a.getfc()=="y"){
                drb();
               a.setfx(Integer.parseInt(btn.getTag().toString().charAt(1)+""));
                a.setfy(Integer.parseInt(btn.getTag().toString().charAt(2)+""));
                a.setfc("n");
                a.setturn(" ");
                if(btn.getText().toString()=="x"){
                    btn.setBackgroundResource(R.drawable.yc);
                }else  if(btn.getText().toString()=="o"){
                    btn.setBackgroundResource(R.drawable.gc);
                }
                a.setsx(-1);
                a.setsy(-1);
                //Toast.makeText(this," "+Integer.parseInt(btn.getTag().toString().charAt(2)+""),Toast.LENGTH_SHORT).show();


            }



            else if(a.getfc()=="n"){
                a.setsx(Integer.parseInt(btn.getTag().toString().charAt(1)+""));
                a.setsy(Integer.parseInt(btn.getTag().toString().charAt(2)+""));
                a.setturn(turnss[plays%2]);

                if(a.checkmove()==1){
                a.setfc("y");
                a.drawb();
                plays++;
                a.setturn(turnss[plays%2]);

                //Toast.makeText(this," "+Integer.parseInt(btn.getTag().toString().charAt(2)+""),Toast.LENGTH_SHORT).show();
                drb();
                    //ysb.setText(a.getYscore()+" ");
                    //gsb.setText(a.getGscore()+" ");
                    if(a.getMovetype()==1){
                        nm.start();
                    }else if(a.getMovetype()==2){
                        if(a.getturn()=="x"){
                            btn.setBackgroundResource(R.drawable.gc);
                            cr[(a.getFx()+a.getSx())/2][(a.getFy()+a.getSy())/2].setBackgroundResource(R.drawable.p1c);
                        }if(a.getturn()=="o"){
                            btn.setBackgroundResource(R.drawable.yc);

                            cr[(a.getFx()+a.getSx())/2][(a.getFy()+a.getSy())/2].setBackgroundResource(R.drawable.p2c);
                        }


                        dm.start();
                        if (a.getGscore()==12){
                            Intent svc=new Intent(this, clllap.class);
                            startService(svc);
                            dia2();
                            w1.setVisibility(View.VISIBLE);
                            w1r.setVisibility(View.GONE);

                        }else if(a.getYscore()==12){
                            Intent svc=new Intent(this, clllap.class);
                            startService(svc);
                            clap.start();
                            dia();
                            w2r.setVisibility(View.GONE);
                            w2.setVisibility(View.VISIBLE);

                        }

                    }

                }else {
                    Toast.makeText(this,"you can't make this move",Toast.LENGTH_SHORT).show();
                    a.setfx(-1);
                    a.setsx(-1);
                    a.setfy(-1);
                    a.setsy(-1);

                    drb();
                    a.setfc("n");
                    a.setturn(" ");


                }

                //Toast.makeText(this,a.ts().toString(),Toast.LENGTH_SHORT).show();

            }
        }else if(a.getfc()=="n" && btn.getText().toString()==turnss[plays%2]){
            drb();
            a.setfx(Integer.parseInt(btn.getTag().toString().charAt(1)+""));
            a.setfy(Integer.parseInt(btn.getTag().toString().charAt(2)+""));
            a.setfc("n");
            a.setturn(" ");
            if(btn.getText().toString()=="x"){
                btn.setBackgroundResource(R.drawable.yc);
            }else{
                btn.setBackgroundResource(R.drawable.gc);
            }
            //Toast.makeText(this," "+Integer.parseInt(btn.getTag().toString().charAt(2)+""),Toast.LENGTH_SHORT).show();


        }





    }

    public void newg(){
        a=new boardcc();
        plays=0;
        a.setturn(turnss[plays%2]);
        a.setGscore(0);
        a.setYscore(0);
        w2r.setVisibility(View.VISIBLE);
        w2.setVisibility(View.GONE);
        w1r.setVisibility(View.VISIBLE);
        w1.setVisibility(View.GONE);
        for (int i=0;i<12;i++){
            pink[i].setBackgroundResource(R.drawable.emp);
        }
        for (int i=0;i<12;i++){
            purp[i].setBackgroundResource(R.drawable.emp);
        }
        //ysb.setText(a.getYscore()+" ");
        //gsb.setText(a.getGscore()+" ");
        drb();
        Toast.makeText(this,"creating new game",Toast.LENGTH_SHORT).show();


    }

    private void drb() {
        ArrayList<ArrayList> jj = new ArrayList<ArrayList>(a.ts());
        Button[] btns={b00,b01,b02,b03,b04,b11,b12,b13,b14,b10,b21,b22,b23,b24,b20,b31,b32,b33,b34,b30
                ,b41,b42,b43,b44,b40};

        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                String btnid="b"+i+j;
                int reso=getResources().getIdentifier(btnid,"id",getPackageName());
                cr[i][j]=(Button) findViewById(reso);
            }
        }




        b00.setText((String) jj.get(0).get(0));
        b01.setText((String) jj.get(0).get(1));
        b02.setText((String) jj.get(0).get(2));
        b03.setText((String) jj.get(0).get(3));
        b04.setText((String) jj.get(0).get(4));
        b10.setText((String) jj.get(1).get(0));
        b11.setText((String) jj.get(1).get(1));
        b12.setText((String) jj.get(1).get(2));
        b13.setText((String) jj.get(1).get(3));
        b14.setText((String) jj.get(1).get(4));
        b20.setText((String) jj.get(2).get(0));
        b21.setText((String) jj.get(2).get(1));
        b22.setText((String) jj.get(2).get(2));
        b23.setText((String) jj.get(2).get(3));
        b24.setText((String) jj.get(2).get(4));
        b30.setText((String) jj.get(3).get(0));
        b31.setText((String) jj.get(3).get(1));
        b32.setText((String) jj.get(3).get(2));
        b33.setText((String) jj.get(3).get(3));
        b34.setText((String) jj.get(3).get(4));
        b40.setText((String) jj.get(4).get(0));
        b41.setText((String) jj.get(4).get(1));
        b42.setText((String) jj.get(4).get(2));
        b43.setText((String) jj.get(4).get(3));
        b44.setText((String) jj.get(4).get(4));


        for (int i=0;i<a.getYscore();i++){
            pink[i].setBackgroundResource(R.drawable.p1);
        }
        for (int i=0;i<a.getGscore();i++){
            purp[i].setBackgroundResource(R.drawable.p2);
        }

        for (int i=0;i<btns.length;i++){
            if(btns[i].getText().toString()=="x"){
                btns[i].setBackgroundResource(R.drawable.p1);
            }else if(btns[i].getText().toString()=="o"){
                btns[i].setBackgroundResource(R.drawable.p2);

            }else if(btns[i].getText().toString()==" "){
                btns[i].setBackgroundResource(R.drawable.emp);

            }

        }
        //Toast.makeText(this,a.ts().toString(),Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


         //MediaPlayer bg = MediaPlayer.create(this, R.raw.bg);
        //bg.setLooping(true);
        //bg.start();
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);


        //linout=findViewById(R.id.linout);
        //Toast.makeText(this,linout.getLayoutParams().width+"",Toast.LENGTH_SHORT).show();


        //linout.setLayoutParams(new LinearLayout.LayoutParams(100,100));

        View dv=getWindow().getDecorView();
        int uop=View.SYSTEM_UI_FLAG_FULLSCREEN;
        dv.setSystemUiVisibility(uop);

        Intent g=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        w1=(TextView) findViewById(R.id.w1);
        w2=(TextView) findViewById(R.id.w2);

        w1r= findViewById(R.id.w1r);
        w2r= findViewById(R.id.w2r);

        b00=(Button) findViewById(R.id.b00);
        b01=(Button) findViewById(R.id.b01);
        b02=(Button) findViewById(R.id.b02);
        b03=(Button) findViewById(R.id.b03);
        b04=(Button) findViewById(R.id.b04);
        b10=(Button) findViewById(R.id.b10);
        b11=(Button) findViewById(R.id.b11);
        b12=(Button) findViewById(R.id.b12);
        b13=(Button) findViewById(R.id.b13);
        b14=(Button) findViewById(R.id.b14);
        b20=(Button) findViewById(R.id.b20);
        b21=(Button) findViewById(R.id.b21);
        b22=(Button) findViewById(R.id.b22);
        b23=(Button) findViewById(R.id.b23);
        b24=(Button) findViewById(R.id.b24);
        b30=(Button) findViewById(R.id.b30);
        b31=(Button) findViewById(R.id.b31);
        b32=(Button) findViewById(R.id.b32);
        b33=(Button) findViewById(R.id.b33);
        b34=(Button) findViewById(R.id.b34);
        b40=(Button) findViewById(R.id.b40);
        b41=(Button) findViewById(R.id.b41);
        b42=(Button) findViewById(R.id.b42);
        b43=(Button) findViewById(R.id.b43);
        b44=(Button) findViewById(R.id.b44);

        for (int i=0;i<12;i++){
            String pinkid="pink"+i;
            int preso=getResources().getIdentifier(pinkid,"id",getPackageName());
            pink[i]=(Button) findViewById(preso);
        }

        for (int i=0;i<12;i++){
            String pinkid="purp"+i;
            int preso=getResources().getIdentifier(pinkid,"id",getPackageName());
            purp[i]=(Button) findViewById(preso);
        }



        drb();
    }


    @Override
    protected void onStop() {
        super.onStop();
        Intent svc=new Intent(this, BackgroundSoundService.class);

        stopService(svc);// Always call the superclass method first
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent svc=new Intent(this, BackgroundSoundService.class);

        startService(svc);// Always call the superclass method first

    }




}

