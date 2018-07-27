package com.corochann.myapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Activity2 extends Activity {

    private Button button_alertDialog;
    private Button buttun_color;
    private TextView mText;
    private int[] mColors;
    private int colornum;

    private  Button sizeButton;
    private  Button frontButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Bundle bundle = this.getIntent().getExtras();
        final Intent intent=this.getIntent();
        String sex = bundle.getString("sex");
        double height = bundle.getDouble("height");
        String sextext="";
        if(sex.equals("M"))
        {
            sextext="男性";
        }else
        {
            sextext="女性";
        }
        String weight = this.getWeight(sex,height);
        TextView tv = (TextView) findViewById(R.id.text1);
        tv.setText("你是一位"+sextext+"\n你的身高是"+height+"厘米\n你的标准体重是"+weight+"公斤");
        Button b = (Button)findViewById(R.id.button_activity_2);
        b.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {

                //intent.setClass(Activity2.this,MainActivity.class);
                //startActivity(intent);
                //Activity2.this.finish();
                Activity2.this.setResult(RESULT_OK,intent);
                Activity2.this.finish();
            }
        });

        button_alertDialog = (Button)findViewById(R.id.button_alertdialog);
        button_alertDialog.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Activity2.this).setTitle(R.string.app_about)
                        .setMessage(R.string.app_about_msg).setPositiveButton(
                        R.string.str_ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }
                ).show();
            }
        });

        mColors = new int[]{Color.BLACK,Color.BLUE,Color.DKGRAY,Color.CYAN,Color.GRAY,Color.GREEN};
        colornum = 0;
        buttun_color = (Button)findViewById(R.id.buttun_color);
        mText = (TextView)findViewById(R.id.text3);
        buttun_color.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(colornum<mColors.length){
                    mText.setTextColor(mColors[colornum]);
                    colornum++;
                }else {
                    colornum = 0;
                }
            }
        });
        mText = (TextView)findViewById(R.id.text3);
        sizeButton = (Button)findViewById(R.id.buttun_size);
        sizeButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                mText.setTextSize(20);
            }
        });

        frontButton = (Button)findViewById(R.id.button_font);
        frontButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                mText.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/HandmadeTypewrite.tff"));
            }
        });
    }

    private String format(double num)
    {
        NumberFormat formatter = new DecimalFormat("0.00");
        String s=formatter.format(num);
        return s;
    }

    private String getWeight(String sex,double height)
    {
        String weight="";
        if(sex.equals("M"))
        {
            weight=format((height-80)*0.7);
        }else
        {
            weight=format((height-70)*0.6);
        }
       // return weight;
        //return weight;
        String weightr="";
        String weightsr="";
        return weight;
        Git is a distributed version control system.
            Git is free software distributed under the GPL
        Git has a mutable index called stage.
            Git tracks changes.
        My stupid boss still prefers SVN.

    }
}
