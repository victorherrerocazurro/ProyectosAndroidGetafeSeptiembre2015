package com.example.profesormanana.notificaciones;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

            Notification.Builder builder = new Notification.Builder(this);

            Intent intent = new Intent(this, MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Notification.Action accion = new Notification.Action.Builder(
                    android.R.drawable.ic_media_play,
                    "PLAY",
                    pendingIntent
                ).build();

            builder
                    .setSmallIcon(android.R.drawable.ic_dialog_alert)
                    .setTicker("Es desaparece")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_media_pause))
                    .setContentTitle("El titulo de la notificacion")
                    .setContentText("La descripcion de la notificacion")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .addAction(accion);

            Notification notification = builder.build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(1, notification);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
