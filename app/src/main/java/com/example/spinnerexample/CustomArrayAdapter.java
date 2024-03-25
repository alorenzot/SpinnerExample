package com.example.spinnerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomArrayAdapter<T> extends ArrayAdapter<T> {
    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem=convertView;
        if (listItem==null)
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_item,parent,false);

        MainActivity.Sexo sexo = MainActivity.Sexo.values()[position];

        ImageView imageView = listItem.findViewById(R.id.imagen);
        TextView textView = listItem.findViewById(R.id.texto);

        textView.setText(sexo.toString());
        imageView.setImageResource((sexo.equals(MainActivity.Sexo.HOMBRE)?R.drawable.hombre:R.drawable.mujer));

        return listItem;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem=convertView;
        if (listItem==null)
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_item,parent,false);

        MainActivity.Sexo sexo = MainActivity.Sexo.values()[position];

        ImageView imageView = listItem.findViewById(R.id.imagen);
        TextView textView = listItem.findViewById(R.id.texto);

        textView.setText(sexo.toString());
        imageView.setImageResource((sexo.equals(MainActivity.Sexo.HOMBRE)?R.drawable.masculino:R.drawable.femenino));

        return listItem;    }
}
