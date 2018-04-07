package com.example.eduardopalacios.enciclopediasimpson;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.eduardopalacios.enciclopediasimpson.Adaptador.AdapterItems;
import com.example.eduardopalacios.enciclopediasimpson.Clases.Item;
import com.example.eduardopalacios.enciclopediasimpson.Clases.Personaje;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Item> datos=new ArrayList<>();
    List<Personaje>personajes=new ArrayList<>();
    AdapterItems adapter;
    String[] nombre={"Homero J.Simpson","Bartholomew (Bart) Jojo Simpson","Lisa Marie Simpson Bouvier","Marjorie (Marge) Jaqueline Bouvier Simpson","Abraham (Abe) Jedadiya Simpson"};
    String[] nacionalidad={"Americana","Americana","Americana","Americana","Americana"};

    String[] biografaia={"\"También es llamado Max Power en el episodio Homer to the Max\n" +
            "Básicamente, Homer es una sátira de los norteamericanos promedio, en palabras de su mismo creador Matt Groening. Las bromas indirectas se pueden encontrar en su personalidad, su actitud, su filosofía, su idiosincrasia, etc. Los rasgos esenciales de la personalidad " +
            "de Homer se presentaron desde sus inicios. \"/>","Bart es decididamente el más rebelde y travieso de la familia. Es un muchacho simpático y también muy travieso, que hace muchas bromas con su mejor amigo Milhouse. Sigue los programas de su ídolo Krusty el Payaso. Es desobediente y hace todo lo que le pasa por la cabeza. Su nombre es un anagrama de \"brat\", que en inglés significa \"travieso\". Su ideología es \"yo no fui, nadie me vio, no pueden demostrarlo\". " +
            "También en un capítulo Seymour Skinner descubre que es alérgico al camarón.\n" +
            "\n","El que Marge se quedara embarazada de Lisa supuso para ella y Homer que se mudaran de un piso a una casa de dos plantas en medio de una urbanización. Esto provocó que el matrimonio tuviera que mantener a sus dos hijos con un presupuesto bastante ajustado. Por ello, aunque Lisa de bebé mostró cualidades de superdotada, se tuvo que conformar con aprender a tocar el saxofón a una temprana edad para dar salida a su desarrollo intelectual. De todas maneras, el desastroso comportamiento de Bart hizo que sus padres le prestaran más atención a él que a ella, " +
            "teniendo que desarrollar forzadamente una autosuficiencia con apenas un año de vida. ","Marge se crio en una zona rural de la Norteamérica sureña, en un ambiente muy familiar. Se crio en una granja e iba de vacaciones con toda la familia a Barnacle Bay, una isla en la costa de Springfield. Su padre era asistente de vuelo (Azafato), cosa que traumatizó a la joven Marge, desarrollando miedo a los aviones y a volar. Pronto Marge se fue a vivir a la ciudad de Springfield y se graduó en el instituto. Al finalizar sus estudios obligatorios, Marge había tenido varios amores, pero Homer, que ya lo conocía de un campamento en su niñez (aunque no sabía que fuera él), sería con el que tendría una relación más larga y acabaría casándose. Marge trabajó de camarera en un autoservicio mientras era soltera y se graduó en la universidad, donde peligró su relación con su novio Homer cuando se enamoró de uno de los profesores. " +
            "Este asunto lo mantuvo en secreto por ser el más vergonzoso de su vida.","La biografía de Abraham Simpson es la más difícil de seguir de todos los personajes. Más que nada porque cualquier dato biográfico lo da él y sus batallas suelen ser extremadamente imprecisas, a menudo física o históricamente imposibles y ocasionalmente inconsistentes entre ellas, sugiriendo que el abuelo es extremadamente senil y ya empieza a desvariar. Por ello, no se puede determinar con certeza hasta qué " +
            "punto los productores de la serie consideran como oficiales los siguientes datos de la vida de Abe."};
    int[] edad={36,10,8,34,86};
    int[] imagen={R.drawable.homero2,R.drawable.bart2,R.drawable.lisa2,R.drawable.marge2,R.drawable.abuelo2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.lista);

        datos.add(new Item("Homero Simpson",R.drawable.homero));
        datos.add(new Item("Bart Simpson",R.drawable.bart));
        datos.add(new Item("Lisa Simpson",R.drawable.lisa));
        datos.add(new Item("Marge Simpson",R.drawable.marge));
        datos.add(new Item("Abuelo Simpson",R.drawable.abuelo));

        adapter=new AdapterItems(this,R.layout.disenio_list_vew,datos);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Personaje personaje=new Personaje(imagen[i],nombre[i],edad[i],nacionalidad[i],biografaia[i]);
                Bundle bundle=new Bundle();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                bundle.putParcelable("datos",personaje);

                intent.putExtras(bundle);

                startActivity(intent);

            }
        });



    }
    public RoundedBitmapDrawable redondearImagen(int imagen){
        //extraemos el drawable en un bitmap
        Drawable originalDrawable = getResources().getDrawable(imagen);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(),originalBitmap);
        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());
        return roundedDrawable;

    }


    public void DatosPersonaje()
    {

    }
}
