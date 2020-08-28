package sergio.com.datos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= "MainActivity";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate= (EditText) findViewById(R.id.tvFecha);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int año=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        año,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListener= new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker , int año, int mes, int dia){
                mes=mes+1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy:" + dia + "/" + mes + "/" + año);

                String date= dia + "/" + mes + "/" + año;
                mDisplayDate.setText(date);
            }
        };
    }
    public void siguiente (View button) {

        Intent i= new Intent (MainActivity.this,Datos.class);
        EditText tvNombre=(EditText) findViewById(R.id.tvNombre);
        EditText tvFecha=(EditText)findViewById(R.id.tvFecha) ;
        EditText tvTelefono=(EditText)findViewById(R.id.tvTelefono) ;
        EditText tvEmail=(EditText)findViewById(R.id.tvEmail) ;
        EditText tvDescripcion=(EditText)findViewById(R.id.tvDescripcion) ;
        i.putExtra(getResources().getString(R.string.cNombre),tvNombre.getText().toString());
        i.putExtra(getResources().getString(R.string.cFecha),tvFecha.getText().toString());
        i.putExtra(getResources().getString(R.string.cTelefono),tvTelefono.getText().toString());
        i.putExtra(getResources().getString(R.string.cEmail),tvEmail.getText().toString());
        i.putExtra(getResources().getString(R.string.cDescripcion),tvDescripcion.getText().toString());
        startActivity(i);
    }
}