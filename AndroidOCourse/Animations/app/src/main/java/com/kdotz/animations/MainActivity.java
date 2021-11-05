package com.kdotz.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean bartIsShowing = true;

    public void fade (View view){

        Log.i("info", "Image view tapped");

        ImageView homer = (ImageView) findViewById(R.id.imageView2);

//        if(bartIsShowing) {
//            bart.animate().alpha(0).setDuration(2000);
//            homer.animate().alpha(1).setDuration(2000);
//            bartIsShowing = false;
//        } else {
//            bart.animate().alpha(1).setDuration(2000);
//            homer.animate().alpha(0).setDuration(2000);
//            bartIsShowing = true;
//        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bart = (ImageView) findViewById(R.id.imageView);

        bart.setX(-1000);
        bart.animate().translationXBy(1000).rotation(3600).setDuration(2000);
    }
}
