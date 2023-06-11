package com.example.aplicacionmovillsm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;

public class Actividad extends AppCompatActivity implements View.OnClickListener{
    Button btnsen, btnopc1, btnopc2, btnopc3, btnopc4;
    static int limitador = 0;
    Connection connect;
    String resultado = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);

        btnsen = findViewById(R.id.btnsen);
        btnopc1 = findViewById(R.id.btnopc1);
        btnopc2 = findViewById(R.id.btnopc2);
        btnopc3 = findViewById(R.id.btnopc3);
        btnopc4 = findViewById(R.id.btnopc4);

        btnsen.setOnClickListener(this);
        btnopc1.setOnClickListener(this);
        btnopc2.setOnClickListener(this);
        btnopc3.setOnClickListener(this);
        btnopc4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String resp = "A";
        Intent acceder = new Intent(Actividad.this, Leccion.class);

        switch (v.getId()) {

            case R.id.btnsen:
                acceder.putExtra("leccion",1);
                startActivity(acceder);
                break;
            case R.id.btnopc1:
                //Validar pregunta
                if(resp.equals("A")){
                    Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    Leccion.setActividad();
                }else{
                    Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnopc2:
                //Variable para verificar que se pueded acceder a la leccion 2
                if(resp.equals("B")){
                    Leccion.setActividad();
                }else{
                    Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnopc3:
                if(resp.equals("C")){
                    Leccion.setActividad();
                    startActivity(acceder);
                }else{
                    Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnopc4:
                if(resp.equals("D")){
                    Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    Leccion.setActividad();
                    startActivity(acceder);
                }else{
                    Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}