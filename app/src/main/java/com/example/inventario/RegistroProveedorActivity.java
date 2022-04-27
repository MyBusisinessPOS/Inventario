package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inventario.modelos.Cliente;
import com.example.inventario.modelos.Proveedor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroProveedorActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference db_ref;


    private EditText et_registro_proveedor_proveedor, et_registro_proveedor_nombre, et_registro_proveedor_telefono, et_registro_proveedor_email;
    Button button_registrar_proveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_proveedor);

        et_registro_proveedor_proveedor = findViewById(R.id.et_registro_proveedor_proveedor);
        et_registro_proveedor_nombre = findViewById(R.id.et_registro_proveedor_nombre);
        et_registro_proveedor_telefono = findViewById(R.id.et_registro_proveedor_telefono);
        et_registro_proveedor_email = findViewById(R.id.et_registro_proveedor_email);

        button_registrar_proveedor = findViewById(R.id.button_registrar_proveedor);
        button_registrar_proveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creaCliente();
            }
        });
    }


    private void creaCliente(){

        String cliente = et_registro_proveedor_proveedor.getText().toString();
        String nombre = et_registro_proveedor_nombre.getText().toString();
        String telefono = et_registro_proveedor_telefono.getText().toString();
        String email = et_registro_proveedor_email.getText().toString();

        if (cliente.isEmpty()){
            Toast.makeText(RegistroProveedorActivity.this, "Campo proveedor requerido", Toast.LENGTH_LONG).show();
            return;
        }


        if (nombre.isEmpty()){
            Toast.makeText(RegistroProveedorActivity.this, "Campo nombre requerido", Toast.LENGTH_LONG).show();
            return;
        }


        if (telefono.isEmpty()){
            Toast.makeText(RegistroProveedorActivity.this, "Campo telefono requerido", Toast.LENGTH_LONG).show();
            return;
        }


        if (email.isEmpty()){
            Toast.makeText(RegistroProveedorActivity.this, "Campo email requerido", Toast.LENGTH_LONG).show();
            return;
        }

        Proveedor request = new Proveedor();
        request.setProveedor(cliente);
        request.setNombre(nombre);
        request.setTelefono(telefono);
        request.setEmail(email);

        db = FirebaseDatabase.getInstance();
        db_ref = db.getReference("Proveedores");
        db_ref.push().setValue(request);

        Toast.makeText(RegistroProveedorActivity.this, "El proveedor se registro correctamente.",
                Toast.LENGTH_SHORT).show();
        finish();
    }
}