package com.example.checkdepa.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import androidx.customview.widget.Openable;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.checkdepa.R;
import com.example.checkdepa.databinding.ActivityPrincipal3Binding;

import javax.xml.transform.Result;


public class Principal extends AppCompatActivity {

    ActivityPrincipal3Binding b;
    NavController nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityPrincipal3Binding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navFrag);
        nav = host.getNavController();

        NavigationUI.setupActionBarWithNavController(this,nav);
    }
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(nav, (Openable) null);
    }

}