package com.example.chrisapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //다이얼로그 내부클래스 빌더 객체 builder 생성
        builder.setTitle("아날로그 엔진 종료"); //다이얼로그의 제목
        builder.setMessage("아날로그 엔진을 종료하시겠습니까?")  //다이얼로그의 내용
                .setCancelable(false)  //뒤로가기나 배경 터치로 다이얼로그를 취소하는 행위를 못하게 함
                .setPositiveButton("확인", new DialogInterface.OnClickListener() { //확인 버튼 이벤트
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish(); //페이지 종료
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() { //캔슬 버튼 이벤트
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel(); //다이얼로그를 끈다.
                    }
                });
        AlertDialog alert = builder.create(); //빌더 객체의 create 메서드로 다이얼로그 객체를 생성한다.
        alert.show(); //다이얼로그를 보여준다.

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
//        backPressCloseHandler = new BackPressCloseHandler(this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent); //다음화면으로 넘어감
                overridePendingTransition(0,0);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent); //다음화면으로 넘어감
                overridePendingTransition(0,0);
            }
        });

       /* button.setOnClickListener(new View.OnClickListener() {
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
        });*/


    }
}
