package com.example.bdtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    SharedPreferences level;
    public static final String APP_PREFERENCES = "level";
    public static final String APP_PREFERENCES_ROOM1 = "Room1";
    public static final String APP_PREFERENCES_ROOM2 = "Room2";
    public static final String APP_PREFERENCES_ROOM3 = "Room3";

    public int[][] room1 = new int[10][22];
    public int[][] room2 = new int[10][22];
    public int[][] room3 = new int[10][22];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent intent = getIntent();
        String modeStr = intent.getStringExtra("mode");
        int mode = Integer.parseInt(modeStr);

        level = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = level.edit();


        String room1str = level.getString(APP_PREFERENCES_ROOM1, "");
        if(room1str.length()==220) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 21; j >= 0; j--) {
                    room1[i][j] = Integer.parseInt(String.valueOf(room1str.charAt(i*22+j)));
                }
            }
        }
        else{
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                room1[i][j] = 0;
            }
        }
        room1[0][0] = 2;
        room1[9][21] = 3;}



        String room2str = level.getString(APP_PREFERENCES_ROOM2, "");
        if(room2str.length()==220) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 21; j >= 0; j--) {
                    room2[i][j] = Integer.parseInt(String.valueOf(room2str.charAt(i*22+j)));
                }
            }
        }
        else {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                room2[i][j] = 0;
            }
        }
        room2[0][0] = 2;
        room2[9][21] = 3;}



        String room3str = level.getString(APP_PREFERENCES_ROOM3, "");
        if(room3str.length()==220) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 21; j >= 0; j--) {
                    room3[i][j] = Integer.parseInt(String.valueOf(room3str.charAt(i*22+j)));
                }
            }
        }
        else {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                room3[i][j] = 0;
            }
        }
        room3[0][0] = 2;
        room3[9][21] = 3;}



        setContentView(new GameView(this,room1 , room2, room3, mode, level, APP_PREFERENCES, APP_PREFERENCES_ROOM1, APP_PREFERENCES_ROOM2, APP_PREFERENCES_ROOM3));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        level = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = level.edit();
//
        String strRoom1 = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                strRoom1 = strRoom1 + room1[i][j];
            }
        }

        String strRoom2 = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                strRoom2 = strRoom2 + room2[i][j];
            }
        }

        String strRoom3 = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                strRoom3 = strRoom3 + room3[i][j];
            }
        }

//
        editor.putString(APP_PREFERENCES_ROOM1, strRoom1);
        editor.putString(APP_PREFERENCES_ROOM2, strRoom2);
        editor.putString(APP_PREFERENCES_ROOM3, strRoom3);
        editor.apply();
    }
}