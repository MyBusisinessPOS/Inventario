package com.example.inventario.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventario.R;
import com.example.inventario.modelos.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.Holder> {
    Context c;
    List<Cliente> listClientes;

    public AdapterClientes(Context c, List<Cliente> listClientes) {
        this.c = c;
        this.listClientes = listClientes;
    }

    @NonNull
    @Override
    public AdapterClientes.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(c).inflate(R.layout.item_clientes, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClientes.Holder holder, int position) {
        holder.bind(listClientes.get(position));
    }

    @Override
    public int getItemCount() {
        if (listClientes.size() > 0) {
            return listClientes.size();
        } else {
            return 0;
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textViewTelefono;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_nombre_cliente);
            textViewTelefono = itemView.findViewById(R.id.tv_telefono_cliente);
        }

        private void bind(Cliente clienteNombre) {
            textView.setText(clienteNombre.getNombre());
            textViewTelefono.setText("" + clienteNombre.getTelefono());
        }
    }
}
