package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.inventario.Utils.Utils;
import com.example.inventario.modelos.Producto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RegistroProductoActivity extends AppCompatActivity {

    Spinner spinnerUnidadMedida, spinnerRack, spinnerTipo;
    String unidadMedidaSeleccionada, rackSeleccionado, tipoSeleccionado;
    Button button_registrar_producto;
    private EditText editTextProducto;

    FirebaseDatabase db;
    DatabaseReference db_ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_producto);
        button_registrar_producto = findViewById(R.id.button_registrar_producto);
        editTextProducto = findViewById(R.id.et_registro_producto_descripcion);

        loadSpinnerUnidadMedida();
        loadSpinnerRack();
        loadSpinnerTipo();

        button_registrar_producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardaProducto();
            }
        });
    }

    private void guardaProducto(){

        String producto = editTextProducto.getText().toString();

        if (producto.isEmpty()){
            Toast.makeText(RegistroProductoActivity.this, "Campo requerido producto", Toast.LENGTH_SHORT);
            return;
        }

        Producto request = new Producto();
        request.setNombre(producto);
        request.setTipo_producto(tipoSeleccionado);
        request.setRack(rackSeleccionado);
        request.setUnidad_medida(unidadMedidaSeleccionada);
        request.setExistencia(0);

        db = FirebaseDatabase.getInstance();
        db_ref = db.getReference("Productos");
        db_ref.push().setValue(request);

        Toast.makeText(RegistroProductoActivity.this, "El producto se registro correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }

    protected String[] getArrayString(final int id) {
        return this.getResources().getStringArray(id);
    }

    private void loadSpinnerRack(){
        //Obtiene el array de las unidades de medida
        String[] array = getArrayString(R.array.rack);

        //Obtiene la lista de Strings
        List<String> arrayList = Utils.convertArrayStringListString(array);

        //Creamos el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_unidad_medida, arrayList);
        spinnerUnidadMedida = findViewById(R.id.spinner_registro_producto_unidad_medida);
        spinnerUnidadMedida.setAdapter(adapter);
        spinnerUnidadMedida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unidadMedidaSeleccionada = spinnerUnidadMedida.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void loadSpinnerUnidadMedida() {

        //Obtiene el array de las unidades de medida
        String[] array = getArrayString(R.array.unidad_medida);

        //Obtiene la lista de Strings
        List<String> arrayList = Utils.convertArrayStringListString(array);

        //Creamos el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_rack, arrayList);
        spinnerRack = findViewById(R.id.spinner_registro_producto_rack);
        spinnerRack.setAdapter(adapter);
        spinnerRack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rackSeleccionado = spinnerRack.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void loadSpinnerTipo() {

        //Obtiene el array de las unidades de medida
        String[] array = getArrayString(R.array.tipo);

        //Obtiene la lista de Strings
        List<String> arrayList = Utils.convertArrayStringListString(array);

        //Creamos el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_tipo, arrayList);
        spinnerTipo = findViewById(R.id.spinner_registro_producto_tipo);
        spinnerTipo.setAdapter(adapter);
        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoSeleccionado = spinnerTipo.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}