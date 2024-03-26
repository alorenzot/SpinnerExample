package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner simple_spinner;
    private Spinner custom_spinner;
    private Spinner string_array_spinner;
    private TextView texto3;
    private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simple_spinner = findViewById(R.id.simple_spinner);
        custom_spinner = findViewById(R.id.custom_spinner);
        texto3=findViewById(R.id.text3);
        image2=findViewById(R.id.image2);
        string_array_spinner=findViewById(R.id.arraySpinner);

        ArrayAdapter<Sexo> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Sexo.values());
        ArrayAdapter<Sexo> customArrayAdapter =
                new CustomArrayAdapter<>(this, android.R.layout.simple_spinner_item,Sexo.values());
        ArrayAdapter<CharSequence> stringArrayAdapter = ArrayAdapter.createFromResource(this,R.array.valores_array, android.R.layout.simple_spinner_item);

        simple_spinner.setAdapter(arrayAdapter);
        custom_spinner.setAdapter(customArrayAdapter);
        string_array_spinner.setAdapter(stringArrayAdapter);

        simple_spinner.setOnItemSelectedListener(this);
        custom_spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Listable item = (Listable) adapterView.getItemAtPosition(i);
        texto3.setText(item.getDescripcion());
        image2.setImageResource(item.getIcon());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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