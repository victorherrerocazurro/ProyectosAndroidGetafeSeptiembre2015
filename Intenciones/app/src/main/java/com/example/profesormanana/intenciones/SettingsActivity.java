package com.example.profesormanana.intenciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SettingsActivity extends Activity {

    public static final String RESULTADO = "resultado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        View btRetorno = findViewById(R.id.btRetorno);

        btRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Finalizar esta actividad y establece el resultado

                Intent intent = new Intent();

                intent.putExtra(RESULTADO, "Este texto se mostrara en eun TOAST");

                setResult(RESULT_OK, intent);

                SettingsActivity.this.finish();

            }
        });

    }
}
