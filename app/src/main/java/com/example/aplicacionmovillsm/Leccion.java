package com.example.aplicacionmovillsm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Leccion extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2, btn3, ejemplo;
    static Boolean actividad = false;
    String videourl = "";
    static TextView tx1, tx2;
    WebView wv;
    ImageView inicio, ejemploC;
    int numlec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        ejemplo = findViewById(R.id.btnejem);

        tx1 = findViewById(R.id.titulo);
        tx2 = findViewById(R.id.info);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        ejemplo.setOnClickListener(this);

        inicio = (ImageView) findViewById(R.id.inicio);

        recibirDato();
    }

    public static void setActividad(){
        actividad = true;
    }

    private void recibirDato(){
        //Videourl para locla y videorul2 para web view
        Bundle extra = getIntent().getExtras();
        numlec = extra.getInt("leccion");

        if(numlec == 1){
            tx1.setText("La Decena");
            tx2.setText("¿Qué busco?\n*Que completen una decena dado un numero menor que 10, utilizando colecciones\n\n¿Que material necesito?\n\t*2 juegos de tarjetas numero-coleccion 0 al 10 por parejan\n\n¿Como guio el proceso?\n\t*Para iniciar el juego, pídales que coloquen tarjetas del 0 al 10 al centro. Del resto, deben de revolverlas y tomar las cartas para formar 10. Alguien puede tomar, por ejemplo, las cartas 1, 2, 5 y 2, o bien, algo como 0, 9 y 1");
            videourl = "https://www.youtube.com/shorts/JTUX_7wXQ_Y";

        }else if(numlec == 2){
            tx1.setText("Hasta el 15");
            tx2.setText("¿Que tiene mas?\n¿Que busco?\n*Que comparen colecciones e objetos con procedimientos propios.\n¿Que material necesito?\n\tPara cada pareja 3 dados con el numero 6 oculto");
            videourl = "https://youtube.com/shorts/er2reU1iP1k";

        }else if(numlec == 3){
            tx1.setText("Hasta el 30");
            tx2.setText("Mas sorpresas\n¿Que busco?\n¿Que busco?\n\t*Que utilicen estrategias propias de conteo para cuantificar colecciones concretas de 15 a 30 objetos\n¿Que materiales necesita?\n\t*Una caja de sorpresas por estudiante\n\t*Coloque dentro de la caja objetos como piedritas, fichas y semillas. Puede haber de 15 a 30 objetos");
            videourl = "https://youtube.com/shorts/YPdUqNyVsZI";
        }else if(numlec == 4){
            tx1.setText("Hasta el 50");
            tx2.setText("");
            videourl = "https://youtube.com/shorts/cnXve_NomnM";
        }else{
            tx1.setText("Estrategias de suma y resta");
            tx2.setText("");
            inicio.setImageResource(R.mipmap.mate);
            videourl = "https://youtube.com/shorts/cnXve_NomnM";
        }
    }

    @Override
    public void onClick(View v) {
        Intent acceder = new Intent(Leccion.this, MainActivity.class);
        Intent actividadAcceder = new Intent(Leccion.this, Actividad.class);
        Intent pagina = new Intent(Intent.ACTION_VIEW);
        String url = "";

        switch (v.getId()) {

            case R.id.btnejem:
                pagina.setData(Uri.parse(videourl));
                startActivity(pagina);
                break;
            case R.id.btn1:
                startActivity(actividadAcceder);
                break;
            case R.id.btn2:
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();


                MainActivity.setLimit(numlec);
                break;
            case R.id.btn3:
                startActivity(acceder);
                break;
        }
    }
}