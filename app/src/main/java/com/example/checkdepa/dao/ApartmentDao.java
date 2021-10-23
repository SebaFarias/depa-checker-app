package com.example.checkdepa.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.checkdepa.model.Apartment;

@Dao
public interface ApartmentDao {

    @Insert
    public void agregar(Apartment apartment);
    @Insert
    public void AgregarTodos(Apartment...apartment);
    @Update
    public void modificar(Apartment apartment);
    @Delete
    public void eliminar(Apartment apartment);
    @Query("SELECT * FROM apartment_table")
    public LiveData<List<Apartment>> listar();
    @Query("SELECT * FROM apartment_table WHERE id = :id")
    public LiveData<Apartment> buscar(int id);
    @Query("SELECT COUNT(id) FROM apartment_table")
    public LiveData<Integer> getCount();

}
