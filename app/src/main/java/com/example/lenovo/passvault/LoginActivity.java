package com.example.lenovo.passvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    protected void ViewFiles(View v) {
        Intent k = new Intent(this,ViewFileActivity.class);
        startActivity(k);
    }
    protected void Addcontents(View v) {
        Intent k = new Intent(this,MakeFileActivity.class);
        startActivity(k);
    }
    protected void GoBack(View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
