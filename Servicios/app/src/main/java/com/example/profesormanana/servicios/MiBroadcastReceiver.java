package com.example.profesormanana.servicios;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by profesormanana on 08/10/15.
 */
public class MiBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String param = intent.getStringExtra("param");

        Toast.makeText(context, param, Toast.LENGTH_SHORT).show();
    }
}
