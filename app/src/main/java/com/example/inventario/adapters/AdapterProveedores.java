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
import com.example.inventario.modelos.Proveedor;

import java.util.List;

public class AdapterProveedores extends RecyclerView.Adapter<AdapterProveedores.Holder> {

    Context c;
    List<Proveedor> mData;

    public AdapterProveedores(Context c, List<Proveedor> mData) {
        this.c = c;
        this.mData = mData;
    }

    @NonNull
    @Override
    public AdapterProveedores.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_proveedor, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProveedores.Holder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData.size() > 0) {
            return mData.size();
        } else {
            return 0;
        }
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
