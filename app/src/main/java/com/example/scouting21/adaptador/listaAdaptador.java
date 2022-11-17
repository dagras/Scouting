package com.example.scouting21.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scouting21.R;
import com.example.scouting21.entidad.Entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public  class listaAdaptador extends RecyclerView.Adapter<listaAdaptador.EntidadViewHolder>{

    ArrayList<Entidad> listaEntidad;
    ArrayList<Entidad> listaOriginal;

    public listaAdaptador(ArrayList<Entidad>listaEntidad){
        this.listaEntidad = listaEntidad;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaEntidad);
    }
            @NonNull
            @Override
            public EntidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_players,null,false);
                return new EntidadViewHolder(view);

            }

            @Override
            public void onBindViewHolder(@NonNull EntidadViewHolder holder, int position) {
                holder.viewNombre.setText(listaEntidad.get(position).getNombre());
                holder.viewEdad.setText(listaEntidad.get(position).getEdad());
                holder.viewAltura.setText(listaEntidad.get(position).getAltura());
                holder.viewTiro.setText(listaEntidad.get(position).getTiro());
                holder.viewMinutos.setText(listaEntidad.get(position).getMinutos());
                holder.viewPosicion.setText(listaEntidad.get(position).getPosicion());
            }
    public void filtradoNombre(String txtBuscar ){
        int longitud = txtBuscar.length();
        if(longitud == 0){
            listaEntidad.clear();
            listaEntidad.addAll(listaOriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Entidad> coleccion = listaEntidad.stream()
                        .filter(i ->i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase(Locale.ROOT)))
                        .collect(Collectors.toList());
                listaEntidad.clear();
                listaEntidad.addAll(coleccion);
            }else{
                for(Entidad c: listaOriginal){
                    if(c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())){
                        listaEntidad.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public void filtradoEdad(String txtBuscar ) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaEntidad.clear();
            listaEntidad.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Entidad> coleccion = listaEntidad.stream()
                        .filter(i -> i.getEdad().toLowerCase().contains(txtBuscar.toLowerCase(Locale.ROOT)))
                        .collect(Collectors.toList());
                listaEntidad.clear();
                listaEntidad.addAll(coleccion);
            } else {
                for (Entidad c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaEntidad.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public void filtradoAltura(String txtBuscar ) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaEntidad.clear();
            listaEntidad.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Entidad> coleccion = listaEntidad.stream()
                        .filter(i -> i.getAltura().toLowerCase().contains(txtBuscar.toLowerCase(Locale.ROOT)))
                        .collect(Collectors.toList());
                listaEntidad.clear();
                listaEntidad.addAll(coleccion);
            } else {
                for (Entidad c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaEntidad.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public void filtradoTiro(String txtBuscar ) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaEntidad.clear();
            listaEntidad.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Entidad> coleccion = listaEntidad.stream()
                        .filter(i -> i.getTiro().toLowerCase().contains(txtBuscar.toLowerCase(Locale.ROOT)))
                        .collect(Collectors.toList());
                listaEntidad.clear();
                listaEntidad.addAll(coleccion);
            } else {
                for (Entidad c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaEntidad.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public void filtradoMinutos(String txtBuscar ) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaEntidad.clear();
            listaEntidad.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Entidad> coleccion = listaEntidad.stream()
                        .filter(i -> i.getMinutos().toLowerCase().contains(txtBuscar.toLowerCase(Locale.ROOT)))
                        .collect(Collectors.toList());
                listaEntidad.clear();
                listaEntidad.addAll(coleccion);
            } else {
                for (Entidad c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaEntidad.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public void filtradoPosicion(String txtBuscar ) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaEntidad.clear();
            listaEntidad.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Entidad> coleccion = listaEntidad.stream()
                        .filter(i -> i.getPosicion().toLowerCase().contains(txtBuscar.toLowerCase(Locale.ROOT)))
                        .collect(Collectors.toList());
                listaEntidad.clear();
                listaEntidad.addAll(coleccion);
            } else {
                for (Entidad c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaEntidad.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


            @Override
            public int getItemCount() {
              return listaEntidad.size();
            }

            public class EntidadViewHolder extends RecyclerView.ViewHolder {
                TextView viewNombre, viewEdad, viewAltura, viewTiro,viewMinutos,viewPosicion;
                public EntidadViewHolder(@NonNull View itemView) {
                    super(itemView);
                    viewNombre = itemView.findViewById(R.id.viewNombre);
                    viewEdad = itemView.findViewById(R.id.viewEdad);
                    viewAltura = itemView.findViewById(R.id.viewAltura);
                    viewTiro = itemView.findViewById(R.id.viewTiro);
                    viewMinutos = itemView.findViewById(R.id.viewMinutos);
                    viewPosicion = itemView.findViewById(R.id.viewPosicion);
                }
            }
        }
