# CartqualityTabLayout
this is a layout for cart to add and dec shop

在制作购物车的时候需要在ListView中添加加减和统计商品的一个小模块，
为了在以后方便使用，自定义了一个小模版

##使用方式
###在布局文件下添加如下代码
    <com.example.carttab.CartTabLayout
        android:id="@+id/value_btn_layout"
        android:layout_centerInParent="true"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
        
  此处后面会更进一些属性设置      
        
##在Activity中
通过findViewById找到控件后
CartTabLayout layout = (CartTabLayout) findViewById(R.id.value_btn_layout);
        
        可以通过setMinValue、setMaxValue的属性设置上下限制，
        实际购物车中minValue不应该小与1， 
        maxValue最大值不应该超过库存
        
        
##返回数值的接口口回调

layout.setValueClickListener(this);


@Override
    public void onClickDec(View view, int value) {
    //减少按钮回调监听
    
        Toast.makeText(MainActivity.this, "减了"+String.valueOf(value), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickInc(View view, int value) {
    //增加按钮回调监听
    
        Toast.makeText(MainActivity.this, "加了"+String.valueOf(value), Toast.LENGTH_SHORT).show();
    }
