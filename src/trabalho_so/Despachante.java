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
	 */
	public void salvarContexto(Processo processo, BlocoDeControleDeProcesso bcp) {
		
		bcp.setBcp(processo, cpu.getPC(), cpu.getX(), cpu.getY());
	}
	
	/*
	 * Restaura o contexto de um processo, a partir do BCP dele.
	 * Recoloca o conteúdo do PC e dos registradores.
	 * O BPC do processo ainda se mantém na tabela de processos do SO.
	 */
	public void restaurarContexto(BlocoDeControleDeProcesso bcp) {
		
		cpu.setPC(bcp.getPc());
		cpu.setX(bcp.getX());
		cpu.setY(bcp.getY());
	}
}
