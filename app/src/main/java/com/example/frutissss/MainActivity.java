package com.example.frutissss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables

    //Bitmap imgFrutas;

    //Array de frutas
    Fruta[] frutas = new Fruta[16];
    //Creamos una instancia del adaptador
    Adaptador adaptador;

    //ListView
    ListView listView_Frutas;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frutas);

        Intent intent = getIntent();

        listView_Frutas = findViewById(R.id.listview_frutas);
        //Inicialización de variables

        //generamos una imagen a partir de un recurso, en concretor del png de drawable
        Bitmap imgFrutas = BitmapFactory.decodeResource(getResources(),R.drawable.frutas2);

        //Vamos a generar las 16 frutas
        frutas[0] = new Fruta(0, "Coco", imgFrutas, 0, 0);
        frutas[1] = new Fruta(1, "Aguacate", imgFrutas, 1, 0);
        frutas[2] = new Fruta(2, "Pomelo", imgFrutas, 2, 0);
        frutas[3] = new Fruta(3, "Plátano", imgFrutas, 3, 0);
        frutas[4] = new Fruta(4, "Naranja", imgFrutas, 0, 1);
        frutas[5] = new Fruta(5, "Ciruela", imgFrutas, 1, 1);
        frutas[6] = new Fruta(6, "Piña", imgFrutas, 2, 1);
        frutas[7] = new Fruta(7, "Limón", imgFrutas, 3, 1);
        frutas[8] = new Fruta(8, "Fresa", imgFrutas, 0, 2);
        frutas[9] = new Fruta(9, "Pera", imgFrutas, 1, 2);
        frutas[10] = new Fruta(10, "Sandía", imgFrutas, 2, 2);
        frutas[11] = new Fruta(11, "Uvas", imgFrutas, 3, 2);
        frutas[12] = new Fruta(12, "Manzana", imgFrutas, 0, 3);
        frutas[13] = new Fruta(13, "Granada", imgFrutas, 1, 3);
        frutas[14] = new Fruta(14, "Kiwi", imgFrutas, 2, 3);
        frutas[15] = new Fruta(15, "Cerezas", imgFrutas, 3, 3);

        //Se inicializa el adaptador, al que se le pasa el array de frutas y el contexto de la app
        adaptador = new Adaptador(frutas, this);

        //Aplicamos el adaptador a la listView
        listView_Frutas.setAdapter(adaptador);

/*
        //como me interesa cambiar de imagen según las necesidades, usamos su id para modificarlo desde java
        imageView = findViewById(R.id.imageView);
        //setImageDrawable recibe como elemento un Drawable y como R.drawable.frutas
        //es de tipo int, lo convertimos
        imageView.setImageDrawable(getDrawable(R.drawable.frutas2));


        //Se define el Bitmap y se le asocia la imagen png de frutas
        imgFrutas = BitmapFactory.decodeResource(getResources(), R.drawable.frutas2);

        //A la hora de pintar, hay que seleccionar la sección del bitmap a pintar
        //Como mi imagen tiene 4x4 dibujos de frutas, se seleccionan las diferentes frutas
        imgFrutas = Bitmap.createBitmap(imgFrutas, 1*imgFrutas.getWidth()/4, 3*imgFrutas.getHeight()/4, imgFrutas.getWidth()/4, imgFrutas.getHeight()/4);

        //Tras seleccionar la sección del bitmap a pintar, colocamos el trozo de bitmap en el imageView
        imageView.setImageBitmap(imgFrutas);
*/
    }
}