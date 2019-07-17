package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Button loginButton = findViewById(R.id.button_login);


        //available user
        final String x1 = "hosszualex99@gmail.com";
        final String x2 = "1234";

        final EditText email = findViewById(R.id.edit_text_email);
        final EditText pass = findViewById(R.id.edit_text_password);
        final TextView error = findViewById(R.id.textview_error);

        final String PREFS_NAME = "PrefsFile";
        final SharedPreferences mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        final CheckBox keepSigned = findViewById(R.id.checkBox_sign);




      // sets the texts back to gray
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

                //if the username and password are valid
                if(email.getText().toString().equals(x1)&&pass.getText().toString().equals(x2))
                {



                    //if the checkButton is on, saves the user information
                    if(keepSigned.isChecked()){

                        Boolean isChecked = keepSigned.isChecked();
                        SharedPreferences.Editor editor = mPrefs.edit();
                        editor.putString("prefs_name", email.getText().toString());
                        editor.putString("prefs_pass", pass.getText().toString());
                        editor.putBoolean("prefs_check",isChecked);
                        editor.apply();
                        Toast.makeText(getApplicationContext(),"Settings have been saved", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        mPrefs.edit().clear().apply();
                    }

                    //pass the username and go to the next activity
                    Intent loginIntent = new Intent(getApplicationContext(), HomeScreen.class);
                   loginIntent.putExtra("KEY",x1);
                    startActivity(loginIntent);

                    email.getText().clear();
                    pass.getText().clear();
                }
                else
                {
                    //error checks
                    if(email.getText().toString().equals(""))
                    {
                        email.setError("Input an e-mail");
                        email.requestFocus();
                    }
                    if(pass.getText().toString().equals(""))
                    {
                        pass.setError("Input a password");
                        pass.requestFocus();

                    }

                    //if the email or password is/are invalid
                    if((!email.getText().toString().equals("") && !email.getText().toString().equals(x1))||
                            (!pass.getText().toString().equals("")&&!pass.getText().toString().equals(x2)))
                        error.setText("e-mail and/or password are invalid");
                }
            }
        });


       SharedPreferences sp = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        if(sp.contains("prefs_name")){
            String u = sp.getString("prefs_name", "not found");
            email.setText(u.toString());
        }
        if(sp.contains("prefs_pass")){
            String p = sp.getString("prefs_pass", "not found");
            pass.setText(p.toString());
        }
        if(sp.contains("prefs_check")){
            Boolean b = sp.getBoolean("prefs_check", false);
            keepSigned.setChecked(b);
        }
        if(sp.contains("prefs_check"))
            {
        Intent loginIntent = new Intent(getApplicationContext(), HomeScreen.class);
        loginIntent.putExtra("KEY",x1);
        startActivity(loginIntent);

            }

    }
}
