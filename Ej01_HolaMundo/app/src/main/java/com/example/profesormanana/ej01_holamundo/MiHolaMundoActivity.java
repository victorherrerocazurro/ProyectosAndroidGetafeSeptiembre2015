package com.example.profesormanana.ej01_holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MiHolaMundoActivity extends Activity {

    private Button buttonSaludar;
    private TextView textViewSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_hola_mundo);

        buttonSaludar = (Button) findViewById(R.id.btSaludar);

        buttonSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MiHolaMundoActivity.this.textViewSaludo = (TextView) MiHolaMundoActivity
                                                                .this.findViewById(R.id.txHolaMundo);

                MiHolaMundoActivity.this.textViewSaludo
                        .setText("Este es el texto que queremos que se muestre");

            }
        });

        //buttonSaludar.setOnClickListener(new MiOnClickListener(this));

    }
}
