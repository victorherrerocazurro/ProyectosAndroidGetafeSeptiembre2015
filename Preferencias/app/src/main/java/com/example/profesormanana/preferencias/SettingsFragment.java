package com.example.profesormanana.preferencias;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by profesormanana on 17/09/15.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.mis_preferencias);
    }
}
