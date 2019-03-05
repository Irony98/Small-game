package com.example.game;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set font
        TextView text=(TextView)findViewById(R.id.btn_record);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"fonts/Elgethy Est Square.ttf");
        text.setTypeface(typeFace);
        text=(TextView)findViewById(R.id.btn_start);
        text.setTypeface(typeFace);

    }

    public void startClick(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, PlaygameActivity.class);
        startActivity(intent);
    }
    public void goRecord(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, recordActivity.class);
        startActivity(intent);
    }
}
