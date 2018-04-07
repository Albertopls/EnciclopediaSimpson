package com.example.eduardopalacios.enciclopediasimpson.Adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.eduardopalacios.enciclopediasimpson.Clases.Item;
import com.example.eduardopalacios.enciclopediasimpson.Holder.holderItem;
import com.example.eduardopalacios.enciclopediasimpson.R;

import java.util.List;

/**
 * Created by eduardopalacios on 06/04/18.
 */

public class AdapterItems extends ArrayAdapter<Item> {

    Context context;
    int resource;
    List<Item> datos;
    public AdapterItems(Context context, int resource, List<Item> datos) {
        super(context,resource,datos);
        this.context=context;
        this.resource=resource;
        this.datos=datos;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;
        holderItem holderItem=null;

        if(view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(resource,parent,false);

            holderItem=new holderItem();
            holderItem.imagen=view.findViewById(R.id.imagen);
            holderItem.texto=view.findViewById(R.id.nombre);
            view.setTag(holderItem);

        }
        else {
           holderItem=(holderItem) view.getTag();
        }
        holderItem.imagen.setImageResource(datos.get(position).getImagen());
        holderItem.texto.setText(datos.get(position).getNombre());

       return view;
    }
}
