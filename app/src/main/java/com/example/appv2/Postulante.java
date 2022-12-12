package com.example.appv2;

import java.io.Serializable;

public class Postulante implements Serializable {
    String dni;
    String nombres;
    String apPaterno;
    String apMaterno;
    String fechaNac;
    String colegioP;
    String carrera;
    public Postulante(){}
    public Postulante(String DNI, String Nombres, String ApPaterno, String ApMaterno, String FechaNac, String ColegioP, String Carrera){
        this.dni=DNI;
        this.nombres=Nombres;
        this.apPaterno=ApPaterno;
        this.apMaterno=ApMaterno;
        this.fechaNac=FechaNac;
        this.colegioP=ColegioP;
        this.carrera=Carrera;
    }
    public String Resumen(){
        return  "\nDNI: "+dni+"\tNombre: "+nombres;
    }
    public String Mostrar(){
        return  "\n|-> DNI: "+dni
                +"\n|-> Nombre: "+nombres
                +"\n|-> Apellidos: "+ apPaterno+" "+apMaterno
                +"\n|-> Fecha de Nacimiento: "+fechaNac
                +"\n|-> Colegio de Procedencia: "+colegioP
                +"\n|-> Carrera: "+carrera+"\n";
    }
}
