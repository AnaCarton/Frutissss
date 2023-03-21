package com.example.frutissss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Adaptador extends BaseAdapter {

    //Creamos un adaptador propio que extiende de la clase BaseAdapter e implementa sus métodos
    //son los métodos básicos de un adaptador de datos


    //Array de frutas
    Fruta[] frutas;
    //Contexto de la aplicación
    Context context;

    //Creamos un constructor de la clase con los dos parámetros definidos

    public Adaptador(Fruta[] frutas, Context context) {
        this.frutas = frutas;
        this.context = context;
    }


    //Método para devolver la cantidad de datos que hay en nuestro adaptador
    @Override
    public int getCount() {
        //Devuelve la longitud del array de frutas
        return frutas.length;
    }


    //Este método devuelve un item a partir de un índice 'i' que le pasamos como parámetro
    @Override
    public Object getItem(int i) {
        //Devuelve el item en la posicion i dentro del array de las frutas
        return frutas[i];
    }

    //Devuelve el id del item de la posicion i
    @Override
    public long getItemId(int i) {
        //Devuelve el id del item que está en la posición i (la que le pasamos por parámetro)
        //en el array de frutas
        return frutas[i].getId();
    }

    //En este método hay que generar el layout completo
    //cargar los datos de cada elemento en el modelo de layout
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        //Usamos un LayoutInflater, que se encarga de coger el recurso layout del modelo y generar
        //una vista
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Vamos a crear una vista y, como punto de partida, usamos el modelo de layout "elemento" que ya hemos creado
        // porque el inflater puede construir vistas a partir de modelos
        //hay que indicar de qué depende el modelo, el viewGroup nos lo pasan como parámetro
        View element_view = inflater.inflate(R.layout.elemento,viewGroup, false);

        //Para cada elemento, se referencia una variable
        //se hace el findViewById a partir de la vista creada

        ImageView icon = element_view.findViewById(R.id.imageView_imagen);

        //Se carga el textView con el nombre de la fruta
        TextView textView_Name = element_view.findViewById(R.id.textView_nombre);

        //Se carga el textView con la cantidad de frutas
        TextView textView_Quantity = element_view.findViewById(R.id.textView_cantidad);

        //Se cargan los botones '+' y '-'
        Button buttonPlus = element_view.findViewById(R.id.buttonPlus);
        Button buttonMinus = element_view.findViewById(R.id.buttonMinus);

        //tras referenciar los controles, se cargan los datos del icono de las frutas, el nombre y las cantidades
        //para ello se usa el parámetro i, que indica la posicion dentro del array de frutas de cada elemento
        //icono del elemento
        icon.setImageBitmap(frutas[i].getImage());
        //nombre del elemento
        textView_Name.setText(frutas[i].getName());
        //cantidad del elemento, pasando de integer a String
        textView_Quantity.setText(String.valueOf(frutas[i].getQuantity()));

        //Creamos los listeners de los botones de más y de menos
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recogemos el valor del textView_quantity
                int cantidad = Integer.parseInt(textView_Quantity.getText().toString());
                //Controles de que solo si el número es menor que 100 se pueda añadir una unidad
                if (cantidad < 100 ){
                    cantidad++;
                    //Se establece la cantidad actualizada en el textView
                    textView_Quantity.setText(String.valueOf(cantidad));
                    //Hay que guardar el cambio en el array
                    //Cuando se usa una variable global en un listener, hay que definirla como final (la i)
                    frutas[i].setQuantity(cantidad);
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recogemos el valor del textView_quantity
                int cantidad = Integer.parseInt(textView_Quantity.getText().toString());
                //Controles de que si el número es positivo se pueda restar pero si es negativo no
                if (cantidad > 0 ){
                    cantidad--;
                    //Se establece la cantidad actualizada en el textView
                    textView_Quantity.setText(String.valueOf(cantidad));
                    //Hay que guardar el cambio en el array
                    //Cuando se usa una variable global en un listener, hay que definirla como final (la i)
                    frutas[i].setQuantity(cantidad);
                }
            }
        });

        //Para reconocer los clics en la fruta, al hacer clic en la vista
        element_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Al hacer clic, se mostrará el nombre de la fruta en cuestión y la cantidad que lleva seleccionada
                String message=frutas[i].getName() + ": " + String.valueOf(textView_Quantity.getText());
                Toast.makeText(context.getApplicationContext(), message,Toast.LENGTH_SHORT).show();
            }
        });
        //El método devuelve la vista creada
        return element_view;
    }
}