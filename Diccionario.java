
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Pablo Ortiz
 * @author Salvador Recinos
 * @author Paulina Cano
 */
public class Diccionario {
        File direccion = null;
        FileReader fr = null;
        BufferedReader br = null;
        BinaryTree<Association<String,String>>root;
        ArrayList <String> texto = new ArrayList<String>();
    
    public Diccionario(){
        root=new BinaryTree<Association<String,String>>(null, null, null, null);
    }
    
    public void llenar(String ubicacion){
        ArrayList<String> elementos= new ArrayList<String>();
        ArrayList<Association<String,String> >emparejamientos= new ArrayList<Association<String,String>>();
        //Código en la Web
        try {
           //Lectura de archivo, se guardará en dirección. Cambiar la dirección donde este reside.
           direccion = new File (ubicacion);
           fr = new FileReader (direccion);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String palabras;
           int ind=0;
           while((palabras=br.readLine())!=null){
              elementos.add(palabras);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
         
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
		
		public void leertexto(String ubicacion2){
	String elementos="";
	//Código en la web
        try {
        	//Lectura de archivo, se guardará en dirección. Cambiar la dirección donde este reside.
           direccion = new File (ubicacion2);
           fr = new FileReader (direccion);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String palabras;
           int ind=0;
           while((palabras=br.readLine())!=null){
              	elementos=palabras;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        //termina código de web