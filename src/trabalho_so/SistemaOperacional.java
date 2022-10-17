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

import java.io.IOException;
import java.nio.file.Paths;
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
	 	****EM TESTE****
	 */
	public void inicializar() {
		
		try {
			
			lerProcessos("teste_programa.txt");
			
			
		} catch(IOException e) {
			
			System.out.println("Erro ao abrir o arquivo.");
		}
	}

	/*
	 * Realiza a leitura do arquivo de um processo.
	 * Inst�ncia um processo e captura os dados do arquivo.
	 * Captura primeiramente o nome do programa e depois os comandos no la�o.
	 */
	public void lerProcessos(String arquivo) throws IOException {
		
		Scanner input = new Scanner(Paths.get(arquivo));
		Processo p = new Processo();
		
		p.setPrograma(input.next());
		while (input.hasNext()) {
			
			p.adicionarComando(input.next());
		}
		
		p.imprimirComandos(); // ***para teste, verificando se os comandos forem lidos corretamente.***
	}
	
	/*
	 * Realiza a escrita em um arquivo.
	 */
	public void escreverArquivo() {
		
		
	}
	
	/* Outros m�todos necess�rios */
	
}
