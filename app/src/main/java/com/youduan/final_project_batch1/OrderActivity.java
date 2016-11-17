package com.youduan.final_project_batch1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class OrderActivity extends BaseActivity {
    TextView summary;
    Button back;
    Button order;
    String summaryOrder = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getData();
        summary = (TextView) findViewById(R.id.summary);
        back = (Button) findViewById(R.id.back);
        order = (Button) findViewById(R.id.order);




        summaryOrder += "Hi " + namaString + ",\n" +
                "Terima kasih atas order nya \n" +
                "berikut order nya : \n" +
                "Makanan: \n";


        for(Integer index = 0; index< Array.getLength(buy_food); index++){
//            if(buy_food[index] != 0){
                Integer total = (buy_food[index] * food_prices[index]);
                summaryOrder += buy_food[index] + " (" + food[index] + ") @Rp"+ food_prices[index] +" : "+total+"  \n";
//            }
        }

        summaryOrder += "\nMinuman: \n";
        for(Integer index = 0; index< Array.getLength(buy_drink); index++){
//            if(buy_drink[index] != 0){
                Integer total = (buy_drink[index] * drink_prices[index]);
                summaryOrder += buy_drink[index] + " (" + drink[index] + ")@Rp"+ drink_prices[index] +" : "+total+"  \n";
//            }
        }

        summaryOrder += "\nTotal: "+ grandTotal;

        summary.setText(summaryOrder);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Anda belum memilih menu makanan. Silahkan pilih ordera123123n Anda" , Toast.LENGTH_SHORT)
                        .show();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailString});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Summary Order");
                emailIntent.putExtra(Intent.EXTRA_TEXT   , summaryOrder);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getApplicationContext(),
                        "Anda belum memilih menu makanan. Silahkan pilih 1232333 Anda" , Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
