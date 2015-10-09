package com.example.profesormanana.componentespersonalizados;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by profesormanana on 05/10/15.
 */
public class Pelota extends View{

    private int fillColor;
    private int strokeColor;

    private float cx;
    private float cy;
    private float radio;
    private Paint pincelStroke;
    private Paint pincelFill;

    public Pelota(Context context) {
        this(context, null);
    }

    public Pelota(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Pelota(Context context, AttributeSet attrs, int defStyleAttr) {
       this(context, attrs, defStyleAttr, 0);
    }

    public Pelota(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        radio = 100;



        //pincelFill.setColor(((ColorDrawable)getBackground()).getColor());

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Pelota,
                defStyleAttr,
                defStyleRes
        );

        setFillColor(typedArray.getColor(R.styleable.Pelota_fillColor, Color.GREEN));

        setStrokeColor(typedArray.getColor(R.styleable.Pelota_strokeColor, Color.CYAN));

        pincelFill = new Paint();

        pincelFill.setStyle(Paint.Style.FILL);

        pincelStroke = new Paint();

        pincelStroke.setStyle(Paint.Style.STROKE);
        pincelStroke.setStrokeWidth(12);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //Coordenadas iniciales, despues de que se hayan resuelto las medidas
        cx = getWidth() / 2;
        cy = getHeight() / 2;
    }

    public float getCx() {
        return cx;
    }

    public void setCx(float cx) {
        this.cx = cx;
    }

    public float getCy() {
        return cy;
    }

    public void setCy(float cy) {
        this.cy = cy;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        pincelFill.setColor(getFillColor());

        canvas.drawCircle(cx, cy, radio, pincelFill);

        pincelStroke.setColor(getStrokeColor());

        canvas.drawCircle(cx, cy, radio, pincelStroke);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //Establecer nuevas coordenadas con donde se haya pinchado
        cx = event.getX();
        cy = event.getY();

        //Forzamos que se pinte de nuevo (onDraw)
        invalidate();

        return super.onTouchEvent(event);
    }
}
