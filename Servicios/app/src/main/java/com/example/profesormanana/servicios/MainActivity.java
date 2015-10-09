package com.example.profesormanana.servicios;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity{

    private MiBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MiBroadcastReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("com.example.profesormanana.servicios.BROADCAST");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private InteraccionService service;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, DescargaNoticiasIntentService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, 0, 10000, pendingIntent);
            return true;
        } else if(id == R.id.action_parar){
            alarmManager.cancel(pendingIntent);
        } else if(id == R.id.action_enlazar){

            ServiceConnection serviceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    MainActivity.this.service = ((InteraccionService.MyBinder) service).getService();
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    //No se va a poder producir por estar el servicio y su cliente en el mismo proceso
                }
            };

            Intent intent1 = new Intent(this, InteraccionService.class);
            bindService(intent1, serviceConnection, Context.BIND_AUTO_CREATE);

        } else if(id == R.id.action_saludar){
            if (service != null){
                service.saludar("El saludo enviado al servicio");
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
