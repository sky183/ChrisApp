package com.example.chrisapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DetailActivity1 extends Activity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1detail);

        //URL로 이미지 가져오기 위해 필수!!
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView tvTitle = (TextView)findViewById(R.id.textView1);
        TextView tvTitle2 = (TextView)findViewById(R.id.textView2);
        ImageView iv = (ImageView)findViewById(R.id.imageView1);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
//        iv.setImageResource(intent.getIntExtra("img", 0));

        try {
            URL url = new
                    URL(intent.getStringExtra("img"));
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream stream = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            stream.close();
            iv.setImageBitmap(bitmap);
        } catch (Exception e) {
        }

        tvTitle.setText(intent.getStringExtra("title"));
        tvTitle2.setText(intent.getStringExtra("title2"));

    } // end of onCreate
}
