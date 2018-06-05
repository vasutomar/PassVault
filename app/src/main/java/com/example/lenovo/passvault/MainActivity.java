package com.example.lenovo.passvault;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private static final String File_Name = "LoginCredentials.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Exit_Application(View v) {
        finish();
        System.exit(0);
    }
    public void Verify_User(View v) {
        Intent k = new Intent(this,LoginActivity.class);
        startActivity(k);
    }
    public void CreateUserId(View v) {
        String path = "/LoginCredentials.txt";
        File file = new File(path);
        if(file.exists())
            Toast.makeText(MainActivity.this,"Exists",Toast.LENGTH_LONG).show();
        else{
            Toast.makeText(MainActivity.this,"does not exist",Toast.LENGTH_LONG).show();
            Intent k = new Intent(this,CreateUserID.class);
            startActivity(k);
        }

    }
}
