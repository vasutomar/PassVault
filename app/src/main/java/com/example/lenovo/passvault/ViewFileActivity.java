package com.example.lenovo.passvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ViewFileActivity extends AppCompatActivity {

    private TextView Contents;
    private TextView EncryptedContents;
    private static final String File_Name = "UserEncryptedTextFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_file);

        Contents = (TextView)findViewById(R.id.TextContents);
        EncryptedContents = (TextView)findViewById(R.id.enc);
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
        EncryptedContents.setText(Collected);
        /* Decryption*/
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<Collected.length();i++) {
            sb.append((char) (Collected.charAt(i) - 3));
        }
        Collected = sb.toString();
        Contents.setText(Collected);
    }
    public void GoBack(View v) {
        finish();
    }
}
