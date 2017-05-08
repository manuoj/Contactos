package com.ojeda.manuel.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        final TextView Nombre = (TextView) findViewById(R.id.tvNombre);
        final TextView Fecha = (TextView) findViewById(R.id.tvfechaUsuario);
        final TextView Telefono = (TextView) findViewById(R.id.tvtelUsuario);
        final TextView Email = (TextView) findViewById(R.id.tvemailUsuario);
        final TextView Descripcion = (TextView) findViewById(R.id.tvdescripUsuario);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        int dia = parametros.getInt("dia");
        int mes = parametros.getInt("mes");
        int anno = parametros.getInt("anno");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        Nombre.setText(nombre);
        Fecha.setText(" " + dia + "/" + mes + "/" + anno);
        Telefono.setText(" " + telefono);
        Email.setText(" " + email);
        Descripcion.setText(" " + descripcion);


        Button Editar = (Button) findViewById(R.id.btEditar);
        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String nombre = Nombre.getText().toString();
                String telefono = Telefono.getText().toString();
                String email = Email.getText().toString();
                String descripcion = Descripcion.getText().toString();

                Intent intent2 = new Intent(Confirmacion.this, MainActivity.class);
                intent2.putExtra("nombre", nombre);
                intent2.putExtra("telefono", telefono);
                intent2.putExtra("email", email);
                intent2.putExtra("descripcion", descripcion);
                startActivity(intent2);
            }
        });
    }
}
