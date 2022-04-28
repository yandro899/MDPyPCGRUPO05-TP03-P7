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

		int contPalabrasPuestas = 0;				// Cuenta cuantas palabras fueron ingresadas en la sopa
		sopa = new char[tamano][tamano];			// Creación de la matriz
		Random r = new Random(System.currentTimeMillis());

		while (contPalabrasPuestas<palabrasSopa.length)
		{
			int [] posicion = {0, 0};						// Vector posicion que posiciona la palabra
			int orientacion =  r.nextInt(5)+1;			// Orientacion que define la palabra

			posicion[0] = r.nextInt(tamano);
			posicion[1] = r.nextInt(tamano);

			if (analizarPalabra(palabrasSopa[contPalabrasPuestas], orientacion, posicion))
			{
				ponerPalabra(palabrasSopa[contPalabrasPuestas], orientacion, posicion);
				contPalabrasPuestas++;
			}
		}
		SopaDeLetras.rellenarSopa();			
		SopaDeLetras.dibujarSopa();
	}


	private static void rellenarSopa() {
		/*
		 * Funcion que rellena cada caracter de la sopa.
		 * Ejecutarla solo una vez hecha la colocación de las palabras
		 * dentro de la sopa de letras
		 */
		Random r = new Random(System.currentTimeMillis());		// Creacion de una variable aleatoria.

		// Se usa dos estructuras for para acceder a los
		// distintos cuadros de la sopa y llenarlos
		for (int i=0; i<tamano; i++)
		{
			//r = new Random(System.currentTimeMillis());	// Regeneracion semilla numero aleatorio
			for (int j=0; j<tamano; j++)
			{

				if (sopa[i][j] == '\u0000')
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

	private static boolean analizarPalabra(String palabra, int orientacion, int [] posicion)
	{
		/*
		 * Funcion que elige una palabra del array de palabras,
		 * y mediante posicion aleatoria, analiza si debe ir o no
		 * en la posicion indicada
		 */
		for(int i=0; i<palabra.length(); i++)
		{
			try
			{
				// Esta cosa ^ es un operador XOR
				switch (orientacion) {
				case 1:
					if(!(sopa[posicion[0]][posicion[1]+i] != '\u0000' ^ sopa[posicion[0]][posicion[1]+i] != palabra.charAt(i)))
					{
						return false;
					}
					break;
				case 2:
					if(!(sopa[posicion[0]+i][posicion[1]] != '\u0000' ^ sopa[posicion[0]][posicion[1]+i] != palabra.charAt(i)))
					{
						return false;
					}
					break;
				case 3:
					if(!(sopa[posicion[0]-i][posicion[1]] != '\u0000' ^ sopa[posicion[0]][posicion[1]-i] != palabra.charAt(i)))
					{
						return false;
					}
					break;
				case 4:
					if(!(sopa[posicion[0]][posicion[1]-i] != '\u0000' ^ sopa[posicion[0]][posicion[1]-i] != palabra.charAt(i)))
					{
						return false;
					}					
					break;
				case 5:
					if(!(sopa[posicion[0]+i][posicion[1]+i] != '\u0000' ^ sopa[posicion[0]+i][posicion[1]+i] != palabra.charAt(i)))
					{
						return false;
					}					
					break;
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {
				// para que no tire un error de exceso del array
				return false;
			}
		}
		return true;
	}

	private static void ponerPalabra(String palabra, int orientacion, int [] posicion)
	{
		for(int i=0; i<palabra.length(); i++)
		{

			switch (orientacion) {
			case 1:
				sopa[posicion[0]][posicion[1]+i] = palabra.toUpperCase().charAt(i);
				break;
			case 2:
				sopa[posicion[0]+i][posicion[1]] = palabra.toUpperCase().charAt(i);

				break;
			case 3:
				sopa[posicion[0]-i][posicion[1]] = palabra.toUpperCase().charAt(i);

				break;
			case 4:
				sopa[posicion[0]][posicion[1]-i] = palabra.toUpperCase().charAt(i);
				break;
			case 5:
				sopa[posicion[0]+i][posicion[1]+i] = palabra.toUpperCase().charAt(i);
				break;
			

			}
		}
	}

}
