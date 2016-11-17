package com.youduan.final_project_batch1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by youduan on 11/16/16.
 */

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] items;
    private final Integer[] images;

    public CustomListAdapter(Activity context, String[] items, Integer[] images) {
        super(context, R.layout.list, items);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.items = items;
        this.images = images;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.itemText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(items[position]);
        imageView.setImageResource(images[position]);
        return rowView;
    };

}
