package com.youduan.final_project_batch1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MinumanActivity extends BaseActivity {
    ListView drinkList;
    Button addToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);

        getData();
        addToCart = (Button) findViewById(R.id.addToCart);

        drinkList = (ListView) findViewById(R.id.menuFood);
        CustomFoodListAdapter adapter = new CustomFoodListAdapter(this, drink, drink_images, "buy_drink");
        drinkList.setAdapter(adapter);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Integer index = 0; index < drinkList.getCount(); index++) {
                    View c = drinkList.getChildAt(index);
                    TextView a = (TextView) c.findViewWithTag("counter");

                    buy_drink[index] = Integer.parseInt(a.getText().toString());
                    setData(("buy_drink"+index), a.getText().toString());
                }

                calculate();
                finish();
            }
        });
    }
}
