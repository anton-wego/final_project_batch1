package com.youduan.final_project_batch1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;

/**
 * Created by youduan on 11/16/16.
 */

public class BaseActivity extends AppCompatActivity {
    public String namaString;
    public String emailString;
    Integer grandTotal=0;
    String[] food = new String[]{
            "1 telur",
            "2 telur",
            "Roti kecil",
            "Roti besar",
    };
    Integer[] food_images = {
            R.drawable.one_egg,
            R.drawable.two_egg,
            R.drawable.bread_small,
            R.drawable.bread_big
    };

    Integer[] food_prices = {
            5000,
            7500,
            6000,
            10000
    };
    Integer[] buy_food = {
            0,
            0,
            0,
            0
    };


    String[] drink = new String[]{
            "Kopi besar",
            "Kopi kecil"
    };
    Integer[] drink_images = {
            R.drawable.coffee_big,
            R.drawable.coffee_small
    };

    Integer[] drink_prices = {
            15000,
            12500
    };
    Integer[] buy_drink = {
            0,
            0
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        if (id == R.id.action_exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    };

    public void setData(String key, String value){
        SharedPreferences sharedpreferences = getSharedPreferences("Final_Project", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);

        editor.commit();
    }

    public void startPreferences(){
        setData("name", "");
        setData("email", "");
        setData("grandTotal", "0");

        for(Integer index=0; index<Array.getLength(buy_food); index++){
            setData(("buy_food"+index), "0");
        }

        for(Integer index = 0; index< Array.getLength(buy_drink); index++){
            setData(("buy_drink"+index), "0");
        }
    }

    public void getData(){
        SharedPreferences preferences = getSharedPreferences("Final_Project", Context.MODE_PRIVATE);
        namaString = preferences.getString("name", "");
        emailString = preferences.getString("email", "");
        String grandTotalString = preferences.getString("grandTotal", "");
        if(!grandTotalString.equalsIgnoreCase("")){
            grandTotal = Integer.parseInt(grandTotalString);
        }

        for(Integer index=0; index<Array.getLength(buy_food); index++){
            String value =  preferences.getString(("buy_food"+index), "");
            if(!value.equalsIgnoreCase("")){
                buy_food[index] = Integer.parseInt(value);
            }
        }

        for(Integer index = 0; index< Array.getLength(buy_drink); index++){
            String value =  preferences.getString(("buy_drink"+index), "");
            if(!value.equalsIgnoreCase("")){
                buy_drink[index] = Integer.parseInt(value);
            }
        }
    }

    public void calculate(){
        grandTotal = 0;
        for(Integer index=0; index<Array.getLength(buy_food); index++){
            grandTotal = grandTotal + (buy_food[index] * food_prices[index]);
        }

        for(Integer index = 0; index< Array.getLength(buy_drink); index++){
            grandTotal = grandTotal + (buy_drink[index] * drink_prices[index]);
        }

        setData("grandTotal", grandTotal.toString());
    }
}
