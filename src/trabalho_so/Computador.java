/*
 * Representar um computador e cont�m o m�todo main.
   O modelo do computador possui somente um sistema operacional e um �nico processador.
   Quando o computador � ligado, ir� inicializar o sistema operacional. 
   A partir disso, o sistema operacional ir� come�ar a realizar as suas pr�prias rotinas definidas. 
 */

package trabalho_so;

public class Computador {
	
	/*
	 	Atributos fixos do computador.
	 */
	private Processador cpu = new Processador();
	private SistemaOperacional so = new SistemaOperacional(cpu);

	
	/*
	 	Inicializa um SO.
	 */
	public void ligar() {
		
		so.inicializar();
	}

	public static void main(String[] args) {
		
		Computador pc = new Computador();
		pc.ligar();
	}

}
