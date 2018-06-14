package com.example.lenovo.passvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void ViewFiles(View v) {
        Intent k = new Intent(LoginActivity.this,ViewFileActivity.class);
        startActivity(k);
    }
    public void Addcontents(View l) {
        Intent k = new Intent(LoginActivity.this,MakeFileActivity.class);
        startActivity(k);
    }
    public void GoBack(View cs) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
