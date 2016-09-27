/**
 * @author Pablo Ortiz
 * @author Salvador Recinos
 * @author Paulina Cano
 */
public class Main {
    public static void main (String[] args){
        Diccionario miDiccionario=new Diccionario();
        System.out.println("Recorrido de árbol:");
        miDiccionario.llenar("C:\\Users\\usuario\\Documents\\Universidad\\4to. Semestre\\Algorítmos y Estructura de Datos\\Pruebas\\HDT7-master\\HDT7\\src\\diccionario.txt");
        miDiccionario.leertexto("C:\\Users\\usuario\\Documents\\Universidad\\4to. Semestre\\Algorítmos y Estructura de Datos\\Pruebas\\HDT7-master\\HDT7\\src\\texto.txt");
        System.out.println(miDiccionario.traducirTexto());
    }
}