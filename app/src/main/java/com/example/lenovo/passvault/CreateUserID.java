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

    }
    public void MakeAccount(View v) {

        usernameField = (EditText)findViewById(R.id.Username);
        passwordField = (EditText)findViewById(R.id.Password);
        userid = usernameField.getText().toString();
        userpass = passwordField.getText().toString();

        /*AccountManager am = AccountManager.get(CreateUserID.this);
        Account account = am.getAccountsByType("com.google");*/

        Intent k = new Intent(this,MainActivity.class);
        k.putExtra("Username",userid);
        k.putExtra("Password",userpass);
        startActivity(k);
    }
}
