package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etAltura;
    EditText etPeso;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
    }

    public void CalcularOnClick(View view)
    {
        try {
            double altura = Double.parseDouble(etAltura.getText().toString());
            double peso = Double.parseDouble(etPeso.getText().toString());

            Intent i = new Intent(this, Resultado.class); //instanciamiento a la siguiente actividad
            i.putExtra("peso", peso);
            i.putExtra("altura", altura);

            startActivity(i);

        }catch (Exception e)
        {
            Toast.makeText(this, "Error en el ingreso de datos", Toast.LENGTH_SHORT).show();
        }

    }


    @Override public boolean onCreateOptionsMenu(Menu mimenu)
    {
        getMenuInflater().inflate(R.menu.my, mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id== R.id.limpiar)
        {
            etPeso.setText("");
            etAltura.setText("");
        }

        return super.onOptionsItemSelected(item);
    }





}