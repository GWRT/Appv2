package com.example.appv2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Activity_Menu extends AppCompatActivity {

    private static final String FILE_NAME = "postulantes.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button Nuevo = findViewById(R.id.buttonNuevo);
        Button InfoP = findViewById(R.id.buttonInfoPostulante);
        TextView PostulantesAdd = findViewById(R.id.textViewPostulantes);

        ArrayList<Postulante> postulantes = new ArrayList<Postulante>();

        ActivityResultLauncher<Intent> actLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==1){
                            Intent intent = result.getData();
                            if (intent != null){
                                //postulantes.add((Postulante) intent.getSerializableExtra("postulante"));

                                writePostulante((Postulante) intent.getSerializableExtra("postulante"));

                                PostulantesAdd.setText(postulantes.get(postulantes.size()-1).Resumen());
                            }
                        }
                    }
                }
        );
        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNuevo = new Intent(getApplicationContext(), Activity_PostulanteRegistro.class);
                actLauncher.launch(intentNuevo);
            }
        });

        InfoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle array = new Bundle();
                array.putSerializable("p",postulantes);
                Intent intentInfo = new Intent(getApplicationContext(), Activity_PostulanteInfo.class);
                intentInfo.putExtra("p",array);
                startActivity(intentInfo);
            }
        });

    }

    public void writePostulante(Postulante postulante){
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(postulante.Mostrar().getBytes());
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}