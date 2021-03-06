package com.example.chrisapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    Button button;
    Button button2;
    Button button3;

    //뷰 생성 및 출력
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //activity_main.xml을 화면에 표시해 준다.
        setContentView(R.layout.activity_main);

        //URL로 이미지 가져오기 위해 필수!!
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //문자열 데이터를 저장하는데 사용할 ArrayList 객체 생성
        List<String[]> list = new ArrayList<>();

/*        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1452_s.png", "MILEAGE PLATINUM", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1248.png", "삼성카드 4", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1483_s.png", "삼성카드 taptap O", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1151_s.png", "American Express® Green", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1482_s.png", "삼성카드 taptap S", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1562_s.png", "삼성카드 2 V3", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1567_s.png", "삼성카드 5 V3", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1602_s.png", "트레이더스신세계 삼성카드", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1565_s.png", "삼성카드 4 V3", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1563_s.png", "삼성카드 3 V3 (SK에너지)", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.35.115/MyAppServer/photo1/AAP1521_s.png", "삼성 페이 삼성카드 taptap", "멋진카드입니다."});   */

        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1452_s.png", "MILEAGE PLATINUM", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1248.png", "삼성카드 4", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1483_s.png", "삼성카드 taptap O", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1151_s.png", "American Express® Green", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1482_s.png", "삼성카드 taptap S", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1562_s.png", "삼성카드 2 V3", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1567_s.png", "삼성카드 5 V3", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1602_s.png", "트레이더스신세계 삼성카드", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1565_s.png", "삼성카드 4 V3", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1563_s.png", "삼성카드 3 V3 (SK에너지)", "멋진카드입니다."});
        list.add(new String[]{"http://192.168.0.56/MyAppServer/photo1/AAP1521_s.png", "삼성 페이 삼성카드 taptap", "멋진카드입니다."});

        //리스트뷰에 연결하기 위한 어댑터 생성자
        ArrayAdapter adapter = new ImageAdapter(this, list);
        //리스트뷰 id를 찾아 리스트뷰 객체 만들어서 어댑터를 할당한다.(원하는 리스트뷰에 list_item을 표시)
        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        //리스트뷰를 클릭할 때 이벤트
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 텍스트뷰에 있는 텍스트를 얻는다.
                String[] text = (String[]) parent.getItemAtPosition(position);
                String imgText = text[0];
                String strText = text[1];
                String contentText = text[2];

                // strText 를 사용하여 토스트 알림을 띄운다.
                Toast.makeText(MainActivity.this, strText, Toast.LENGTH_SHORT).show();

                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다
                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        DetailActivity1.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("img", imgText);
                intent.putExtra("title", strText);
                intent.putExtra("content", contentText);

                startActivity(intent); //다음화면으로 넘어감

                //화면 이동시 전환 효과 없앰
                overridePendingTransition(0, 0);

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

        final Activity act = this;

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //다이얼로그 내부클래스 빌더 객체 builder 생성
        builder.setTitle("아날로그 엔진 종료"); //다이얼로그의 제목
        builder.setMessage("아날로그 엔진을 종료하시겠습니까?")  //다이얼로그의 내용
                .setCancelable(false)  //뒤로가기나 배경 터치로 다이얼로그를 취소하는 행위를 못하게 함
                .setPositiveButton("확인", new DialogInterface.OnClickListener() { //확인 버튼 이벤트
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        ActivityCompat.finishAffinity(act);
//                        finish(); //페이지 종료
//                        System.exit(0);
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
