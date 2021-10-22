package com.example.checkdepa.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.checkdepa.model.Apartment;
import com.example.checkdepa.room.ApartmentDB;

import java.util.List;

public class ApartmentRepository {

    private ApartmentDB aDb;

    public ApartmentRepository(Application application )
    {
        this.aDb = ApartmentDB.getDatabase(application);
    }

    public void agregar(Apartment apartment){
        ApartmentDB.databaseWriteExecutor.execute( () -> {
            this.aDb.apartmentDao().agregar(apartment);
        });
    }
    public void agregarTodos( Apartment...apartments){
        ApartmentDB.databaseWriteExecutor.execute( () -> {
            this.aDb.apartmentDao().AgregarTodos(apartments);
        });
    }
    public void modificar( Apartment apartment){
        ApartmentDB.databaseWriteExecutor.execute( () -> {
        this.aDb.apartmentDao().modificar(apartment);
        });
    }
    public void eliminar( Apartment apartment ){
        ApartmentDB.databaseWriteExecutor.execute( () -> {
        this.aDb.apartmentDao().eliminar(apartment);
        });
    }
    public LiveData<List<Apartment>> listar(){
        return this.aDb.apartmentDao().listar();
    }
    public LiveData<Apartment> buscar(int id){
        return this.aDb.apartmentDao().buscar(id);
    }

}
