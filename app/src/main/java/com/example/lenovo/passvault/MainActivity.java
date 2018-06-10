/* Startup code (line 31 to 41 ) credit - djain2405@github.com */

package com.example.lenovo.passvault;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
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
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText Authentication_Username;
    EditText Authentication_Password;
    private static final String File_Name = "LoginCredentials.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences wmbPreference = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {

            Intent k = new Intent(this,CreateUserID.class);
            startActivity(k);

            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }

    }

    public void Verify_User(View v) {
        Authentication_Username=(EditText)findViewById(R.id.Username);
        Authentication_Password=(EditText)findViewById(R.id.Password);

        String Match_Username = Authentication_Username.getText().toString();
        String Match_Password = Authentication_Password.getText().toString();

        String identifier1 = "Username:";
        String identifier2 = "Password:";

        String Entered = "";

        Entered = Entered+identifier1;
        Entered = Entered+Match_Username;
        Entered = Entered+identifier2;
        Entered = Entered+Match_Password;

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
        //Toast.makeText(MainActivity.this,Collected,Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this,Entered,Toast.LENGTH_LONG).show();
        if(Collected==Entered) {
            Intent k = new Intent(this,LoginActivity.class);
            startActivity(k);
        }
        else {
            Intent k = new Intent(this,LoginActivity.class);
            startActivity(k);
            //Toast.makeText(MainActivity.this,"Wrong Username or Password entered",
                    //Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_LONG).show();
    }

    public void Exit_Application(View v) {
        finish();
        System.exit(0);
    }
}