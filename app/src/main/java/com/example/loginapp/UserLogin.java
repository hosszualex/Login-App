package com.example.loginapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Button loginButton = findViewById(R.id.button_login);

        final String x1 = "hosszualex99@gmail.com";
        final String x2 = "1234";

        final EditText email = findViewById(R.id.edit_text_email);
        final EditText pass = findViewById(R.id.edit_text_password);
        final TextView error = findViewById(R.id.textview_error);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setText("");
                email.setHintTextColor(Color.GRAY);
                pass.setHintTextColor(Color.GRAY);
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setText("");
                email.setHintTextColor(Color.GRAY);
                pass.setHintTextColor(Color.GRAY);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals(x1)&&pass.getText().toString().equals(x2))
                {
                    Intent loginIntent = new Intent(getApplicationContext(), HomeScreen.class);
                    loginIntent.putExtra("KEY",x1);
                    startActivity(loginIntent);
                }
                else
                {
                    if(email.getText().toString().equals(""))
                    {
                        email.setHintTextColor(Color.RED);
                        email.setHint("Input an e-mail");
                    }
                    if(pass.getText().toString().equals(""))
                    {
                        pass.setHintTextColor(Color.RED);
                        pass.setHint("Input a password");
                    }

                    if((!email.getText().toString().equals("") && !email.getText().toString().equals(x1))||
                            (!pass.getText().toString().equals("")&&!pass.getText().toString().equals(x2)))
                        error.setText("e-mail and/or password are invalid");
                }
            }
        });

    }
}
