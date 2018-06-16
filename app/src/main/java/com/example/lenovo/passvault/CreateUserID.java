package com.example.lenovo.passvault;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateUserID extends AppCompatActivity{
    private EditText usernameField;
    private EditText passwordField;

    public String userid;
    public String userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_id);
        usernameField = (EditText)findViewById(R.id.Username);
        passwordField = (EditText)findViewById(R.id.Password);

    }
    public String EncOp(String x) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<x.length();i++) {
            sb.append((char) (x.charAt(i) + 3));
        }
        return(sb.toString());
    }
    public void MakeAccount(View v) {
        Intent k = new Intent(CreateUserID.this,MainActivity.class);
        FileOutputStream fos;
        try{
            fos = openFileOutput("LoginCredentials.txt",getApplicationContext().MODE_PRIVATE);
            fos.write(usernameField.getText().toString().getBytes());
            fos.write(passwordField.getText().toString().getBytes());
            fos.close();
        } catch(IOException e ){
            e.printStackTrace();
        }
        startActivity(k);
    }
}
