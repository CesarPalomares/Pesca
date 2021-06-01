package com.codebind;

import java.io.File;
import java.util.Scanner;

public class Pescar {

    //Estos son los dos archivos con peces
    static File f1 = new File("florida.txt");
    static File f2 = new File("mediterrania.txt");


    public static void sacarPezFlorida(double r){
        try {
            Scanner myReader = new Scanner(f1);

            //comprueba que pez ha salido por probabilidad
            boolean bandera = true;
            while (myReader.hasNextLine() && bandera){
                String[] pez = separar(myReader.nextLine());
                Double prob = Double.parseDouble(pez[2]);

                if (prob >= r){
                    System.out.println("Has pescado un "+pez[1]);
                    bandera=false;
                }
            }

            myReader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void sacarPezMediterrania(double r){

        try {
            Scanner myReader = new Scanner(f2);

            //comprueba que pez ha salido por probabilidad
            boolean bandera = true;
            while (myReader.hasNextLine() && bandera){
                String[] pez = separar(myReader.nextLine());
                Double prob = Double.parseDouble(pez[2]);

                if (prob >= r){
                    System.out.println("Has pescado un "+pez[1]);
                    bandera=false;
                }
            }

            myReader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //convierte una linea de un archivo en un array
    public static String[] separar(String pez){
        String[] peces = pez.split("#");
        return peces;
    }

}
