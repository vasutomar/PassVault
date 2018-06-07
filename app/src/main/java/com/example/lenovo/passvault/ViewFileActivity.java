package com.example.lenovo.passvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ViewFileActivity extends AppCompatActivity {

    private TextView Contents;
    private static final String File_Name = "UserEncryptedTextFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_file);

        Contents = (TextView)findViewById(R.id.TextContents);
        String Collected = "";
        FileInputStream fis = null;
        try {
            //Toast.makeText(MainActivity.this,"Here",Toast.LENGTH_LONG).show();
            fis = openFileInput(File_Name);
            byte[] dataArray = new byte[fis.available()]; // returs amount of bytes file has
            while(fis.read(dataArray)!=-1) {
                Collected = new String(dataArray);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        Contents.setText(Collected);
    }
    protected void GoBack(View v) {
        Intent k = new Intent(this,LoginActivity.class);
        startActivity(k);
    }
}
