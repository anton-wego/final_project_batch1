package com.youduan.final_project_batch1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    TextView nama;
    TextView email;
    Button enter;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPreferences();

        nama = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        enter = (Button) findViewById(R.id.enterBtn);
        exit = (Button) findViewById(R.id.exitBtn);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nama.getText().toString().equals("") && !email.getText().toString().equals("")) {
                    startPreferences();
                    namaString = nama.getText().toString();
                    emailString = email.getText().toString();
                    setData("name", namaString);
                    setData("email", emailString);
                    Intent k = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(k);
                } else {
                    Toast.makeText(getApplicationContext(), "Silahkan masukan Nama Anda dan Email anda", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    };
};
