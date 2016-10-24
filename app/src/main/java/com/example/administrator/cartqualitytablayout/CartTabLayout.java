package com.example.administrator.cartqualitytablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 知其然，而后知其所以然
 * 倔强小指，成名在望
 * 作者： Tomato
 * on 2016/10/24 0024.
 * com.example.carttab
 * 功能、作用：
 */
public class CartTabLayout extends LinearLayout implements View.OnClickListener {

    private Button btn_dec;
    private TextView txt_count;
    private Button btn_inc;
    private int value = 1;
    private int minValue = 1;
    private int maxValue = 20;
    private OnValueClickListener listener;

    public void setValueClickListener(OnValueClickListener listener) {
        this.listener = listener;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public CartTabLayout(Context context) {
        this(context,null);
    }

    public CartTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CartTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //第三个参数：加载布局的时候，将其作为它的父布局
        View.inflate(context,R.layout.tab_layout,CartTabLayout.this);
        btn_dec = (Button) findViewById(R.id.btn_tab_dec);
        txt_count = (TextView) findViewById(R.id.txt_tab_count);
        btn_inc = (Button) findViewById(R.id.btn_tab_inc);
        txt_count.setText(String.valueOf(value));

        btn_dec.setOnClickListener(this);
        btn_inc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tab_dec:
                decCount();
                listener.onClickDec(v,value);
                break;
            case R.id.btn_tab_inc:
                incCount();
                listener.onClickInc(v,value);
                break;
        }
    }

    private void incCount() {
        if (value < maxValue){
            value += 1;
        }
        txt_count.setText(String.valueOf(value));
    }

    private void decCount() {
        if (value > minValue){
            value -= 1;
        }
        txt_count.setText(String.valueOf(value));
    }

    interface OnValueClickListener{
        void onClickDec(View view, int value);
        void onClickInc(View view, int value);
    }
}
