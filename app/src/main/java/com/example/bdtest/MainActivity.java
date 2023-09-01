package com.example.bdtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btnStart, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        btnStart = findViewById(R.id.btnStart);
        btnEdit = findViewById(R.id.btnEdit);

         btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mode = "2";
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                intent.putExtra("mode", mode);
                startActivity(intent);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mode = "1";
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                intent.putExtra("mode", mode);
                startActivity(intent);
            }
        });
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        level = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = level.edit();
//
//        String strRoom1 = ed1.getText().toString();
//        String strRoom2 = ed2.getText().toString();
//
//        editor.putString(APP_PREFERENCES_ROOM1, strRoom1);
//        editor.putString(APP_PREFERENCES_ROOM2, strRoom2);
//        editor.apply();
//    }
}