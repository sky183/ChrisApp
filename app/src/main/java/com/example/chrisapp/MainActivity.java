package com.example.chrisapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button button;
    Button button2;
    Button button3;

//    private BackPressCloseHandler backPressCloseHandler;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
                /*backPressCloseHandler.onBackPressed();*/ //뒤로 두번 누르면 종료하기 기능
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("아날로그 엔진 종료");
        builder.setMessage("아날로그 엔진을 종료하시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
//        backPressCloseHandler = new BackPressCloseHandler(this);

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
