package com.example.appv2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_PostulanteRegistro extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static String TAG = "MyAPP_Postulantes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);
        EditText DNI = findViewById(R.id.editTextDNI);
        EditText ApPaterno = findViewById(R.id.apPaterno);
        EditText ApMaterno = findViewById(R.id.apMaterno);
        EditText Nombres = findViewById(R.id.nombres);
        EditText FechaN = findViewById(R.id.fechaNac);
        EditText ColegioP = findViewById(R.id.colegioP);
        Spinner Carrera = findViewById(R.id.carrera);
        Button registrar = findViewById(R.id.registrar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.carreras_, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Carrera.setAdapter(adapter);
        Carrera.setOnItemSelectedListener(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = DNI.getText().toString();
                String apPaterno = ApPaterno.getText().toString();
                String apMaterno = ApMaterno.getText().toString();
                String nombres = Nombres.getText().toString();
                String fechaN = FechaN.getText().toString();
                String colegioP = ColegioP.getText().toString();
                String carrera = Carrera.getSelectedItem().toString();
                Postulante postulantenuevo = new Postulante(dni,nombres,apPaterno,apMaterno,fechaN,colegioP,carrera);

                Intent intentNuevo_Menu = new Intent();
                intentNuevo_Menu.putExtra("postulante", postulantenuevo);
                setResult(1,intentNuevo_Menu);
                Activity_PostulanteRegistro.super.onBackPressed();
                //startActivity(intentNuevo_Menu)
                Log.d(TAG, "Registrado!!!!!!!!");
                Toast.makeText(getApplicationContext(),"Postulante Registrado" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.getItemAtPosition(i);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}