package com.youduan.final_project_batch1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by youduan on 11/16/16.
 */

public class CustomFoodListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] items;
    private final Integer[] images;
    private Integer maxBuy = 100;
    private String type_list;


    public CustomFoodListAdapter(Activity context, String[] items, Integer[] images,String type_list) {
        super(context, R.layout.food_list, items);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.items = items;
        this.images = images;
        this.type_list = type_list;
    }

    public String getSingleData(String key){
        SharedPreferences preferences = context.getSharedPreferences("Final_Project", Context.MODE_PRIVATE);
        String valueString = preferences.getString(key, "");
        if(!valueString.equalsIgnoreCase("")){
            //nothing
        } else {
            valueString = "0";
        }

        return valueString;
    }

    public View getView(int position, View view, final ViewGroup parent) {
        final RowItem rowItem;

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.food_list, null,true);

        rowItem = new RowItem((TextView) rowView.findViewById(R.id.itemText), (TextView) rowView.findViewById(R.id.count),
                (ImageView) rowView.findViewById(R.id.icon), (Button) rowView.findViewById(R.id.add), (Button) rowView.findViewById(R.id.min));

        String key = this.type_list + position;

        rowItem.counter.setText(getSingleData(key));
        rowItem.setBuy(Integer.parseInt(rowItem.counter.getText().toString()));

        rowItem.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rowItem.getBuy() > maxBuy){
                    Toast.makeText(context, "Anda nya bisa membeli sebanyak :"+ maxBuy, Toast.LENGTH_SHORT).show();
                } else{
                    Integer currentBuy = rowItem.getBuy();
                    currentBuy++;
                    rowItem.setBuy(currentBuy);
                    rowItem.counter.setText(rowItem.getBuy().toString());
                }
            }
        });

        rowItem.minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rowItem.getBuy() <= 0){
                    // nothing
                } else {
                    Integer currentBuy = rowItem.getBuy();
                    currentBuy--;
                    rowItem.setBuy(currentBuy);
                    rowItem.counter.setText(rowItem.getBuy().toString());
                }
            }
        });

        rowItem.txtTitle.setText(items[position]);
        rowItem.imageView.setImageResource(images[position]);
        return rowView;
    };
}
