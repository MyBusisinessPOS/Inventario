package com.example.inventario;

import com.example.inventario.modelos.Cliente;
import com.example.inventario.modelos.Producto;
import com.example.inventario.modelos.Proveedor;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<String> listClientes=new ArrayList<>();
    ArrayList<String> listProductos=new ArrayList<>();
    ArrayList<String> listProveedores=new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public ArrayList<String> getClientesDatos()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchDataClientes(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchDataClientes(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return listClientes;
    }

    private void fetchDataClientes(DataSnapshot dataSnapshot)
    {
        listClientes.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            String name=ds.getValue(Cliente.class).getEmail();
            listClientes.add(name);
        }
    }

    private void fetchDataProductos(DataSnapshot dataSnapshot)
    {
        listProductos.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            String name=ds.getValue(Producto.class).getNombre();
            listProductos.add(name);
        }
    }

    private void fetchDataProveedores(DataSnapshot dataSnapshot)
    {
        listProveedores.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            String name=ds.getValue(Proveedor.class).getNombre();
            listProveedores.add(name);
        }
    }

}
