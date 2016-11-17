package com.youduan.final_project_batch1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends BaseActivity {
    ListView menuList;
    TextView total;
    Button checkout;

    String[] items = new String[]{
            "Makanan",
            "Minuman"
    };
    Integer[] images = {
            R.drawable.makanan,
            R.drawable.minuman
    };

    boolean shouldExecuteOnResume = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shouldExecuteOnResume = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getData();

        total = (TextView) findViewById(R.id.GrandTotal);
        total.setText("Total : Rp "+ grandTotal);

//        ActivityManager mActivityManager =(ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);

//        String mPackageName;
//        if(Build.VERSION.SDK_INT > 20){
//             mPackageName = mActivityManager.getRunningAppProcesses().get(0).processName;
//        }
//        else{
//            mPackageName = mActivityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
//        }

//        Toast.makeText(getApplicationContext(), "+"+ emailString, Toast.LENGTH_SHORT).show();


        checkout = (Button) findViewById(R.id.checkout);
        menuList = (ListView) findViewById(R.id.menuList);
        CustomListAdapter adapter = new CustomListAdapter(this, items, images);
        menuList.setAdapter(adapter);



        // listener
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item value
                String  itemValue    = (String) menuList.getItemAtPosition(position);

                switch (itemValue){
                    case "Makanan":
                        Intent food = new Intent(MenuActivity.this, MakananActivity.class);
                        startActivity(food);
                        break;
                    case "Minuman":
                        Intent drink = new Intent(MenuActivity.this, MinumanActivity.class);
                        startActivity(drink);
                        break;
                }
            }

        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(grandTotal == 0){
                    Toast.makeText(getApplicationContext(),
                        "Anda belum memilih menu makanan. Silahkan pilih orderan Anda" , Toast.LENGTH_SHORT)
                        .show();
                } else{
                    Intent order = new Intent(MenuActivity.this, OrderActivity.class);
                    startActivity(order);
                }

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        getData();
        total.setText("Total : Rp "+ grandTotal);
    }
}
