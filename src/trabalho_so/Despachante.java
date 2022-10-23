/*
 * Representa o despachante (scheduler) do sistema operacional.
 * Sua única função é salvar o contexto dos processos que terminaram de usar a CPU
 * ou restaurar o contexto dos processos  quando forem escalonados novamente para CPU.
 * 	- Possui uma composição com o processador, para poder acessar o PC e seus registradores. 
 */
package trabalho_so;

public class Despachante {

	private Processador cpu;
	
	public Despachante(Processador cpu) {
		
		this.cpu = cpu;
	}
	
	/*
	 * Salva o contexto de um processo no seu BPC (bloco de controle de processo).
	 * Retorna o endereço do BPC para ser guardado na tabela de processos do SO.
	 * Usado quando um processo deixa de usar a CPU.
	 * Obs.: Salva sempre a próxima instrução do programa que precisará ser executada.
	 */
	public void salvarContexto(BlocoDeControleDeProcesso bcp) {
		
		bcp.setBcp(bcp.getProcesso().getProxComando(), cpu.getX(), cpu.getY());
		cpu.setX(0);
		cpu.setY(0);
	}
	
	/*
	 * Restaura o contexto de um processo, a partir do BCP dele.
	 * Recoloca o conteúdo do PC e dos registradores.
	 * O BPC do processo ainda se mantém na tabela de processos do SO.
	 * Usado quando um processo usará a CPU.
	 */
	public int executarProcesso(BlocoDeControleDeProcesso bcp) {
		
		cpu.setPC(bcp.getPc());
		cpu.setX(bcp.getX());
		cpu.setY(bcp.getY());
		return cpu.executar();
	}
	
	/*
	 * Continua a execução de um processo, enquanto o quantum dele ainda não acabar.
	 * Atualizar o BCP somente do que já mudou: lista de comandos e próxima instrução/comando do processo.
	 */
	public void continuarContexto(BlocoDeControleDeProcesso bcp) {
		
		bcp.setBcp(bcp.getProcesso().getProxComando(), cpu.getX(), cpu.getY());
	}
}
