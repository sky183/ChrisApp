package com.example.chrisapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ImageAdapter extends ArrayAdapter<String> {

    List<String[]> list;

    public ImageAdapter(Context context, List items) {
        super(context, R.layout.list_item, items);
        list = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //뷰홀더 생성
        ViewHolder vh = new ViewHolder();
        //각 포지션의 값을 가져온다.(이미지 경로, 표시할 텍스트 등)
        String[] item = list.get(position);
        String itemUrl = item[0];
        String itemText = item[1];
        String itemText2 = item[2];

        if (convertView == null) {
            //컨텍스트를 가져와 레이아웃을 불러준다.
            LayoutInflater imageInflater = LayoutInflater.from(getContext());
            convertView = imageInflater.inflate(R.layout.list_item, parent, false);

            vh.imageView = (ImageView) convertView.findViewById(R.id.imageView1);

            try {
                URL url = new
                        URL(itemUrl);
                URLConnection conn = url.openConnection();
                conn.connect();
                InputStream stream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(stream);
                stream.close();
                vh.imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
            }

            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        //디자인에서 텍스트와 이미지를 가져와 객체로 만들어준다.
        vh.textView = (TextView) convertView.findViewById(R.id.textView1);
//        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
        //가져온 아이템을 넣어준다.
        vh.textView.setText(itemText);
        vh.textView2.setText(itemText2);

        return convertView;
    }
}



        /*        String urldisplay = "https://media.alienwarearena.com/media/tux-r.jpg";
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            bitmap = BitmapFactory.decodeStream(in);
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

//        imageView.setImageResource(R.mipmap.facebook); //로컬 이미지 가져올때