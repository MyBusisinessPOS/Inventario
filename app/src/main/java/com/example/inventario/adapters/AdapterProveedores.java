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
import com.example.inventario.modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class AdapterProveedores extends RecyclerView.Adapter<AdapterProveedores.Holder> implements Filterable {

    Context c;
    List<Proveedor> mData;
    List<Proveedor> mDataFilter;

    public AdapterProveedores(Context c, List<Proveedor> mData) {
        this.c = c;
        this.mData = mData;
        this.mDataFilter = mData;
    }

    @NonNull
    @Override
    public AdapterProveedores.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_proveedor, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProveedores.Holder holder, int position) {
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
                    mDataFilter = mData;
                }else {

                    //TODO filtro productos
                    List<Proveedor> filtroProveedor = new ArrayList<>();

                    for (Proveedor row : mDataFilter){
                        if (row.getNombre().toLowerCase().contains(filtro) || row.getProveedor().toLowerCase().contains(filtro) ){
                            filtroProveedor.add(row);
                        }
                    }
                    mDataFilter = filtroProveedor;
                }

                FilterResults results = new FilterResults();
                results.values = mDataFilter;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mDataFilter = (ArrayList<Proveedor>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textViewTelefono;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_nombre_proveedor);
            textViewTelefono = itemView.findViewById(R.id.tv_telefono_proveedor);
        }

        private void bind(Proveedor proveedor) {
            textView.setText(proveedor.getNombre());
            textViewTelefono.setText("" + proveedor.getTelefono());
        }
    }
}
