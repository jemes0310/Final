package com.example.user.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button nirl, nirr;
    TextView nb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nirl = findViewById(R.id.irl);
        nirr = findViewById(R.id.irr);
        nb = findViewById(R.id.b);

        nirl.setOnClickListener(this);
        nirr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.irl:
                Intent login = new Intent(MainActivity.this, login.class);
                startActivity(login);
                break;
            case R.id.irr:
                Intent registrar = new Intent(MainActivity.this, ragistrar.class);
                startActivity(registrar);
                break;
        }
    }
}


