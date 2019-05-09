package com.example.chrisapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ImageAdapter extends ArrayAdapter<String> {
    public ImageAdapter(Context context, String[] items) {
        super(context, R.layout.list_item, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //컨텍스트를 가져와 레이아웃을 불러준다.
        LayoutInflater imageInflater = LayoutInflater.from(getContext());
        View view = imageInflater.inflate(R.layout.list_item, parent, false);
        //
        String item = getItem(position);
        //디자인에서 텍스트와 이미지를 가져와 객체로 만들어준다.
        TextView textView = (TextView)view.findViewById(R.id.textView1);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView1);
        //가져온 아이템을 넣어준다.
        textView.setText(item);
        imageView.setImageResource(R.mipmap.facebook);

        return view;
    }
}
