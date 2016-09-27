import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiccionarioTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testllenar() {
		//Se llama al método que a su vez llama al que inserta nuevos nodos en el árbol
		Diccionario miDiccionario = new Diccionario();
		miDiccionario.llenar("C:\\Users\\usuario\\Documents\\Universidad\\4to. Semestre\\Algorítmos y Estructura de Datos\\Pruebas\\HDT7-master\\HDT7\\src\\diccionario.txt");
	}
	
	@Test
	public void testTraducirTexto(){
		Diccionario miDiccionario = new Diccionario();
		miDiccionario.traducirTexto();
		
	}
}
