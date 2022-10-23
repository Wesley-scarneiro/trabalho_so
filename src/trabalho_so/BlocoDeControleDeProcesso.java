/*
 * Representa o bloco de controle de um processo (BCP), que cont�m as informa��es gerais para que um processo 
   possa ser retomado na CPU.
	- Cont�m como campos da classe as seguintes vari�veis:
		- Programa: nome do programa que se refere a algum processo em quest�o.
		- Processo: Cont�m o endere�o de um processo que se refere ao BPC em quest�o;
		- PC: contador de programa de um processo, guarda o pr�ximo comando a ser executado.
		- Estado: estado do processo (executando, pronto ou bloqueado);
		- Prioridade: prioridade do processo;
		- X: valor do registrador X;
		- Y: valor do registrador Y;
 */

package trabalho_so;

import java.util.List;

public class BlocoDeControleDeProcesso {
	
	private Processo processo;			// Edenre�o do processo na mem�ria
	private String nomePrograma;			// Nome do programa
	private List<String> comandos;		// Lista de comandos.
	private String pc;
	private String estado;
	private int prioridade;
	private int x = 0;
	private int y = 0;
	
	public BlocoDeControleDeProcesso(Processo processo) {
		
		this.processo = processo;
		this.nomePrograma = processo.getNomePrograma();
		this.estado = processo.getEstado();
		this.pc = processo.getProxComando();
		this.comandos = processo.getListaComandos();
		this.prioridade = processo.getPrioridade();
	}
	
	
	public void setBcp(String pc, int x, int y) {
		
		this.pc = pc;
		this.x = x;
		this.y = y;
		this.estado = this.processo.getEstado();
		this.comandos = this.processo.getListaComandos();
	}
		public String getPc() {
		return pc;
	}
	
	/*
	 * Para teste.
	 */
	public void imprimirBcp() {
		
		System.out.println("DADOS DO BCP\n" + "Pc: " + pc + "\nX = " + x + " e Y = " + y);
	}
		
	

	public void setComandos(List<String> comandos) {
		this.comandos = comandos;
	}


	public void setPc(String pc) {
		this.pc = pc;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Processo getProcesso() {
		return this.processo;
	}
	
	public String toString() {
		
		return this.nomePrograma;
	}

}
