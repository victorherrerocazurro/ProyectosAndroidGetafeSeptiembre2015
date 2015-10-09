package com.example.profesormanana.camarafotos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends Activity {

    public static final int REQUEST_CODE_THUMBNAIL = 1;
    public static final int REQUEST_CODE_COMPLETA = 0;

    private EditText editText;
    private ImageView imageView;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        int requestCode = REQUEST_CODE_THUMBNAIL;

        if (id == R.id.action_completa) {
            requestCode = REQUEST_CODE_COMPLETA;

            File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            String path = editText.getText().toString() + ".jpg";

            File file = new File(directory, path);

            uri = Uri.fromFile(file);

            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        }

        startActivityForResult(intent, requestCode);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_COMPLETA){

            Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());

            imageView.setImageBitmap(bitmap);

        } else if(requestCode == REQUEST_CODE_THUMBNAIL){

            Bitmap bitmap = data.getParcelableExtra("data");//"data"

            imageView.setImageBitmap(bitmap);
        }

    }
}
