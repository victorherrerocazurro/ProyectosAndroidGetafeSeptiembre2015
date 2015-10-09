package com.example.profesormanana.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView pantalla;

    private Button numero0;
    private Button numero1;
    private Button numero2;
    private Button numero3;
    private Button numero4;
    private Button numero5;
    private Button numero6;
    private Button numero7;
    private Button numero8;
    private Button numero9;

    private Button sumar;
    private Button restar;
    private Button multiplicar;
    private Button dividir;

    private Button igual;

    private int resultado = 0;
    private char operacion = '+';
    private int operador = 0;
    private boolean pantallaMuestraResultado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = (TextView) findViewById(R.id.pantalla);

        numero0 = (Button) findViewById(R.id.numero0);
        numero1 = (Button) findViewById(R.id.numero1);
        numero2 = (Button) findViewById(R.id.numero2);
        numero3 = (Button) findViewById(R.id.numero3);
        numero4 = (Button) findViewById(R.id.numero4);
        numero5 = (Button) findViewById(R.id.numero5);
        numero6 = (Button) findViewById(R.id.numero6);
        numero7 = (Button) findViewById(R.id.numero7);
        numero8 = (Button) findViewById(R.id.numero8);
        numero9 = (Button) findViewById(R.id.numero9);

        sumar = (Button) findViewById(R.id.sumar);
        restar = (Button) findViewById(R.id.resta);
        multiplicar = (Button) findViewById(R.id.multiplicacion);
        dividir = (Button) findViewById(R.id.division);

        igual = (Button) findViewById(R.id.igual);

        View.OnClickListener listenerNumeros = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pantallaMuestraResultado){
                    pantalla.setText("");
                }

                String numeroPulsado = ((Button) v).getText().toString();

                pantalla.setText(pantalla.getText().toString() + numeroPulsado);

            }
        };

        numero0.setOnClickListener(listenerNumeros);
        numero1.setOnClickListener(listenerNumeros);
        numero2.setOnClickListener(listenerNumeros);
        numero3.setOnClickListener(listenerNumeros);
        numero4.setOnClickListener(listenerNumeros);
        numero5.setOnClickListener(listenerNumeros);
        numero6.setOnClickListener(listenerNumeros);
        numero7.setOnClickListener(listenerNumeros);
        numero8.setOnClickListener(listenerNumeros);
        numero9.setOnClickListener(listenerNumeros);

        View.OnClickListener listenerOperaciones = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Transferir el numero de la pantalla al operador
                operador = Integer.parseInt(pantalla.getText().toString());
                //Resolver la anterior operacion
                resolverOperacion();
                //Actualizar bandera de estado de pantalla
                pantallaMuestraResultado = true;
                //Presentamos el resultado en pantalla
                pantalla.setText(String.valueOf(resultado));
                //Actualizar  operacion
                operacion = ((Button)v).getText().toString().charAt(0);

            }

            private void resolverOperacion() {
                switch (operacion){
                    case '+':
                        resultado += operador;
                        break;
                    case '-':
                        resultado -= operador;
                        break;
                    case '*':
                        resultado *= operador;
                        break;
                    case '/':
                        resultado /= operador;
                        break;
                    case '=':
                        resultado = operador;
                        break;

                }
            }
        };

        sumar.setOnClickListener(listenerOperaciones);
        restar.setOnClickListener(listenerOperaciones);
        multiplicar.setOnClickListener(listenerOperaciones);
        dividir.setOnClickListener(listenerOperaciones);
        igual.setOnClickListener(listenerOperaciones);

    }
}
