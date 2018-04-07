package com.example.eduardopalacios.enciclopediasimpson.Clases;

/**
 * Created by eduardopalacios on 06/04/18.
 */

public class Item {

     String nombre;
     int imagen;

     public Item(String nombre,int imagen)
     {
         this.imagen=imagen;
         this.nombre=nombre;
     }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

}
