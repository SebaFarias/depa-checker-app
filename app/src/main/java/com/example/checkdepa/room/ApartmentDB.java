package com.example.checkdepa.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.checkdepa.dao.ApartmentDao;
import com.example.checkdepa.model.Apartment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = Apartment.class,version = 1)
public abstract class ApartmentDB extends RoomDatabase {

    public static ApartmentDB instance;
    public abstract ApartmentDao apartmentDao();

    public static synchronized ApartmentDB getDatabase(Context context )
    {
        if( instance == null )
        {
            instance = Room.databaseBuilder(context,ApartmentDB.class,"depas_db").build();
        }
        return instance;
    }
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);
}
