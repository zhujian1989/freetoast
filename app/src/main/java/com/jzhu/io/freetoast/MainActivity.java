package com.jzhu.io.freetoast;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.jzhu.io.toastlibrary.FreeToast;
import com.jzhu.io.toastlibrary.FreeToastUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndListeners();
    }

    private void initViewsAndListeners(){
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.mipmap.ic_error_outline_white_24dp);
        int textSize = 16;
        int textColor = res.getColor(R.color.C1);
        int tintColor = res.getColor(R.color.C14);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/americantypewriter.ttf");

        switch (v.getId()){
            case R.id.btn1:
                FreeToast.toastShort(this,res.getString(R.string.btn1)).show();
                break;
            case R.id.btn2:
                FreeToast.toastWithOutIcon(this, res.getString(R.string.btn2),Toast.LENGTH_SHORT,textSize,textColor,tintColor,typeface).show();
                break;
            case R.id.btn3:
                FreeToast.toastWithIcon(this, res.getString(R.string.btn3), Toast.LENGTH_SHORT, drawable, FreeToastUtils.DRAWABLE_LEFT).show();
                break;
            case R.id.btn4:
                FreeToast.toastAllAttr(this, res.getString(R.string.btn4), Toast.LENGTH_SHORT, drawable, FreeToastUtils.DRAWABLE_TOP,textSize,textColor,tintColor,typeface).show();
                break;
        }
    }
}
