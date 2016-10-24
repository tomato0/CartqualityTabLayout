package com.example.administrator.cartqualitytablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CartTabLayout.OnValueClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CartTabLayout layout = (CartTabLayout) findViewById(R.id.value_btn_layout);
        layout.setValueClickListener(this);
    }

    @Override
    public void onClickDec(View view, int value) {
        Toast.makeText(MainActivity.this, "减了"+String.valueOf(value), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickInc(View view, int value) {
        Toast.makeText(MainActivity.this, "加了"+String.valueOf(value), Toast.LENGTH_SHORT).show();
    }
}
