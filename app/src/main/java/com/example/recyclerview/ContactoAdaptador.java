package com.example.recyclerview;

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

    public ContactoAdaptador(ArrayList<Contacto> lista) {
        this.lista = lista;
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
        Contacto comic = lista.get(position);
        holder.imageView.setImageResource(comic.getImagen());
        holder.nombre.setText(comic.getNombre());
        holder.email.setText(comic.getEmail());
        holder.tlfn.setText(comic.getTlfn());
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
