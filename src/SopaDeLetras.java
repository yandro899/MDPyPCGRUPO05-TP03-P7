import java.util.Random;

/*
 * Convenio:
 * Se deben escribir las funciones con "static", para asi no tener que crear una
 * clase de este objeto. Es mejor usar SopaDeLetras.dibujarSopa() que
 * SopaDeLetras objetoSopa = new SopaDeLetras()
 * objetoSopa.dibujarSopa()
 * Es mas rapido y corto hacer lo primero que lo segundo. Por eso se usa "static" en
 * las funciones
 */
public class SopaDeLetras {
	// Array de palabras a usar en la sopa de letras
	static String [] palabrasSopa = {
			"camello",
			"elefante",
			"aguila",
			"camaleon",
			"avestruz",
			"cocodrilo",
			"antilope",
			"serpiente",
			"bufalo",
			"comadreja"
	};
	static int tamano = 12;			// Tamaño del cuadro que se usa
	static char [][] sopa;			// Matriz de la sopa de letras (sin instanciar)
	
	// Funcion principal
	public static void main(String[] args) {
		sopa = new char[tamano][tamano];			// Creación de la matriz
		
		SopaDeLetras.rellenarSopa();			
		SopaDeLetras.dibujarSopa();
	}
	
	private static void rellenarSopa() {
		/*
		 * Funcion que rellena cada caracter de la sopa.
		 * Ejecutarla solo una vez hecha la colocación de las palabras
		 * dentro de la sopa de letras
		 */
		
		Random r;		// Creacion de una variable aleatoria.
		
		// Se usa dos estructuras for para acceder a los
		// distintos cuadros de la sopa y llenarlos
		for (int i=0; i<tamano; i++)
		{
			for (int j=0; j<tamano; j++)
			{
				/*
				 * TODO: BUG que no permite que la generacion aletoria
				 * de caracteres sea correcta. Resolver
				 */
				r = new Random(System.currentTimeMillis()*j*i);	// Regeneracion semilla numero aleatorio
				sopa[i][j] = (char)(97+r.nextInt(26));			// Numero aleatorio entre 97 y 122, que luego
																// transforma a su equivalente numerico en ASCII
			}
		}
	}
	
	private static void dibujarSopa() {
		/*
		 * Funcion que dibuja la sopa en pantalla.
		 */
		
		for (int i=0; i<tamano; i++)
		{
			for (int j=0; j<tamano; j++)
			{
				System.out.print("|" + sopa[i][j]);
			}
			System.out.println("|");
		}
	}

}
