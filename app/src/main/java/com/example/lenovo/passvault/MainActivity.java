/* Startup code (line 31 to 41 ) credit - djain2405@github.com */

package com.example.lenovo.passvault;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
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
import java.nio.file.FileAlreadyExistsException;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    protected EditText Authentication_Username;
    protected EditText Authentication_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences wmbPreference = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun) {

            Intent k = new Intent(this,CreateUserID.class);
            startActivity(k);

            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }
    }
    public void Verify_User(View v) {

        Authentication_Username = (EditText) findViewById(R.id.Username);
        Authentication_Password = (EditText) findViewById(R.id.Password);

        String Match_Username = Authentication_Username.getText().toString();
        String Match_Password = Authentication_Password.getText().toString();
    }

    public void Exit_Application(View v) {
        this.finishAffinity();
    }
}