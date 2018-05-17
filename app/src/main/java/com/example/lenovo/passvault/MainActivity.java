package com.example.lenovo.passvault;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //EditText Username_field   = (EditText)findViewById(R.id.Username);
    //EditText Password_field   = (EditText)findViewById(R.id.Password);

    public void Exit_Application(View v) {
        finish();
        System.exit(0);
    }

    public void Verify_User(View v) {
        Intent k = new Intent(this,LoginActivity.class);
        startActivity(k);
    }
}
