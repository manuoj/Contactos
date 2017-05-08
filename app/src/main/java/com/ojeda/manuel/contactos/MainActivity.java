package com.ojeda.manuel.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Nombre = (EditText) findViewById(R.id.etNombre);
        final DatePicker Fecha = (DatePicker) findViewById(R.id.dpfecha);
        final EditText Telefono = (EditText) findViewById(R.id.ettelefono);
        final EditText Email = (EditText) findViewById(R.id.etemail);
        final EditText Descripcion = (EditText) findViewById(R.id.etDescripcion);

        Bundle parametros2 = this.getIntent().getExtras();
        if (parametros2 != null) {
            String nombre = parametros2.getString("nombre");
            String telefono = parametros2.getString("telefono");
            String email = parametros2.getString("email");
            String descripcion = parametros2.getString("descripcion");

            Nombre.setText(nombre);
            Telefono.setText(telefono);
            Email.setText(email);
            Descripcion.setText(descripcion);
        }

        Button Siguiente = (Button) findViewById(R.id.btSiguiente);
        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = Nombre.getText().toString();
                int dia = Fecha.getDayOfMonth();
                int mes = Fecha.getMonth();
                int anno = Fecha.getYear();
                String telefono = Telefono.getText().toString();
                String email = Email.getText().toString();
                String descripcion = Descripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this, Confirmacion.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("dia", dia);
                intent.putExtra("mes", mes);
                intent.putExtra("anno", anno);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                startActivity(intent);
            }
        });

    }

}
