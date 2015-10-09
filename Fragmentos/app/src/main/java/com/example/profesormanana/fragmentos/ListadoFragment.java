package com.example.profesormanana.fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment {

    private ArrayAdapter<Object> adapter;
    private ListView lvCorreos;

    public ListadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado, container, false);

        lvCorreos = (ListView) view.findViewById(R.id.lvCorreos);

        adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                new LinkedList());

        lvCorreos.setAdapter(adapter);

        return view;
    }

    public void setListado(List listado){
        adapter.addAll(listado);
        adapter.notifyDataSetChanged();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        lvCorreos.setOnItemClickListener(listener);
    }


}
