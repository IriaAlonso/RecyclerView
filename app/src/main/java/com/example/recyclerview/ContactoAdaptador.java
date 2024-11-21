package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador  extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{
    ArrayList<Contacto> lista;
    private final OnItemClickListener listener;
    private final Context context;

    public interface OnItemClickListener {
        void onItemClick(Contacto contacto, int position);
    }

    public ContactoAdaptador(Context context, ArrayList<Contacto> lista, OnItemClickListener listener) {
        this.lista = lista;
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public ContactoAdaptador.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactoAdaptador.ContactoViewHolder contactoViewHolder =
                new ContactoViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto,parent,false)
                );
        return contactoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdaptador.ContactoViewHolder holder, int position) {
        Contacto c = lista.get(position);
        holder.imageView.setImageResource(c.getImagen());
        holder.nombre.setText(c.getNombre());
        holder.email.setText(c.getEmail());
        holder.tlfn.setText(c.getTlfn());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(c, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nombre;
        TextView email;
        TextView tlfn;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.nombre);
            email = itemView.findViewById(R.id.email);
            tlfn = itemView.findViewById(R.id.tlfn);
        }
    }
}
