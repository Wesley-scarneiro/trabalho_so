/*
 * Representar um sistema operacional.
 * Recebe a referência de um objeto escalonador para ser instanciado.
	- Contém uma composição com a classe Escalonador: assim poderá realizar o gerenciamento dos processos;
	- Contém uma variável para representar a tabela/lista de processos, que faz uma composição com a classe BlocoDeControleDeProcesso;
	- Métodos para realizar a escrita e leitura de arquivos;
	- Métodos para 
 */

package trabalho_so;

import java.util.*;

public class SistemaOperacional {
	
	private Escalonador escalonador = new Escalonador();
	private List<BlocoDeControleDeProcesso> tabelaDeProcessos = new ArrayList();
	private Processo processo = null;
	
	public SistemaOperacional() {
		
		
	}
	
	
	/*
	 * Retorna o processo que está utilizando a CPU.
	 */
	public Processo getProcesso() {
		
		return processo;
	}
	
	/*
	 * Realiza a leitura de um arquivo.
	 */
	public void lerArquivo() {
		
		
	}
	
	/*
	 * Realiza a escrita em um arquivo.
	 */
	public void escreverArquivo() {
		
		
	}
	
	/* Outros métodos necessários */
	
}
