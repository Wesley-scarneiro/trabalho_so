/*
 * Representa um sistema operacional.
   O sistema operacional ser� necess�rio somente para chamar o despachante, escalonador e gerenciar a tabela de processos.
   O escalonador ser� instanciado quando o quantum for lido do arquivo 'quantum.txt' .
	- Cont�m uma composi��o com a classe Escalonador: assim poder� realizar o gerenciamento dos processos;
	- Cont�m uma composi��o com a classe despachante: assim poder� salvar o BPC de cada processo;
	- Cont�m uma vari�vel para representar a tabela/lista de processos (ordena��o natural por inser��o)
	- M�todos para realizar a escrita e leitura de arquivos (m�todos de inicializa��o)
	- M�todos para instanciar processos (ao ler os arquivos de entrada);
 */

package trabalho_so;

import java.util.*;

public class SistemaOperacional {
	
	private Escalonador escalonador;
	private Despachante despachante;
	private List<BlocoDeControleDeProcesso> tabelaDeProcessos = new ArrayList();
	
	public SistemaOperacional(Processador cpu) {
		
		this.despachante = new Despachante(cpu);
	}
	
	/*
	 	Inicializa o sistema operacional.
	 	Relizan as opera��es necess�rias para ler os arquivos de entrada e instanciar os processos.
	 */
	public void inicializar() {
		
		
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
