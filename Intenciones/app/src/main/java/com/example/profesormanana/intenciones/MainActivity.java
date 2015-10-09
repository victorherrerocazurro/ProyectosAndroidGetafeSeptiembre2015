package com.example.profesormanana.intenciones;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    public static final int REQUEST_CODE_SETTINGS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btNavegar = (Button) findViewById(R.id.btNavegar);

        btNavegar.setOnClickListener(this);

        Button btNavegarResultado = (Button) findViewById(R.id.btNavegarResultado);

        btNavegarResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this.getApplicationContext(), SettingsActivity.class);

                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
            }

            // TRAMPA!!!!!! De existir este metodo, que no lo usamos para nada, la referencia al contexto,
            // se ha de obtener de MainActivity.this.getApplicationContext(), ya que poner solo
            // getApplicationContext invocaria a este metodo que retorna null
            public Context getApplicationContext() {
                return null;
            }
        });
    }

    //Activity no deberia implementar OnXXXListener, aunque se puede
    @Override
    public void onClick(View v) {

        //Invocacion explicita de SecondaryActivity
        Intent intent = new Intent(this, SecondaryActivity.class);

        Persona persona = new Persona("Victor", "Herrero");

        intent.putExtra("dato", persona);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SETTINGS) {
            //El resultado es de Secondary
            if (resultCode == RESULT_OK) {
                String resultado = data.getStringExtra(SettingsActivity.RESULTADO);

                Toast toast = Toast.makeText(
                        this,
                        "El resultado es: " + resultado,
                        Toast.LENGTH_SHORT);

                toast.show();

            }
        }
    }
}
