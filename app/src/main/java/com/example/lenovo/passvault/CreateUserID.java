package com.example.lenovo.passvault;

import android.content.Context;
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

public class CreateUserID extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;

    private String userid;
    private String userpass;

    private final String File_Name = "LoginCredentials.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_id);

        usernameField = (EditText)findViewById(R.id.Username);
        passwordField = (EditText)findViewById(R.id.Password);

    }
    public void MakeAccount(View v) throws IOException {

        userid = usernameField.getText().toString();
        userpass = passwordField.getText().toString();

        String identifier1 = "Username:";
        String identifier2 = "Password:";

        try {
            File file;
            file = new File(File_Name);
            FileOutputStream fos = null;
            fos = openFileOutput(File_Name,Context.MODE_PRIVATE);
            fos.write(identifier1.getBytes());
            fos.write(userid.getBytes());
            fos.write(identifier2.getBytes());
            fos.write(userpass.getBytes());
            fos.close();
            String filepath = file.getAbsolutePath();
            Toast.makeText(CreateUserID.this,filepath,Toast.LENGTH_LONG).show();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    /*public void readingdata(View v) {
        String Collected = null;
        FileInputStream fis = null;
        try {
            fis = openFileInput(File_Name);
            byte[] dataArray = new byte[fis.available()]; // returs amount of bytes file has
            while(fis.read(dataArray)!=-1) {
                Collected = new String(dataArray);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(CreateUserID.this,Collected,Toast.LENGTH_LONG).show();
    }*/
}
