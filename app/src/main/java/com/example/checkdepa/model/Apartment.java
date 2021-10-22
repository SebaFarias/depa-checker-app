package com.example.checkdepa.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "apartment_table")
public class Apartment {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String nombre;
    @NonNull
    private String torre;
    @NonNull
    private String unidad;
    @NonNull
    private String direccion;
    @NonNull
    private String imgUrl;

    public Apartment(int id, @NonNull String nombre, @NonNull String torre, @NonNull String unidad, @NonNull String direccion, @NonNull String imgUrl) {
        this.id = id;
        this.nombre = nombre;
        this.torre = torre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.imgUrl = imgUrl;
    }
    @Ignore
    public Apartment(@NonNull String nombre, @NonNull String torre, @NonNull String unidad, @NonNull String direccion, @NonNull String imgUrl) {
        this.nombre = nombre;
        this.torre = torre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    @NonNull
    public String getTorre() {
        return torre;
    }

    @NonNull
    public String getUnidad() {
        return unidad;
    }

    @NonNull
    public String getDireccion() {
        return direccion;
    }

    @NonNull
    public String getImgUrl() {
        return imgUrl;
    }
}
