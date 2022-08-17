package red.lisgar.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import red.lisgar.db.dbjb.DbContactos;

public class Nuevo_activity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtEmail;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuardar = findViewById(R.id.btn_Guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(Nuevo_activity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtEmail.getText().toString());

                if (id > 0){
                    Toast.makeText(Nuevo_activity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(Nuevo_activity.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }
}

