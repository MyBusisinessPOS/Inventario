package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    private CardView cardViewCLientes, cardViewProveedores, cardViewProductos, cardViewMateriaPrima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        cardViewCLientes = findViewById(R.id.card_view_clientes);
        cardViewCLientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, ListaClientesActivity.class);
                startActivity(intent);
            }
        });

        cardViewProveedores = findViewById(R.id.card_view_proveedores);
        cardViewProveedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, ListaProveedoresActivity.class);
                startActivity(intent);
            }
        });

        cardViewProductos = findViewById(R.id.card_view_productos);
        cardViewProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, ListaProductosActivity.class);
                startActivity(intent);
            }
        });

        cardViewMateriaPrima = findViewById(R.id.card_view_materia);
        cardViewMateriaPrima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}