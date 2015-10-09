package com.example.profesormanana.menucontextual;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.profesormanana.menucontextual.modelo.entidades.Pelicula;
import com.example.profesormanana.menucontextual.modelo.servicio.Servicio;

public class EdicionActivity extends Activity {

    public static final String PELICULA = "pelicula";
    public static final String POSICION = "posicion";

    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        CarteleraApplication context = (CarteleraApplication) getApplicationContext();

        servicio = context.getServicio();

        final EditText etTitulo = (EditText) findViewById(R.id.etTitulo);
        final EditText etDuracion = (EditText) findViewById(R.id.etDuracion);
        final EditText etHorario = (EditText) findViewById(R.id.etHorario);
        final EditText etGenero = (EditText) findViewById(R.id.etGenero);

        View btGuardar = findViewById(R.id.btGuardar);

        //Inicializacion de los componentes

        //No MVC
        //final Pelicula pelicula = (Pelicula) getIntent().getSerializableExtra(PELICULA);

        final int posicion = getIntent().getIntExtra(POSICION, -1);

        //MVC
        final Pelicula pelicula = servicio.getPeliculaById(posicion);

        etTitulo.setText(pelicula.getTitulo());
        etDuracion.setText(String.valueOf(pelicula.getDuracion()));
        etHorario.setText(pelicula.getHorario());
        etGenero.setText(pelicula.getGenero());

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pelicula.setTitulo(etTitulo.getText().toString());
                pelicula.setDuracion(Integer.parseInt(etDuracion.getText().toString()));
                pelicula.setHorario(etHorario.getText().toString());
                pelicula.setGenero(etGenero.getText().toString());

                //MVC
                servicio.updatePelicula(posicion, pelicula);

                //Retorno, aqui al emplear la misma intencion que da origen a esta actividad,
                //conseguimos reutilizar todos las las caracteristicas de esa intencion,
                //entre otras cualquier parametro de mas, que se pasase en el Extras de la
                //intencion, como en este caso sera la posicion
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });
    }
}
