package sergio.com.datos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Datos extends AppCompatActivity {
    private TextView cNombre;
    private TextView cFecha;
    private TextView cTelefono;
    private TextView cEmail;
    private TextView cDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle parametros= getIntent().getExtras();
        assert parametros != null;
        String nombre=parametros.getString(getResources().getString(R.string.cNombre),"nombre");
        String telefono=parametros.getString(getResources().getString(R.string.cTelefono),"telefono");
        String email=parametros.getString(getResources().getString(R.string.cEmail),"email");
        String fecha=parametros.getString(getResources().getString(R.string.cFecha),"fecha");
        String descripcion=parametros.getString(getResources().getString(R.string.cDescripcion),"descripcion");
        cNombre=(TextView) findViewById(R.id.cNombre);
        cTelefono=(TextView) findViewById(R.id.cTelefono);
        cEmail=(TextView) findViewById(R.id.cEmail);
        cFecha=(TextView) findViewById(R.id.cFecha);
        cDescripcion=(TextView) findViewById(R.id.cDescripcion);

        cNombre.setText(nombre);
        cTelefono.setText(telefono);
        cEmail.setText(email);
        cFecha.setText(fecha);
        cDescripcion.setText(descripcion);

    }
    public void volver(View button) {

        Intent j = new Intent(Datos.this, MainActivity.class);
        startActivity(j);
    }
}