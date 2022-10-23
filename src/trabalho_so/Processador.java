/*
 * Representa um processador, que contém quatro instruções (métodos da classe):
	- Terá um contador de programa (PC) e dois registradores (X e Y) como campos da classe.
	- Quatro métodos que representarão as instruções que o processador pode executar: 
		- Atribuição de registrador = <valor>: atribui algum valor para os registradores X e Y;
		- E/S: realiza uma chamada ao SO para um dispositivo de E/S do sistema;
		- COM: a tarefa executada pelo computador;
		- SAIDA: remove o programa em questão da memória.
 */

package trabalho_so;

public class Processador {
	
	private String pc;
	private int x;
	private int y;
	
	public Processador() {
		
		
	}
	
	/*
	 * Interpreta cada instrução/comando de um programa guardado no PC do processador.
	 * Tipos de retornos:
	 * 	0  : Comando de atribuição de registradores ou COM;
	 *  1  : Comando de E/S;
	 *  -1 : Comando de SAIDA;
	 *  
	 *  Os retornos são interpretados pelo escalonador.
	 */
	public int executar() {
		
		if (pc.substring(0, 1).compareTo("X") == 0) {
			
			this.x = Integer.parseInt(pc.substring(2));
			return 0;
		}
		else if (pc.substring(0, 1).compareTo("Y") == 0) {
			
			this.y = Integer.parseInt(pc.substring(2));
			return 0; 
		}
		else if (pc.compareTo("COM") == 0) {
			return 0;
		}
		else if (pc.compareTo("E/S") == 0) {
			
			return 1;
		}
		else {
			
			return -1;
		}
	}
	
	/*
	 * Define a próxima instrução do PC.
	 */
	public void setPC(String comando) {
		
		this.pc = comando;
	}
	
	public void setX(int num) {
		
		this.x = num;
	}
	
	public void setY(int num) {
		
		this.y = num;
	}
	
	/* Métodos de retorno */
	
	public String getPC() {
		
		return this.pc;
	}
	
	public int getX() {
		
		return this.x;
	}
	
	public int getY() {
		
		return this.y;
	}
}
