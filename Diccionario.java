
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        //termina código en internet
        
        
        for(int i=0; i<elementos.size()-1;i++){
               int posicion=elementos.get(i).indexOf(',');
               String palabraIngles=elementos.get(i).substring(0,posicion);
               String palabraEspañol=elementos.get(i).substring(posicion+1,elementos.get(i).length());
               emparejamientos.add(new Association(palabraIngles, palabraEspañol));
        }
        
        root.setValue(emparejamientos.get(0));
        for (int i=1; i<emparejamientos.size(); i++){
            NuevoNodo(root, emparejamientos.get(i));
            //System.out.println(emparejamientos);
        }
     }
    
    public void NuevoNodo(BinaryTree<Association<String,String>> papa, Association<String,String> dato)
    {
    	//System.out.println(dato.getKey());
        Association<String,String> asociacion=papa.value();
        String llavepapa=asociacion.getKey();
        String llaveDato=dato.getKey();
        int num=llavepapa.compareToIgnoreCase(llaveDato);
        if(num>0 && papa.left()==null){
        	
            papa.setLeft(new BinaryTree<Association<String,String>>(null, null, null,null));
            papa.left().setValue(dato);
            
        }else if(papa.left()!=null){
            
            NuevoNodo(papa.left(),dato);
            
        }
        
        if(num<0 && papa.right()==null){
            
            papa.setRight(new BinaryTree<Association<String,String>>(null, null, null,null));
            papa.right().setValue(dato);
            
        }else if(papa.right()!=null){
           
            NuevoNodo(papa.right(),dato);
            
        }
        
    }
    
    
    
     public String Traduccion(BinaryTree<Association<String,String>> papa, String palabra)
{
	String palabraTraducida = "";
	Association<String,String> asociacion=papa.value();
    String llavepapa=asociacion.getKey();
    //System.out.println("llave P "+llavepapa);
    //System.out.println("palabra "+palabra);
	int num=llavepapa.compareToIgnoreCase(palabra);
	ArrayList<String> cosas = new ArrayList<String>();
	int n=0;
	if(num==0){
		palabraTraducida=papa.value().getValue();
		cosas.add(n,palabraTraducida);
		n=n+1;
	}
	if(num<0){
            if(papa.right()!=null){
                palabraTraducida=Traduccion(papa.right(),palabra);
                
            }else{
                return ("*"+palabra+"*");
            }
	}
	if(num>0){
            if(papa.left()!=null){
                    palabraTraducida=Traduccion(papa.left(),palabra);
              
            }else{
                    return ("*"+palabra+"*");
            }
		
	}
	for(String nombre : cosas){
		System.out.println(nombre);
	}
	return palabraTraducida;
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

	while(elementos.compareTo("")!=0){
	int posicion=elementos.indexOf(' ');
            if(posicion!=-1){
                    texto.add(elementos.substring(0,posicion));
                    elementos=elementos.substring(posicion+1);
            }else{
                    texto.add(elementos);
                    elementos="";
            }
        }
     }
     
     
    public String traducirTexto(){
        
        String resultado="";
        for(int i=0; i<texto.size(); i++){
                resultado+=Traduccion(root, texto.get(i).trim())+" ";
        }
        return resultado;
    }



}
