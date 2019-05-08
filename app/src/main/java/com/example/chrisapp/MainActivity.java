package com.example.chrisapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundResource(R.drawable.click1);
                button2.setBackgroundResource(R.drawable.buttonshape2);
                button3.setBackgroundResource(R.drawable.buttonshape3);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundResource(R.drawable.click2);
                button.setBackgroundResource(R.drawable.buttonshape);
                button3.setBackgroundResource(R.drawable.buttonshape3);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setBackgroundResource(R.drawable.click3);
                button.setBackgroundResource(R.drawable.buttonshape);
                button2.setBackgroundResource(R.drawable.buttonshape2);
            }
        });

    }
}
