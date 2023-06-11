package com.example.aplicacionmovillsm;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5;
    static int limitador = 0;
    Connection connect;
    String resultado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        /*
        resultado = obtenerTexto();
        btn1.setText(resultado);
        btn2.setText(obtenerTexto("select nombre from lecciones where id_lecciones=2;", "nombre"));
        btn2.setText(resultado);
        btn3.setText(obtenerTexto("select nombre from lecciones where id_lecciones=3;", "nombre"));
        btn3.setText(resultado);
        btn4.setText(obtenerTexto("select nombre from lecciones where id_lecciones=4;", "nombre"));
        btn4.setText(resultado);
        btn5.setText(obtenerTexto("select nombre from lecciones where id_lecciones=5;", "nombre"));
        btn5.setText(resultado);
        */

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);


        if (limitador >= 1) {
            btn1.setBackgroundColor(Color.argb(255, 0, 255, 0));
            if (limitador >= 2) {
                btn2.setBackgroundColor(Color.argb(255, 0, 255, 0));
                if (limitador >= 3) {
                    btn3.setBackgroundColor(Color.argb(255, 0, 255, 0));
                    if (limitador >= 4) {
                        btn4.setBackgroundColor(Color.argb(255, 0, 255, 0));
                        if (limitador >= 5) {
                            btn5.setBackgroundColor(Color.argb(255, 0, 255, 0));
                        }
                    }
                }
            }
        }

    }

    public String obtenerTexto(){
        String aux ="";
        Connection cnn=null;

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:mysql://20.110.160.147:3306/AppDB&autoReconnect=true&failOverReadOnly=false&maxReconnects=10","admin","password");


            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery("select nombre from lecciones where id_lecciones=1");


            while(rs.next()){
                aux = rs.getString(1);
            }


            //cnn.close();
            aux = "Conected";
        }catch(Exception e){
            aux = "error" + e;
        }

        return aux;
    }
    public static void setLimit(int lim) {
        limitador = lim;
    }

    @Override
    public void onClick(View v) {
        Intent acceder = new Intent(MainActivity.this, Leccion.class);

        switch (v.getId()) {

            case R.id.btn1:
                acceder.putExtra("leccion", 1);
                startActivity(acceder);
                break;
            case R.id.btn2:
                //Variable para verificar que se pueded acceder a la leccion 2
                if (limitador >= 1) {
                    acceder.putExtra("leccion", 2);
                    startActivity(acceder);
                } else {
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn3:
                //Variable para verificar que se pueded acceder a la leccion 2
                if (limitador >= 2) {
                    acceder.putExtra("leccion", 3);
                    startActivity(acceder);
                } else {
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn4:
                if (limitador >= 3) {
                    acceder.putExtra("leccion", 4);
                    startActivity(acceder);
                } else {
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn5:
                if (limitador >= 4) {
                    acceder.putExtra("leccion", 5);
                    startActivity(acceder);
                } else {
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
