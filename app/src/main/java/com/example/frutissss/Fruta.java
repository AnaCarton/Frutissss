package com.example.frutissss;

import android.graphics.Bitmap;

public class Fruta {

    //Esta clase va a contener el modelo de datos
    String name;
    Integer quantity;
    Bitmap image;
    long id; //campo clave de la base de datos, el identificador
    //sirve al adaptador para acceder de forma indexada a los recursos


    //Se crea el constructor con 5 parámetros: id, nombre, el bitmap y 2 coordenadas
    //que sirven para indicar la fila y la columna que hay que recortar del bitmap

    public Fruta(long id, String name, Bitmap image, int x, int y) {
        this.id = id;
        this.name = name;
        this.quantity = 0;
        this.image = Bitmap.createBitmap(image,
                x*image.getWidth()/4,
                y*image.getHeight()/4,
                image.getWidth()/4,
                image.getHeight()/4);

        //Se escala la imagen para asegurarnos de que no haya problemas con el tallaje de móviles
        //a partir de la imagen recortada
        image = Bitmap.createScaledBitmap(image, 128, 128, false);
        //Independientemente del tamaño original que tuviese el bitmap, la imagen recortada va a tener 128x18 píxeles


    }

    //Se crean los getters para todos los campos

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Bitmap getImage() {
        return image;
    }

    public long getId() {
        return id;
    }

    //Se crea setter solo para quantity porque es el único campo que me interesa que se pueda modificar
    //desde fuera de la clase

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
