package com.example.eduardopalacios.enciclopediasimpson.Clases;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eduardopalacios on 06/04/18.
 */

public class Personaje implements Parcelable {

    int imagen;
    String nombre,nacionalidad,biografia;
    int edad;


    public Personaje(int imagen,String nombre, int edad, String nacionalidad, String biografia)
    {
        this.imagen=imagen;
        this.nombre=nombre;
        this.edad=edad;
        this.nacionalidad=nacionalidad;
        this.biografia=biografia;

    }


    protected Personaje(Parcel in) {
        imagen = in.readInt();
        nombre = in.readString();
        nacionalidad = in.readString();
        biografia = in.readString();
        edad = in.readInt();
    }

    public static final Creator<Personaje> CREATOR = new Creator<Personaje>() {
        @Override
        public Personaje createFromParcel(Parcel in) {
            return new Personaje(in);
        }

        @Override
        public Personaje[] newArray(int size) {
            return new Personaje[size];
        }
    };

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getBiografia() {
        return biografia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagen);
        parcel.writeString(nombre);
        parcel.writeString(nacionalidad);
        parcel.writeString(biografia);
        parcel.writeInt(edad);
    }
}
