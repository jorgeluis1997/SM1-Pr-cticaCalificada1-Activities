package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
TextView txtResultado;
TextView txtCalificacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txtResultado = (TextView) findViewById(R.id.Tv_Resultado);
        txtCalificacion = (TextView) findViewById(R.id.Tv_Calificacion);

        Intent i = getIntent();
        double altura = i.getDoubleExtra("altura",0);
        double peso = i.getDoubleExtra("peso",0);
        double imc = (peso/Math.pow(altura,2));

        if(imc<18.5)
        {
            txtResultado.setText(String.valueOf(imc));
            txtCalificacion.setText("Bajo Peso");
            ImageView imgPeso = (ImageView) findViewById(R.id.imgpeso);
            imgPeso.setImageResource(R.mipmap.bajo);
        }else{
            if(imc<25){
                txtResultado.setText(String.valueOf(imc));
                txtCalificacion.setText("Peso Adecuado");
                ImageView imgPeso = (ImageView) findViewById(R.id.imgpeso);
                imgPeso.setImageResource(R.mipmap.pesonormal);

            }
            else{
                if(imc<30){
                    txtResultado.setText(String.valueOf(imc));
                    txtCalificacion.setText("Sobrepeso");
                    ImageView imgPeso = (ImageView) findViewById(R.id.imgpeso);
                    imgPeso.setImageResource(R.mipmap.sobrepeso);
                }
                else{
                    txtResultado.setText(String.valueOf(imc));
                    txtCalificacion.setText("Obesidad");
                    ImageView imgPeso = (ImageView) findViewById(R.id.imgpeso);
                    imgPeso.setImageResource(R.mipmap.obeso);
                }

            }
        }


        txtResultado.setText(String.valueOf(imc));
    }

    public void volverOnClick(View view)
    {
        super.onBackPressed();
    }

}