package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner simple_spinner;
    private Spinner custom_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simple_spinner = findViewById(R.id.simple_spinner);
        custom_spinner = findViewById(R.id.custom_spinner);

        ArrayAdapter<Sexo> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Sexo.values());
        ArrayAdapter<Sexo> customArrayAdapter =
                new CustomArrayAdapter<>(this, android.R.layout.simple_spinner_item,Sexo.values());

        simple_spinner.setAdapter(arrayAdapter);
        custom_spinner.setAdapter(customArrayAdapter);

    }

    public enum Sexo implements Listable{
        HOMBRE,MUJER;

        @Override
        public String getDescripcion() {
            return toString();
        }

        @Override
        public int getIcon() {
            return this.equals(HOMBRE)?R.drawable.masculino:R.drawable.femenino;
        }

        @Override
        public int getImage() {
            return this.equals(HOMBRE)?R.drawable.hombre:R.drawable.mujer;
        }
    }
}