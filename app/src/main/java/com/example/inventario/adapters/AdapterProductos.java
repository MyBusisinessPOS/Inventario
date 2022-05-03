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

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.Holder>  implements Filterable {

    private Context c;
    private List<Producto>mData;
    private List<Producto>mDataFilter;

    public AdapterProductos(Context c, List<Producto> mData) {
        this.c = c;
        this.mData = mData;
        this.mDataFilter = mData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_productos, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
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
                    List<Producto> filtroProductos = new ArrayList<>();

                    for (Producto row : mDataFilter){
                        if (row.getNombre().toLowerCase().contains(filtro) || row.getRack().toLowerCase().contains(filtro) ){
                            filtroProductos.add(row);
                        }
                    }
                    mDataFilter = filtroProductos;
                }

                FilterResults results = new FilterResults();
                results.values = mDataFilter;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mDataFilter = (ArrayList<Producto>) results.values;
                notifyDataSetChanged();
            }
        };

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
