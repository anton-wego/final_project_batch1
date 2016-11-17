package com.youduan.final_project_batch1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MakananActivity extends BaseActivity {
    ListView foodList;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        getData();
        addToCart = (Button) findViewById(R.id.addToCart);

        foodList = (ListView) findViewById(R.id.menuFood);
        CustomFoodListAdapter adapter = new CustomFoodListAdapter(this, food, food_images, "buy_food");
        foodList.setAdapter(adapter);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (Integer index = 0; index < foodList.getCount(); index++) {
                    View c = foodList.getChildAt(index);
                    TextView a = (TextView) c.findViewWithTag("counter");

                    buy_food[index] = Integer.parseInt(a.getText().toString());
                    setData(("buy_food"+index), a.getText().toString());
                }
                calculate();

                finish();
            }
        });
    }
}