/*
 * Representar um sistema operacional.
 * Recebe a refer�ncia de um objeto escalonador para ser instanciado.
	- Cont�m uma composi��o com a classe Escalonador: assim poder� realizar o gerenciamento dos processos;
	- Cont�m uma vari�vel para representar a tabela/lista de processos, que faz uma composi��o com a classe BlocoDeControleDeProcesso;
	- M�todos para realizar a escrita e leitura de arquivos;
	- M�todos para 
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
	 * Retorna o processo que est� utilizando a CPU.
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
	
	/* Outros m�todos necess�rios */
	
}
