package com.example.checkdepa.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.checkdepa.databinding.ActivityPrincipal3Binding;

public class Principal extends AppCompatActivity {

    ActivityPrincipal3Binding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityPrincipal3Binding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }
}