package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final TextView welcome = findViewById(R.id.textview_welcome);

        Intent iUsername = getIntent();
        final String email_passed = iUsername.getStringExtra("KEY");

        final String username = email_passed.substring(0,email_passed.indexOf("@"));

        welcome.setText("Welcome to the ZOO, " +username+ "!");

    }
}
