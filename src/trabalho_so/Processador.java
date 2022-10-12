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
	 * Define a próxima instrução do PC.
	 */
	public void setpc(String comando) {
		
		this.pc = comando;
	}
	
	/*
	 * Instrução de atribuição do registrador x.
	 */
	public void setx(int num) {
		
		this.x = num;
	}
	
	/*
	 * Instrução de atribuição do registrador y.
	 */
	public void sety(int num) {
		
		this.y = num;
	}
	
	
	/* Métodos de retorno */
	
	public String getpc() {
		
		return this.pc;
	}
	
	public int getx() {
		
		return this.x;
	}
	
	public int gety() {
		
		return this.y;
	}
}
