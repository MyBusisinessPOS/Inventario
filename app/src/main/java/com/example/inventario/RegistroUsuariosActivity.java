package com.example.inventario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inventario.modelos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroUsuariosActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference db_ref;
    private FirebaseAuth mAuth;
    EditText editTextNombre;
    EditText editTextPassword;
    EditText editTextEmail;

    Button buttonRegistro;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        mAuth = FirebaseAuth.getInstance();

        editTextNombre = findViewById(R.id.et_nombre_registro);
        editTextPassword = findViewById(R.id.et_pasword_registro);
        editTextEmail = findViewById(R.id.et_correo_registro);
        buttonRegistro = findViewById(R.id.button_registrar_usuario);
        buttonRegistro = findViewById(R.id.button_registrar_usuario);

        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUserWithEmailAndPassword();
            }
        });

    }

    private void createUserWithEmailAndPassword() {

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String nombre = editTextNombre.getText().toString();

        dialog = new ProgressDialog(RegistroUsuariosActivity.this);
        dialog.setMessage("Creando usuario espere...");
        dialog.show();;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if (task.isSuccessful()) {
                            Usuario request = new Usuario();
                            request.setNombre(nombre);
                            request.setCorreo(email);

                            db = FirebaseDatabase.getInstance();
                            db_ref = db.getReference("Usuarios");
                            db_ref.push().setValue(request);

                            Toast.makeText(RegistroUsuariosActivity.this, "Gracias por registrarte.",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            dialog.dismiss();
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(RegistroUsuariosActivity.this, " La dirección de correo electrónico ya está en uso por otra cuenta.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

}