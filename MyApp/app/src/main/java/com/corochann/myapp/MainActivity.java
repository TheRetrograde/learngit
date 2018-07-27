package com.corochann.myapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {
    //private TextView mTextView01;
    //private TextView mTextView02;
    private Button b;
    private TextView view_butun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       /* mTextView01 = (TextView) findViewById(R.id.myTextView01);
        String str_2 = "Android TextVeiw你好！！！";
        mTextView01.setText(str_2);

        //Resources resources = getBaseContext().getResources();
        //Drawable HippoDrawable = resources.getDrawable(R.drawable.lb_card_foreground);
        //mTextView01.setBackgroundDrawable(HippoDrawable);
        mTextView01.setTextColor(Color.GREEN);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        String strOpt="高清屏屏幕分辨率为："+dm.widthPixels + "x" +dm.heightPixels;
        mTextView02=(TextView)findViewById(R.id.myTextView02);
        mTextView02.setText(strOpt);*/


        b = (Button)findViewById(R.id.button);
        view_butun = (TextView)findViewById(R.id.view_text);

        b.setOnClickListener(new Button.OnClickListener(){
            boolean flag=true;
            public void onClick(View view) {
                if(flag ){
                    view_butun.setText("Hi,Everyone");
                    jumpToLayout2();
                    flag=false;
                }else
                {
                    view_butun.clearComposingText();
                    flag = true;
                }
            }
        });

        Button b2 = (Button)findViewById(R.id.button_activity);
        b2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Activity2.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
        });
        Button bcalc = (Button)findViewById(R.id.button_calac);
        bcalc.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText et = (EditText)findViewById(R.id.height);
                double height = Double.parseDouble(et.getText().toString());
                String sex="";
                RadioButton rb = (RadioButton)findViewById(R.id.sex1);
                if(rb.isChecked())
                {
                    sex="M";
                }else
                {
                    sex="F";
                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Activity2.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                intent.putExtras(bundle);
                //startActivity(intent);
               // MainActivity.this.finish();
                startActivityForResult(intent,0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode)
        {
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String sex = bundle.getString("sex");
                double height = bundle.getDouble("height");

                EditText et = (EditText)findViewById(R.id.height);
                et.setText(""+height);
                if(sex.equals("M")){
                    RadioButton rb1 = (RadioButton)findViewById(R.id.sex1);
                    rb1.setChecked(true);
                }
                else
                {
                    RadioButton rb2 = (RadioButton)findViewById(R.id.sex2);
                    rb2.setChecked(true);
                }
                break;
            default:
                Log.d("wx","default");
                break;
        }
    }

    public void jumpToLayout2()
    {
        setContentView(R.layout.layout2);
        Button b2 = (Button) findViewById(R.id.bt2);
        b2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                jumpToLayout1();
            }
        });
    }

    public void jumpToLayout1()
    {
        setContentView(R.layout.activity_main2);
        Button b1 = (Button) findViewById(R.id.button) ;
        b1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                jumpToLayout2();
            }
        });
    }

}
