package com.example.checkdepa.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.checkdepa.R;
import com.example.checkdepa.databinding.FragmentCheckBinding;
import com.example.checkdepa.viewmodel.ApartmentViewModel;

public class CheckFragment extends Fragment {

    FragmentCheckBinding b;
    ApartmentViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentCheckBinding.inflate(inflater,container,false);
        model = new ViewModelProvider(this).get(ApartmentViewModel.class);




        return b.getRoot();
    }
}