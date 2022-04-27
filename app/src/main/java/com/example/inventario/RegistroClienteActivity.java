package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inventario.modelos.Cliente;
import com.example.inventario.modelos.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroClienteActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference db_ref;

    private EditText et_registro_cliente_cliente, et_registro_cliente_nombre, et_registro_cliente_telefono, et_registro_cliente_email;
    Button button_registrar_cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);

        et_registro_cliente_cliente = findViewById(R.id.et_registro_cliente_cliente);
        et_registro_cliente_nombre = findViewById(R.id.et_registro_cliente_nombre);
        et_registro_cliente_telefono = findViewById(R.id.et_registro_cliente_telefono);
        et_registro_cliente_email = findViewById(R.id.et_registro_cliente_email);

        button_registrar_cliente = findViewById(R.id.button_registrar_cliente);
        button_registrar_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creaCliente();
            }
        });
    }


    private void creaCliente(){

        String cliente = et_registro_cliente_cliente.getText().toString();
        String nombre = et_registro_cliente_nombre.getText().toString();
        String telefono = et_registro_cliente_telefono.getText().toString();
        String email = et_registro_cliente_email.getText().toString();

        if (cliente.isEmpty()){
            Toast.makeText(RegistroClienteActivity.this, "Campo cliente requerido", Toast.LENGTH_LONG).show();
            return;
        }


        if (nombre.isEmpty()){
            Toast.makeText(RegistroClienteActivity.this, "Campo nombre requerido", Toast.LENGTH_LONG).show();
            return;
        }


        if (telefono.isEmpty()){
            Toast.makeText(RegistroClienteActivity.this, "Campo telefono requerido", Toast.LENGTH_LONG).show();
            return;
        }


        if (email.isEmpty()){
            Toast.makeText(RegistroClienteActivity.this, "Campo email requerido", Toast.LENGTH_LONG).show();
            return;
        }

        Cliente request = new Cliente();
        request.setCliente(cliente);
        request.setNombre(nombre);
        request.setTelefono(telefono);
        request.setEmail(email);

        db = FirebaseDatabase.getInstance();
        db_ref = db.getReference("Clientes");
        db_ref.push().setValue(request);

        Toast.makeText(RegistroClienteActivity.this, "El cliente se registro correctamente.",
                Toast.LENGTH_SHORT).show();
        finish();
    }
}