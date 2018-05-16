package com.example.mamoun.tictactoe;

/**
 * Created by mamoun on 25/03/18.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class boardcc {
    private LinkedHashMap<Integer, ArrayList> dictMap = new LinkedHashMap<Integer, ArrayList>();
    private String turn="o";
    private String fc="y";
    private int fx;
    private int fy;
    private int sx=0;
    private int sy=0;
    private int yscore=0;
    private int gscore=0;
    private int movetype=0;




    public boardcc(){
        this.dictMap.put(0,new ArrayList<String>(5));
        this.dictMap.put(1,new ArrayList<String>(5));
        this.dictMap.put(2,new ArrayList<String>(5));
        this.dictMap.put(3,new ArrayList<String>(5));
        this.dictMap.put(4,new ArrayList<String>(5));

        for(int i=0;i<5;i++){
            this.dictMap.get(0).add("x");

        }
        for(int i=0;i<5;i++){
            this.dictMap.get(1).add("x");

        }
        for(int i=0;i<5;i++){
            this.dictMap.get(2).add(" ");

        }
        for(int i=0;i<5;i++){
            this.dictMap.get(3).add("o");

        }
        for(int i=0;i<5;i++){
            this.dictMap.get(4).add("o");

        }
        this.dictMap.get(2).set(0,"x");
        this.dictMap.get(2).set(1,"x");
        this.dictMap.get(2).set(2," ");
        this.dictMap.get(2).set(3,"o");
        this.dictMap.get(2).set(4,"o");

    }
    public int checkmove(){
        if(Math.abs(this.fx-this.sx)==1 && Math.abs(this.fy-this.sy)==0 && this.dictMap.get(fx).get(fy)!=this.dictMap.get(sx).get(sy)){
            this.movetype=1;

            return 1;

        }else if(Math.abs(this.fx-this.sx)==0 && Math.abs(this.fy-this.sy)==1 && this.dictMap.get(fx).get(fy)!=this.dictMap.get(sx).get(sy)){
            this.movetype=1;

            return 1;

        }else if(Math.abs(this.fx-this.sx)==0 && Math.abs(this.fy-this.sy)==2){
            if(this.dictMap.get(this.fx).get((this.sy+this.fy)/2)==this.turn){
                return -1;

            }else if(Math.abs(this.fx-this.sx)==0 && Math.abs(this.fy-this.sy)==2){
                if(this.dictMap.get(this.fx).get((this.sy+this.fy)/2)==" "){
                    return -1;

                }else{
                    this.dictMap.get(fx).set((fy+sy)/2, " ");
                    if(this.turn=="x"){
                        this.gscore++;
                    }else if(this.turn=="o"){
                        this.yscore++;

                    }
                    this.movetype=2;

                    return 1;

                }

        }

    }else if(Math.abs(this.fx-this.sx)==2 && Math.abs(this.fy-this.sy)==0){
            if(this.dictMap.get((this.sx+this.fx)/2).get(this.sy)==this.turn){
                return -1;

            }else if(Math.abs(this.fx-this.sx)==2 && Math.abs(this.fy-this.sy)==0){
                if(this.dictMap.get((this.sx+this.fx)/2).get(this.sy)==" "){
                    return -1;

                }else{
                    this.dictMap.get((this.sx+this.fx)/2).set(fy, " ");
                    if(this.turn=="o"){
                        this.yscore++;
                    }else if(this.turn=="x"){
                        this.gscore++;

                    }
                    this.movetype=2;

                    return 1;

                }

            }

        }
        return -1;
    }

    public void drawb(){
        this.dictMap.get(fx).set(fy, " ");
        this.dictMap.get(sx).set(sy, this.turn);}


    public void drawb2(){
        this.dictMap.get((fx+sx)/2).set((fy+sy)/2, " ");}


    public void setdrawb(int xx,int yy,String ss){
        this.dictMap.get(xx).set(yy, ss);

    }
    public void setfx(int fxx){
        this.fx=fxx;
    }

    public void setfy(int fyy){
        this.fy=fyy;
    }

    public void setsy(int syy){
        this.sy=syy;
    }
    public void setsx(int sxx){
        this.sx=sxx;
    }

    public void setfc(String sxx){
        this.fc=sxx;
    }
    public String getfc(){
        return  this.fc;
    }

    public Collection<ArrayList> ts(){
        return this.dictMap.values();

    }

    public String getturn() {
        return this.turn;
    }
    public String setturn(String t) {
        return this.turn=t;
    }


    public int getGscore() {
        return this.gscore;
    }

    public void setGscore(int gscore) {
        this.gscore = gscore;
    }

    public int getYscore() {
        return this.yscore;
    }

    public void setYscore(int yscore) {
        this.yscore = yscore;
    }

    public int getMovetype() {
        return movetype;
    }

    public void setMovetype(int movetype) {
        this.movetype = movetype;
    }

    public int getFx(){
        return this.fx;
    }
    public int getSx(){
        return this.sx;
    }
    public int getFy(){
        return this.fy;
    }
    public int getSy(){
        return this.sy;
    }
}
