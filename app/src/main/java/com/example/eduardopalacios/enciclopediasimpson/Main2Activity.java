package com.example.eduardopalacios.enciclopediasimpson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eduardopalacios.enciclopediasimpson.Clases.Personaje;

public class Main2Activity extends AppCompatActivity {

    ImageView imagen;
    TextView nombre,edad,nacionalidad,biografia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imagen=findViewById(R.id.imagen);
        nombre=findViewById(R.id.nombre);
        edad=findViewById(R.id.edad);
        nacionalidad=findViewById(R.id.nacionalidad);
        biografia=findViewById(R.id.biografia);

        Bundle bundle=getIntent().getExtras();
        Personaje personaje=bundle.getParcelable("datos");

        imagen.setImageResource(personaje.getImagen());
        nombre.setText("Nombre: "+personaje.getNombre());
        edad.setText("Edad: "+String.valueOf(personaje.getEdad())+" años");
        nacionalidad.setText("Nacionalidad: "+personaje.getNacionalidad());
        biografia.setText(personaje.getBiografia());


    }
}
