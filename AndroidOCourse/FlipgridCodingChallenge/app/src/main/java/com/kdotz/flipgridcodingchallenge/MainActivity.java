package com.kdotz.flipgridcodingchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText emailAddress;
    EditText password;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        signUpButton = findViewById(R.id.sign_up_button);

        firstName.addTextChangedListener(textWatcher);
        emailAddress.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        isEnabled();
    }

    private void isEnabled() {
        if (firstName.getText().toString().equals("") || emailAddress.getText().toString().equals("") || password.getText().toString().equals("")) {
            signUpButton.setEnabled(false);
        } else {
            signUpButton.setEnabled(true);
        }
    }

    void onClick(View view) {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent confirmationIntent = new Intent(view.getContext(), ConfirmationActivity.class);
                confirmationIntent.putExtra("firstName", firstName.getText().toString() + "!");
                confirmationIntent.putExtra("email", emailAddress.getText().toString());
                startActivityForResult(confirmationIntent, 0);
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            isEnabled();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

}
