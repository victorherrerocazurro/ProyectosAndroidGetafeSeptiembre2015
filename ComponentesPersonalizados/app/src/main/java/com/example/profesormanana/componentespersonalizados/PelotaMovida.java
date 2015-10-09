package com.example.profesormanana.componentespersonalizados;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 * Created by profesormanana on 05/10/15.
 */
public class PelotaMovida extends SurfaceView {

    public PelotaMovida(Context context) {
        super(context);
    }

    public PelotaMovida(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PelotaMovida(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PelotaMovida(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private boolean movimiento = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //condicion inicializacion
        if (!movimiento) {
            movimiento = true;
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Codigo que se ejecuta en el hilo secundario
                    Canvas canvas = null;

                    int x = 150;
                    int y = 150;

                    int dX = 50;

                    //Condicion finalizacion
                    while (movimiento) {

                        try {
                            canvas = getHolder().lockCanvas();

                            Paint pincelFill = new Paint();

                            pincelFill.setStyle(Paint.Style.FILL);

                            pincelFill.setColor(Color.BLACK);

                            canvas.drawCircle(x, y, 100, pincelFill);

                            x += dX;

                            if (x > getWidth() || x < 0) {
                                dX = -dX;
                            }

                            pincelFill.setColor(Color.CYAN);

                            canvas.drawCircle(x, y, 100, pincelFill);

                            Thread.sleep(300);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            if (canvas != null) {
                                getHolder().unlockCanvasAndPost(canvas);
                            }
                        }

                    }

                }
            });
            //Arranca
            hilo.start();
        } else {
            movimiento = false;
        }

        return super.onTouchEvent(event);
    }
}
