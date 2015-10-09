package com.example.profesormanana.ej01_holamundo;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by profesormanana on 10/09/15.
 */
public class MiOnClickListener implements View.OnClickListener {

    private Activity activity;


    public MiOnClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        TextView textViewSaludo = (TextView) activity.findViewById(R.id.txHolaMundo);
    }
}
