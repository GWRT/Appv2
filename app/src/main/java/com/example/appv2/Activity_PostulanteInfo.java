package com.example.appv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Activity_PostulanteInfo extends AppCompatActivity {

    private static final String FILE_NAME = "postulantes.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        Helper helper = new Helper(getApplicationContext());

        //EditText dni = findViewById(R.id.editTextDNI);
        //Button buscar = findViewById(R.id.buttonBuscar);
        TextView datos = findViewById(R.id.textViewDatos);

        //Intent intent = getIntent();
        //Bundle args = intent.getBundleExtra("p");
        //ArrayList post = (ArrayList<Postulante>) args.getSerializable("p");
//        buscar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String Dni = dni.getText().toString();
//                String d = buscarPorDNI(Dni, post).Mostrar();
//                datos.setText(d);
//            }
//        });

        datos.setText(helper.readPostulante());
    }

//    public Postulante buscarPorDNI(String DNI, ArrayList<Postulante> Post){
//        for (int i=0; i<Post.size(); i++) {
//            if (Post.get(i).dni.equals(DNI))
//                return Post.get(i);
//            }
//        Postulante obj=new Postulante(null, null, null, null, null, null, null);
//        return obj;
//    }
}
