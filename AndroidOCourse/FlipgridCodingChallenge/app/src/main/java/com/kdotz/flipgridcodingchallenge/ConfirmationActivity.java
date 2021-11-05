package com.kdotz.flipgridcodingchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    TextView firstName;
    TextView email;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        firstName = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);

        firstName.setText(getIntent().getStringExtra("firstName"));
        email.setText(getIntent().getStringExtra("email"));
    }
}
