/*
 * Representa um sistema operacional.
   O sistema operacional será necessário somente para chamar o despachante, escalonador e gerenciar a tabela de processos.
   O escalonador será instanciado quando o quantum for lido do arquivo 'quantum.txt' .
	- Contém uma composição com a classe Escalonador: assim poderá realizar o gerenciamento dos processos;
	- Contém uma composição com a classe despachante: assim poderá salvar o BPC de cada processo;
	- Contém uma variável para representar a tabela/lista de processos (ordenação natural por inserção)
	- Métodos para realizar a escrita e leitura de arquivos (métodos de inicialização)
	- Métodos para instanciar processos (ao ler os arquivos de entrada);
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
	 	Relizan as operações necessárias para ler os arquivos de entrada e instanciar os processos.
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
	 * Instância um processo e captura os dados do arquivo.
	 * Captura primeiramente o nome do programa e depois os comandos no laço.
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
	
	/* Outros métodos necessários */
	
}
