package com.example.profesormanana.fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleCorreoElectronicoFragment extends Fragment {

    private EditText etAsunto;
    private EditText etRemitente;
    private EditText etDestinatario;
    private EditText etContenido;

    public DetalleCorreoElectronicoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        etAsunto = (EditText) view.findViewById(R.id.etAsunto);
        etRemitente = (EditText) view.findViewById(R.id.etRemitente);
        etDestinatario = (EditText) view.findViewById(R.id.etDestinatario);
        etContenido = (EditText) view.findViewById(R.id.etcontenido);

        return view;
    }

    public void actualizarDetalle(CorreoElectronico item){
        etAsunto.setText(item.getAsunto());
        etRemitente.setText(item.getRemitente());
        etDestinatario.setText(item.getDestinatario());
        etContenido.setText(item.getContenido());
    }
}
