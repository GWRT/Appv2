package com.example.appv2;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper{

    Context fileContext;
    private static final String FILE_NAME = "postulantes.txt";

    public Helper(Context fileContext){
        this.fileContext = fileContext;
    }

    public void writePostulante(Postulante postulante){
        FileOutputStream fos = null;

        try {
            fos = fileContext.openFileOutput(FILE_NAME, Context.MODE_APPEND);
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

    public String readPostulante(){
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        String postulante = "";

        try{
            fis = fileContext.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }

        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            postulante = sb.toString();
        }

        return postulante;
    }

}
