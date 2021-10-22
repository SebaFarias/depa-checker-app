package com.example.checkdepa.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.checkdepa.R;
import com.example.checkdepa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;
    int intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        intentos = 0;

        b.btnIngresar.setOnClickListener( v -> {

            String pass = b.txtPassword.getEditText().getText().toString();
            if(getString(R.string.accepted_pass).equals(pass) )
            {
                Intent i = new Intent(getApplicationContext(), Principal.class);
                startActivity(i);
            }else
            {
                intentos++;
                if(intentos>2){
                    //Hacer disabled el btn
                }
                Toast.makeText(v.getContext(),getString(R.string.err_login),Toast.LENGTH_LONG).show();
            }
        });


    }
}