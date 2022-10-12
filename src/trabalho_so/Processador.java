/*
 * Representa um processador, que cont�m quatro instru��es (m�todos da classe):
	- Ter� um contador de programa (PC) e dois registradores (X e Y) como campos da classe.
	- Quatro m�todos que representar�o as instru��es que o processador pode executar: 
		- Atribui��o de registrador = <valor>: atribui algum valor para os registradores X e Y;
		- E/S: realiza uma chamada ao SO para um dispositivo de E/S do sistema;
		- COM: a tarefa executada pelo computador;
		- SAIDA: remove o programa em quest�o da mem�ria.
 */

package trabalho_so;

public class Processador {
	
	private String pc;
	private int x;
	private int y;
	
	public Processador() {
		
		
	}
	
	/*
	 * Define a pr�xima instru��o do PC.
	 */
	public void setpc(String comando) {
		
		this.pc = comando;
	}
	
	/*
	 * Instru��o de atribui��o do registrador x.
	 */
	public void setx(int num) {
		
		this.x = num;
	}
	
	/*
	 * Instru��o de atribui��o do registrador y.
	 */
	public void sety(int num) {
		
		this.y = num;
	}
	
	
	/* M�todos de retorno */
	
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
