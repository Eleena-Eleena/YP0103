package com.example.yp01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        TextView textView = (TextView) findViewById(R.id.TextViewReg);
        Button buttonProf = (Button)findViewById(R.id.Btn_Prof);
        Button buttonsignIn = (Button)findViewById(R.id.Btn_singIn);
        EditText editTextLog = findViewById(R.id.editTextLogin);
        EditText editTextPas = findViewById(R.id.editTextPassword);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
            }
        });
        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Profile.class);
                startActivity(intent);
            }
        });
        buttonsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextLog.length() == 0 && editTextPas.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Введите Email и пароль",Toast.LENGTH_SHORT).show();
                }
                else if (editTextLog.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Введите Email",Toast.LENGTH_SHORT).show();
                }
                else if (editTextPas.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Введите пароль",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(getBaseContext(), HomePage.class);
                    startActivity(intent);
                }
            }
        });
    }
}