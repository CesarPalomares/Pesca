package com.codebind;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pescar {

    //Estos son los dos archivos con peces
    static File f1 = new File("florida.txt");
    static File f2 = new File("mediterrania.txt");

    static FileWriter reg;


    public static void sacarPezFlorida(JFrame frame,double r,String user){
        try {
            Scanner myReader = new Scanner(f1);

            //comprueba que pez ha salido por probabilidad
            boolean bandera = true;
            while (myReader.hasNextLine() && bandera){
                String[] pez = separar(myReader.nextLine());
                Double prob = Double.parseDouble(pez[2]);

                if (prob >= r){
                    Double max = Double.parseDouble(pez[4]);
                    Double min = Double.parseDouble(pez[3]);

                    Double pesoNum = Math.floor((Math.random() * (max - min) + min) *100)/100;
                    String peso = pesoNum.toString();

                    //System.out.println("Has pescado un "+pez[1]+" de "+peso+" kilos");
                    JOptionPane.showMessageDialog(frame,"Has pescado un "+pez[1]+" de "+peso+" kilos");

                    guardarPez(user,pez[1],peso);

                    bandera=false;
                }
            }

            myReader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void sacarPezMediterrania(JFrame frame,double r, String user){

        try {
            Scanner myReader = new Scanner(f2);

            //comprueba que pez ha salido por probabilidad
            boolean bandera = true;
            while (myReader.hasNextLine() && bandera){
                String[] pez = separar(myReader.nextLine());
                Double prob = Double.parseDouble(pez[2]);

                if (prob >= r){
                    Double max = Double.parseDouble(pez[4]);
                    Double min = Double.parseDouble(pez[3]);

                    Double pesoNum = Math.floor((Math.random() * (max - min) + min) *100)/100;
                    String peso = pesoNum.toString();

                    //System.out.println("Has pescado un "+pez[1]+" de "+peso+" kilos");
                    JOptionPane.showMessageDialog(frame,"Has pescado un "+pez[1]+" de "+peso+" kilos");

                    guardarPez(user,pez[1],peso);
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

    //Escribe los peces que se han cazado
    public static void guardarPez(String user, String pez, String peso){
        try{
            reg = new FileWriter("registres.txt", true);

            reg.write("#"+user+"#"+pez+"#"+peso+"#"+"\n");

            reg.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public HashMap<String, Integer> verGeneral(){
        HashMap<String,Integer> listaPeces = new HashMap();
        try {
            File regLectura = new File("registres.txt");
            Scanner myreader = new Scanner(regLectura);


            String[] caza;
            while (myreader.hasNextLine()){
                caza = myreader.nextLine().split("#");
                if (!listaPeces.containsKey(caza[2])){
                    listaPeces.put(caza[2],1);
                }else{
                    listaPeces.replace(caza[2],listaPeces.get(caza[2])+1);
                }
            }

            myreader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return listaPeces;
    }

    public HashMap<String, Integer> verUser(String user){
        HashMap<String,Integer> listaPeces = new HashMap();
        try {
            File regLectura = new File("registres.txt");
            Scanner myreader = new Scanner(regLectura);


            String[] caza;
            while (myreader.hasNextLine()){
                caza = myreader.nextLine().split("#");

                if (caza[1].equals(user)) {
                    if (!listaPeces.containsKey(caza[2])) {
                        listaPeces.put(caza[2], 1);
                    } else {
                        listaPeces.replace(caza[2], listaPeces.get(caza[2]) + 1);
                    }
                }
            }

            myreader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return listaPeces;
    }

}
