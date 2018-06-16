/* Startup code (line 31 to 41 ) credit - djain2405@github.com */

package com.example.lenovo.passvault;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public EditText Authentication_Username;
    public EditText Authentication_Password;

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Authentication_Username = (EditText) findViewById(R.id.Username);
        Authentication_Password = (EditText) findViewById(R.id.Password);

        SharedPreferences wmbPreference = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        Intent k = new Intent(this, CreateUserID.class);
        if (isFirstRun) {
            startActivity(k);
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }
    }

    public void Verify_User(View v) {
        String ret = "";
        try {
            InputStream inputStream = getApplicationContext().
                    openFileInput("LoginCredentials.txt");
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ret.equals(Authentication_Username.getText().toString()+Authentication_Password.getText()
                .toString())){
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
        }
        else {
            Toast.makeText(MainActivity.this,"Wrong Credentials",Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void Exit_Application(View v) {
        this.finishAffinity();
    }
}