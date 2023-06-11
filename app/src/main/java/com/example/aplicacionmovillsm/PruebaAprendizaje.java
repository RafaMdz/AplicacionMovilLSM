package com.example.aplicacionmovillsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class PruebaAprendizaje extends AppCompatActivity {
Button btn1, btnopc1, btnopc2, btnopc3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_aprendizaje);

        btn1 = findViewById(R.id.btnsen);
        btnopc1 = findViewById(R.id.btnopc1);
        

    }
}