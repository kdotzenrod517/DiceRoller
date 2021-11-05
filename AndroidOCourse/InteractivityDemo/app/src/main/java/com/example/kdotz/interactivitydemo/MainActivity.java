package com.example.kdotz.interactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean flag = false;

    public void clickFunction(View view) {

        ImageView image = (ImageView) findViewById(R.id.imageView);
        Log.i("Info", "Button Pressed!");
        switch (view.getId()) {
            case R.id.button2: {
                if (flag) {
                    image.setImageResource(R.drawable.unicorn);
                    flag = false;
                } else {
                    image.setImageResource(R.drawable.unicorn2);
                    flag = true;
                }
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
