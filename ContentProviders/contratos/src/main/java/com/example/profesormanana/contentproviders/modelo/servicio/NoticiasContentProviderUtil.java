package com.example.profesormanana.contentproviders.modelo.servicio;

import android.net.Uri;

/**
 * Created by profesormanana on 07/10/15.
 */
public interface NoticiasContentProviderUtil {

    String AUTHORITY = "com.example.profesormanana.com.example.profesormanana.contentproviders";
    Uri URI_AUTHORITY = Uri.parse("content://" + AUTHORITY);

}
