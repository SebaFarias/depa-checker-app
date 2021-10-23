package com.example.checkdepa.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.checkdepa.model.Apartment;
import com.example.checkdepa.model.ApartmentData;
import com.example.checkdepa.repository.ApartmentRepository;

import java.util.List;

public class ApartmentViewModel extends AndroidViewModel {

    private ApartmentRepository repo;
    private LiveData<List<Apartment>> lista;
    private LiveData<Apartment> apartment;

    public LiveData<List<Apartment>> getLista() {
        return lista;
    }

    public LiveData<Apartment> getApartment() {
        return apartment;
    }

    public ApartmentViewModel(@NonNull Application application) {
        super(application);
        repo = new ApartmentRepository(application);
        lista = repo.listar();
    }

    public void agregar( Apartment apartment ){ repo.agregar( apartment ); }
    public void modificar( Apartment apartment ) { repo.modificar( apartment ); }
    public void eliminar( Apartment apartment ) { repo.eliminar( apartment ); }
    public void buscar( int id ){ apartment = repo.buscar(id); }
    public LiveData<Integer> getCount() { return repo.getCount(); }

    public void cargarDataPorDefecto(){
        List<Apartment> listaOriginal = ApartmentData.apartmentList();
        for(Apartment a :listaOriginal)
        {
            agregar(a);
        }
    }

}
