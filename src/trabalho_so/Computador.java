/*
 * Representar um computador e contém o método main.
   O modelo do computador possui somente um sistema operacional e um único processador.
   Quando o computador é ligado, irá inicializar o sistema operacional. 
   A partir disso, o sistema operacional irá começar a realizar as suas próprias rotinas definidas. 
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
