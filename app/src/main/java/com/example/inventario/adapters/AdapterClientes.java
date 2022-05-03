package com.example.inventario.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventario.R;
import com.example.inventario.modelos.Cliente;
import com.example.inventario.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.Holder> implements Filterable {
    Context c;
    List<Cliente> listClientes;
    private List<Cliente>mDataFilter;
    public AdapterClientes(Context c, List<Cliente> listClientes) {
        this.c = c;
        this.listClientes = listClientes;
        this.mDataFilter = listClientes;
    }

    @NonNull
    @Override
    public AdapterClientes.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(c).inflate(R.layout.item_clientes, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClientes.Holder holder, int position) {
        holder.bind(mDataFilter.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDataFilter.size() > 0) {
            return mDataFilter.size();
        } else {
            return 0;
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filtro = constraint.toString();

                if (filtro.isEmpty()){
                    mDataFilter = listClientes;
                }else {

                    //TODO filtro productos
                    List<Cliente> filtroClientes = new ArrayList<>();
                    for (Cliente row : mDataFilter){
                        if (row.getNombre().toLowerCase().contains(filtro) || row.getCliente().toLowerCase().contains(filtro) ){
                            filtroClientes.add(row);
                        }
                    }
                    mDataFilter = filtroClientes;
                }

                FilterResults results = new FilterResults();
                results.values = mDataFilter;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mDataFilter = (ArrayList<Cliente>) results.values;
                notifyDataSetChanged();
            }
        };
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
