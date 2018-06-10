package com.example.lenovo.passvault;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.EncryptedPrivateKeyInfo;

public class MakeFileActivity extends AppCompatActivity {

   EditText EditFieldcontents;
   private static final String File_Name = "UserEncryptedTextFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_file);
    }
    protected String EncOp(String x) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<x.length();i++) {
            sb.append((char) (x.charAt(i) + 3));
        }
        return sb.toString();
    }
    protected void EnterDet(View v) {
        EditFieldcontents = (EditText)findViewById(R.id.UserEditField);
        String x = EditFieldcontents.getText().toString();
        x=EncOp(x);
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(File_Name,getApplicationContext().MODE_APPEND);
            fos.write(x.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    protected void GoBack(View v) {
        Intent k = new Intent(this,LoginActivity.class);
        startActivity(k);
    }
}
