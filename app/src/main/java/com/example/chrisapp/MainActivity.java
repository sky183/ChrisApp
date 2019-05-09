package com.example.chrisapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    //    리스트뷰에 표시할 값
    public String[] LIST_MENU = {
            "LIST1", "LIST2", "LIST3", "LIST4", "LIST5",
            "LIST6", "LIST7", "LIST8", "LIST9", "LIST10",
            "LIST11", "LIST12", "LIST13", "LIST14", "LIST15",
    };


    Button button;
    Button button2;
    Button button3;

    //뷰 생성 및 출력
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //activity_main.xml을 화면에 표시해 준다.
        setContentView(R.layout.activity_main);

        //문자열 데이터를 저장하는데 사용할 ArrayList 객체 생성
        List<String[]> list = new ArrayList<>();

        list.add(new String[]{"facebook", "페북 카드"});
        list.add(new String[]{"", ""});

        //리스트뷰에 연결하기 위한 어댑터 생성자
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);
        ArrayAdapter adapter = new ImageAdapter(this, LIST_MENU);
        //리스트뷰 id를 찾아 리스트뷰 객체 만들어서 어댑터를 할당한다.
        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        //리스트뷰를 클릭할 때 이벤트를 걸어 사용한다.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 텍스트뷰에 있는 텍스트를 얻는다.
                String strText = (String) parent.getItemAtPosition(position);

                // strText 를 사용하여 토스트 알림을 띄운다.
                Toast.makeText(MainActivity.this, strText, Toast.LENGTH_SHORT).show();
            }
        });

        //각 버튼의 뷰 아이디를 찾아 버튼 객체에 할당한다.
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

//        다른 페이지 버튼을 터치했을때 화면 전환한다.
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent); //다음화면으로 넘어감
                overridePendingTransition(0, 0);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent); //다음화면으로 넘어감
                overridePendingTransition(0, 0);
            }
        });

    }

    @Override
    public void onBackPressed() {

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
}
