package com.example.kingofread;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter {
    private String[] bookTitles;
    private String[] bookDescriptions;
    private Integer[] bookCovers;
    private Activity activity;

    public DataAdapter(Activity activity, String[] bookTitles,String[] bookDescriptions, Integer[] bookCovers){
        this.activity = activity;
        this.bookTitles = bookTitles;
        this.bookDescriptions = bookDescriptions;
        this.bookCovers = bookCovers;
    }

    @Override
    public int getCount() {
        return bookTitles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //goi layoutinflater de bat dau anh xa view va data
        LayoutInflater inflater = activity.getLayoutInflater();

        //do data vao bien view, view này chính là những gì nằm trong item_text.xml
        view = inflater.inflate(R.layout.row_layout, null);

        // dat chu cho tung view trong danh sach
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_book_title);
        TextView tvDescription = (TextView) view.findViewById(R.id.tv_book_description);
        ImageView ivCover = (ImageView) view.findViewById(R.id.iv_book_cover);

        tvTitle.setText(bookTitles[position]);
        tvDescription.setText(bookDescriptions[position]);
        ivCover.setImageResource(bookCovers[position]);

        //tra ve view ket qua
        return view;
    }
}
