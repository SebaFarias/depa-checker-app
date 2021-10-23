package com.example.checkdepa.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.checkdepa.R;
import com.example.checkdepa.adapter.ApartmentAdapter;
import com.example.checkdepa.databinding.FragmentListarBinding;
import com.example.checkdepa.viewmodel.ApartmentViewModel;

public class ListarFragment extends Fragment {

    FragmentListarBinding b;
    ApartmentViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentListarBinding.inflate(inflater,container,false);
        model = new ViewModelProvider(this).get(ApartmentViewModel.class);
        model.cargarDataPorDefecto();

        ApartmentAdapter adapter = new ApartmentAdapter(model);
        b.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        b.rvLista.setAdapter(adapter);

        adapter.setListener( apartment -> {
            model.buscar(apartment.getId());
            Navigation.findNavController(container).navigate(R.id.action_listarFragment_to_checkFragment);
        });
        return b.getRoot();
    }
}