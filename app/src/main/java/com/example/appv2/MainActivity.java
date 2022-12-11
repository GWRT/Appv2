package com.example.appv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MyAPP_Postulantes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Usuario = findViewById(R.id.editTextTextUsuario);
        EditText Contraseña = findViewById(R.id.editTextPassword);
        Button Igresar = findViewById(R.id.buttonIngresar);
        TextView Confirmacion = findViewById(R.id.textViewConfirmacion);

        Igresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = Usuario.getText().toString();
                String contraseña = Contraseña.getText().toString();
                Log.d(TAG, contraseña+(usuario.equals("admin")));
                if (usuario.equals("admin") && contraseña.equals("admin")){
                    Log.d(TAG, "Accediendo....");
                    startActivity(new Intent(getApplicationContext(), Activity_Menu.class));
                }
                else{
                    Confirmacion.setText("Nombre o contraeña invalidos");
                }
            }
        });
    }
}