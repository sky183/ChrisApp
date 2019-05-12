package com.example.chrisapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends Activity {

    Button button;
    Button button2;
    Button button3;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //URL로 이미지 가져오기 위해 필수!!
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //문자열 데이터를 저장하는데 사용할 ArrayList 객체 생성
        List<String[]> list = new ArrayList<>();

        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2016/12/05/AAP1452.png", "MILEAGE PLATINUM"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2016/11/08/AAP1248.png", "삼성카드 4"});
        list.add(new String[]{"http://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/05/04/AAP1483_s.png", "삼성카드 taptap O"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2017/12/21/AAP1151_s.png", "American Express® Green"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/05/04/AAP1482_s.png", "삼성카드 taptap S"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/07/23/AAP1562_s.png", "삼성카드 2 V3"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/07/23/AAP1567_s.png", "삼성카드 5 V3"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2019/02/21/AAP1602_s.png", "트레이더스신세계 삼성카드"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/07/23/AAP1565_s.png", "삼성카드 4 V3"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/07/23/AAP1563_s.png", "삼성카드 3 V3 (SK에너지)"});
        list.add(new String[]{"https://static11.samsungcard.com/wcms/scard/personal/__icsFiles/afieldfile/2018/05/10/AAP1521_s.png", "삼성 페이 삼성카드 taptap"});

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

                // strText 를 사용하여 토스트 알림을 띄운다.
                Toast.makeText(MainActivity2.this, strText, Toast.LENGTH_SHORT).show();

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

                startActivity(intent); //다음화면으로 넘어감

                //화면 이동시 전환 효과 없앰
                overridePendingTransition(0, 0);

            }
        });


        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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


    }
}