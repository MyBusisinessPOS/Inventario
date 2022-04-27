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
import com.example.inventario.modelos.Producto;

import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.Holder> {

    private Context c;
    private List<Producto>mData;

    public AdapterProductos(Context c, List<Producto> mData) {
        this.c = c;
        this.mData = mData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_productos, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
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
        TextView tv_producto_descripcion;
        TextView tv_producto_ubicacion;
        TextView tv_producto_unidad;
        TextView tv_producto_tipo;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tv_producto_descripcion = itemView.findViewById(R.id.tv_producto_descripcion);
            tv_producto_ubicacion = itemView.findViewById(R.id.tv_producto_ubicacion);
            tv_producto_unidad = itemView.findViewById(R.id.tv_producto_unidad);
            tv_producto_tipo = itemView.findViewById(R.id.tv_producto_tipo);
        }

        private void bind(Producto producto) {
            tv_producto_descripcion.setText(producto.getNombre());
            tv_producto_ubicacion.setText("" + producto.getRack());
            tv_producto_unidad.setText(producto.getUnidad_medida());
            tv_producto_tipo.setText("" + producto.getTipo_producto());

        }
    }
}