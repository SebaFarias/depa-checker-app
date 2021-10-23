package com.example.checkdepa.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
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
    @ColumnInfo(name = "luces_ok")
    private boolean luces;
    @ColumnInfo(name = "cocina_ok")
    private boolean cocina;
    @ColumnInfo(name = "dormitorio_ok")
    private boolean dormitorio;
    @ColumnInfo(name = "wc_ok")
    private boolean wc;
    @ColumnInfo(name = "estado_terminaciones")
    private int terminaciones;

    public Apartment(int id, @NonNull String nombre, @NonNull String torre, @NonNull String unidad, @NonNull String direccion, @NonNull String imgUrl, boolean luces, boolean cocina, boolean dormitorio, boolean wc, int terminaciones) {
        this.id = id;
        this.nombre = nombre;
        this.torre = torre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.imgUrl = imgUrl;
        this.luces = luces;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.wc = wc;
        this.terminaciones = terminaciones;
    }

    @Ignore
    public Apartment(@NonNull String nombre, @NonNull String torre, @NonNull String unidad, @NonNull String direccion, @NonNull String imgUrl) {
        this.nombre = nombre;
        this.torre = torre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.imgUrl = imgUrl;
        this.cocina = false;
        this.luces = false;
        this.dormitorio = false;
        this.wc = false;
        this.terminaciones = 0;
    }

    public boolean isLuces() {
        return luces;
    }

    public boolean isCocina() {
        return cocina;
    }

    public boolean isDormitorio() {
        return dormitorio;
    }

    public boolean isWc() {
        return wc;
    }

    public int getTerminaciones() {
        return terminaciones;
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

    public int getScore(){
        if(getTerminaciones() == 0){
            return 0;
        }
        int luces = isLuces()? 10 : 0;
        int wc = isWc()? 40 : 0 ;
        int cocina = isCocina()? 30 : 0;
        int dormitorio = isDormitorio()? 20 : 0;
        return getTerminaciones() * (luces + wc + cocina + dormitorio);
    }
}
