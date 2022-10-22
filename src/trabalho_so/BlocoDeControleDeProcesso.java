/*
 * Representa o bloco de controle de um processo (BCP), que contém as informações gerais para que um processo 
   possa ser retomado na CPU.
	- Contém como campos da classe as seguintes variáveis:
		- Programa: nome do programa que se refere a algum processo em questão.
		- Processo: Contém o endereço de um processo que se refere ao BPC em questão;
		- PC: contador de programa de um processo, guarda o próximo comando a ser executado.
		- Estado: estado do processo (executando, pronto ou bloqueado);
		- Prioridade: prioridade do processo;
		- X: valor do registrador X;
		- Y: valor do registrador Y;
 */

package trabalho_so;

public class BlocoDeControleDeProcesso {
	
	private Processo processo;			// Edenreço do processo na memória
	private String programa;			// Nome do programa
	private String codigo;				// Lista de comandos.
	private String pc;
	private String estado;
	private int prioridade;
	private int x;
	private int y;
	
	public BlocoDeControleDeProcesso(Processo processo) {
		
		this.processo = processo;
		this.programa = processo.getPrograma();
		this.codigo = processo.getComando();
		this.pc = processo.getPc();
		this.estado = processo.getEstado();
		this.prioridade = processo.getPrioridade();
	}
	
	
	public void setBcp(Processo processo, String pc, int x, int y) {
		
		this.pc = pc;
		this.x = x;
		this.y = y;
	}
		public String getPc() {
		return pc;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
