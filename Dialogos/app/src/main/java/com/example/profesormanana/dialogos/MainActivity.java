package com.example.profesormanana.dialogos;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MainActivity extends Activity {

    private DatePickerDialog datePickerDialog;
    private GregorianCalendar calendar = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                calendar.set(year,monthOfYear,dayOfMonth);

                TextView resultado = (TextView) findViewById(R.id.resultado);

                resultado.setText(sdf.format(calendar.getTime()));

                datePickerDialog.hide();

            }
        }, 2015, 8, 21); //Cuidado con el mes para el View Calendar, que empieza en 0 (enero)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SeleccionColorDialogFragment dialogFragment = new SeleccionColorDialogFragment();

            dialogFragment.show(getFragmentManager(),"SeleccionColorDialogFragment");

            return true;
        } else if(id == R.id.action_calendario){
            datePickerDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
