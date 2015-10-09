package com.example.profesormanana.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by profesormanana on 21/09/15.
 */
public class SeleccionColorDialogFragment extends DialogFragment {

    private AlertDialog.Builder builder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final CharSequence[] colores = {"Rojo","Azul","Verde","Amarillo"};
        final boolean[] seleccionados = {true, false, true, false};

        builder = new AlertDialog.Builder(getActivity());
        builder
            .setMultiChoiceItems(colores, seleccionados, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    seleccionados[which] = isChecked;
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Titulo del dialogo")
            .setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    String resultado = "";

                    for (int i = 0; i < seleccionados.length; i++) {
                        resultado += colores[i] + ":" + seleccionados[i] + "--";
                    }

                    Toast.makeText(
                            SeleccionColorDialogFragment.this.getActivity(),
                            "seleccionados: " + resultado,
                            Toast.LENGTH_LONG
                    ).show();

                    dialog.dismiss();
                }
            });

    }

    //Responde al show()
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return builder.create();
    }

    //Metodos de interaccion con el dialogo
    //  -show
    //  -dismiss
    //  -hide

}
