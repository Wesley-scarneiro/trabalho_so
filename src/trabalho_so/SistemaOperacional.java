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
	private String [] arqProcessos = {"01.txt", "02.txt", "03.txt", "04.txt", "05.txt", "06.txt", "07.txt", "08.txt", "09.txt", "10.txt"};
	private String arqPrioridades = "prioridades.txt";
	private String arqQuantum = "quantum.txt";
	
	public SistemaOperacional(Processador cpu) {
		
		this.despachante = new Despachante(cpu);
	}
	
	/*
	 * Testa o m�todo inicializar. 
	 * EXCLUIR AO FINALIZAR O TRABALHO.
	 */
	public void testarInicializar() {
		
		try {
			
			escalonador = new Escalonador(carregarQuantum(arqQuantum));
			Scanner input = new Scanner(Paths.get(arqPrioridades));
			
			System.out.println("---> Teste de entrada dos processos <---\n");
			
			for (int i = 0; i < arqProcessos.length; i++) {
				
				Processo p = new Processo();
				carregarProcesso(p, arqProcessos[i], input.nextInt());
				criarBcp(p);
				escalonador.adicionarFilaProntos(p);
				
				p.imprimirTestes();								// Para teste.
			}
				
			input.close();										// Fecha o arquivo de prioridades.
			System.out.println("Tabela de processos = " + tabelaDeProcessos);
			escalonador.imprimirTestes();						// Para teste.
			System.out.println("\n---> Teste de sa�da da fila de prontos <---\n");
			Processo p = escalonador.removerFilaProntos();
			while (p != null) {
				
				System.out.println("Saiu: " + p);
				escalonador.imprimirProntos();
				p = escalonador.removerFilaProntos();
			}
			
			
		} catch(IOException e) {
			
			System.out.println("Erro ao abrir o arquivo.");
		}
	}
	
	/*
	 	Inicializa o sistema operacional.
	 	Instancia um escalonador ap�s a leitura do quantum e reliza as opera��es necess�rias 
	 	instanciando os processos e lendo os seus arquivos.
	 	Ap�s cada processo ter os seus dados carregados (instru��es e prioridade), ter� o
	 	BCP criado, adicionado na tabela de processos do SO e depois adicionado na fila de processos prontos.
	 	
	 	
	 	.... ouras opera��es para implementar ... 
	 */
	public void inicializar() {
		
		try {
			
			/* Etapa de inicializa��o do SO */
			
			escalonador = new Escalonador(carregarQuantum(arqQuantum));
			Scanner input = new Scanner(Paths.get(arqPrioridades));
			
			for (int i = 0; i < arqProcessos.length; i++) {
				
				Processo p = new Processo();
				carregarProcesso(p, arqProcessos[i], input.nextInt());
				criarBcp(p);
				escalonador.adicionarFilaProntos(p);
			}
				
			input.close();										// Fecha o arquivo de prioridades.
			
			
			/* Etapa em que o escalonador gerencia a execu��o dos processos */
			
			
			
		} catch(IOException e) {
			
			System.out.println("Erro ao abrir o arquivo.");
		}
	}
	
	

	/*
	 * Realiza a leitura do arquivo de quantum do sistema.
	 * Retorna o valor de quantum lido.
	 */
	private int carregarQuantum(String arquivo) throws IOException {
		
		Scanner input = new Scanner(Paths.get(arquivo));
		return input.nextInt();
	}
	
	/*
	 * Realiza a leitura do arquivo de dados de um processo.
	 * Captura primeiramente o nome do programa e depois todos os comandos/instru��es.
	 */
	private void carregarProcesso(Processo p, String arqProcesso, int prioridade) throws IOException {
		
		Scanner input = new Scanner(Paths.get(arqProcesso));
		p.setPrograma(input.next());
		p.setPrioridade(prioridade);
		p.setCreditos(prioridade);
		
		while (input.hasNext()) {
			
			p.adicionarComando(input.next());
		}
		
		input.close();							// Fecha o arquivo.
		p.setPc(p.getComando());
		p.setEstado("pronto");
	}
	
	/*
	 * Cria o BCP de um processo e adiciona na tabela de processos do SO.
	 */
	public void criarBcp(Processo p) {
		
		BlocoDeControleDeProcesso bcp = new BlocoDeControleDeProcesso(p);
		tabelaDeProcessos.add(bcp);
	}
	
	/*
	 * Realiza a escrita em um arquivo.
	 */
	public void escreverArquivo() {
		
		
	}
	
	/* Outros m�todos necess�rios */
	
}
