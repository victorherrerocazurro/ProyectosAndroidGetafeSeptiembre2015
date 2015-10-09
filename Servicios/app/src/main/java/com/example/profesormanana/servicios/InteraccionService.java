package com.example.profesormanana.servicios;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class InteraccionService extends Service {
    public InteraccionService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    //Metodo que responde al startService()

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    //El metodo que se ejecute cuando el sistema vaya a loberar este servicio
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //responde al bindService()
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        public InteraccionService getService(){
            return InteraccionService.this;
        }
    }

    public void saludar(String saludo){
        Toast.makeText(InteraccionService.this, saludo, Toast.LENGTH_SHORT).show();
    }
}
