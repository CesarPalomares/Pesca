package com.codebind;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminUsuaris {

    static FileWriter fw1;
    static File f1;

    static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        getList();

    }

    public static void registrarUser(String user){
        try{
            fw1 = new FileWriter("usuaris.txt", true);
            fw1.write(user);
            fw1.write("\n");
            fw1.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<String> getList(){
        try{
            ArrayList<String> l = new ArrayList<>();
            f1 = new File("usuaris.txt");

            Scanner myReader = new Scanner(f1);

            while (myReader.hasNextLine()){
                l.add(myReader.nextLine());
            }
            myReader.close();
            return l;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public static void borrarLinea(String user){

        for (String i: getList()){
            lista.add(i);
        }

        lista.remove(user);
        System.out.println(lista);

        try{
            fw1= new FileWriter("usuaris.txt",false);
            fw1.write("");
            fw1.close();

            fw1= new FileWriter("usuaris.txt",true);
            for (String i: lista){
                fw1.write(i+"\n");
            }
            fw1.close();

        }catch (Exception e){
            System.out.println(e);
        }
        lista.clear();
    }

}
