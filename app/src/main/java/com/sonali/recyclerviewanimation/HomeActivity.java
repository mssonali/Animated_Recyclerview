package com.sonali.recyclerviewanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnfalldown;
    Button btnRight;
    Button btnBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getControls();
    }

    public void getControls() {
        btnfalldown = findViewById(R.id.btn1);
        btnRight = findViewById(R.id.btn2);
        btnBottom = findViewById(R.id.btn3);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case 1:
                Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(mainIntent);
                break;
            case 2:
                /*Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(mainIntent);*/
                break;
            case 3:
                /*Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(mainIntent);*/
                break;
        }
    }
}
