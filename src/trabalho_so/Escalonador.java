/*
 * Representar o escalonador do sistema operacional.
	- Contém uma variável para indicar o processo que está usando a CPU;
	- Contém uma fila de processos prontos, ORDENADOS POR PRIORIDADE;
	- Contém uma fila de processos bloqueados, ORDENADOS POR ORDEM DE CHEGADA;
	- Contém uma variável quantum para indicar o intervalo de tempo em que um processo poderá fazer uso da CPU.
	É defino na instanciação da classe, a partir da leitura do arquivo quantum.txt;
	
	- A classe possui os seguintes métodos:
		- Distribuição de créditos: Cada processo, na fila de prontos, terá o seu crédito inicial igual a sua prioridade;
		- Ordenar a fila de prontos: Ordenar a fila de processos prontos por ordem de crédito, do maior para o menor;
		- Executar processo: 
			- concede a CPU para um processo; 
			- a cada comando/instrução o processo perde 1 de crédito; 
			- quando o crédito do processo acabar será recolocado na fila de prontos (necessário reordenar a fila de prontos); 
			- Quando TODOS os processos estiverem com ZERO de crédito, os créditos de cada processo serão redistribuídos e a fila 
			de prontos reeordenada. Depois disso, os processos voltam a executar.
			- Se um processo for bloqueado durante a sua execução na CPU, por uma chamada de E/S:
				- Processo é marcado como bloqueado, seu contexto é salvo no BPC e enviado para a fila de bloqueados;
				- Atribui-se um tempo de espera para o processo aguardar o desbloqueio: para cada ada processo que terminar de executar na CPU, o
				tempo de espera de todos os bloqueados serão decrementados. Um processo é desbloqueado quando 2 outros processos já terminaram seu quantum. 
				(O tempo de espera pode ser definido como 2 vezes o número de quantum de um processo).
				- Quando o tempo de espera de um bloqueado acabar, o processo terá seu contexto restaurado e será enviado para a fila de prontos 
				(necessários reeordenar a fila de prontos). O processo entra na fila de prontos e executa a próxima instrução guardada no PC (salva no BCP);
				
	- Se a fila de prontos estiver vazia e existir somente bloqueados, o tempo de espera de todos os processos bloqueados serão decrementados. Assim, uma hora
	ou outra haverá um processo na fila de prontos para executar.
	- Quando um processo executar a instrução SAIDA, deixará de executar na CPU, sairá da fila de prontos e da tabela de processos (perdendo também o BPC). 
 */

package trabalho_so;

import java.util.*;

public class Escalonador {
	
	private Processo processoEmExecucao = null;								// Processo escolhido para usar a CPU.
	private Queue<Processo> filaDeProntos = new PriorityQueue<>();			// Ordenação por créditos.
	private List<Processo> filaDeBloqueados = new LinkedList<>();			// Ordenação natural (FIFO).
	private int quantum;
	private int tempoEspera = 2;
	
	
	/*
	 	Um escalonador é instanciado ao receber o valor do quantum.
	 */
	public Escalonador(int quantum) {
		
		this.quantum = quantum;
	}
	
	/*
	 * Método para adicionar um processo na fila de prontos.
	 * A inserção é por ordem de créditos.
	 * Processos com maiores quantidade de créditos ficam entre os primeiros.
	 * Processos com menores quantidade de créditos ficam entre os últimos.
	 */
	public void adicionarFilaProntos(Processo p) {
		
		filaDeProntos.add(p);
		
	}
	
	/*
	 * Método para remover um processo na fila de prontos.
	 * Remove o primeiro da fila e retorna a sua referência.
	 * Retorna null se não houver mais processos na fila para retirar.
	 */
	public Processo removerFilaProntos() {
		
		return filaDeProntos.poll();
	}
	
	/*
	 * Adiciona um processo na fila de bloqueados.
	 * Segue a ordem de chegada: primeiro a entrar é o primeiro a sair (FIFO).
	 */
	public void adicionarFilaBloqueados(Processo p) {
		
		filaDeBloqueados.add(p);
	}
	
	/*
	 * Remove um processo da fila de bloqueados.
	 * Retorna a referência do processo retirado (sempre o primeiro da fila).
	 * Se não houver processos bloqueados, retorna null.
	 */
	public Processo removerFilaBloqueados() {
		
		if (filaDeBloqueados.isEmpty()) return filaDeBloqueados.remove(0);
		else return null;
	}
	
	
	
	/*
	 * Realiza o gerenciamento dos processos.
	 * Escolhe um processo e o executa na CPU.
	 */
	public void inicializar(Despachante d, List<BlocoDeControleDeProcesso> tp) {
		
		int contador;				// Controla o quantum de cada processo.
		int espera;					// Conta quantos quantums ocorreram.
		Processo p;
		boolean continuar;
		BlocoDeControleDeProcesso bcp;
		
		while (filaDeProntos.size() != 0 || filaDeBloqueados.size() != 0) {
			
			 /* Quando só há processos na fila de bloqueados. */
			if (filaDeProntos.size() == 0) {
				
				while (filaDeBloqueados.size() != 0) {
					
					decrementarBloqueados();
				}
			}
			
			contador = this.quantum;
			p = removerFilaProntos();
			p.setEstado("executando");
			if (p.getCreditos() > 0) p.decrementarCreditos();
			continuar = true;
			espera = 0;
			bcp = buscarBcp(p, tp);
			
			/* Quando só há processos com zero créditos na fila de prontos, redistribui os créditos. */
			if (p.getCreditos() == 0 && filaDeBloqueados.size() == 0) {
				
				//redistruir os créditos
			}
			

			/* Executa o quantum de um processo. */
			while (contador != 0) {
				
				int retorno = d.executarProcesso(bcp);
				--contador;
						
				if (retorno == 1) {
					
					p.setEstado("bloqueado");
					p.setTempoEspera(tempoEspera);
					d.salvarContexto(bcp);
					adicionarFilaBloqueados(p);
					continuar = false;
					break;
				}
				else if (retorno == -1){
							
					removerBcp(p, tp);
					continuar = false;
					break;	
				}
				else {
					d.continuarContexto(bcp);
					continue;
				}
			}
			
			++espera;			// Conta quantos quantums já ocorreram.
			
			/* Se for o caso, adiciona o processo novamente na fila de prontos. Quando o quantum dele acaba. */
			if (continuar == true) {
				
				d.salvarContexto(bcp);
				adicionarFilaProntos(p);
			}
			
			/* Decrementa o tempo de espera de todos os processos bloqueados a cada determinada quantidade de quantums. */
			if (espera == tempoEspera && filaDeBloqueados.size() != 0) {
				
				decrementarBloqueados();
			}
		}
	}
	
	/*
	 * Remove um processo da tabela de processos do SO.
	 */
	private void removerBcp(Processo p, List<BlocoDeControleDeProcesso> tp) {
		
		for (int i = 0; i < tp.size(); i++) {
		
			if (tp.get(i).getProcesso() == p) tp.remove(i);
		}	
	}
	
	/*
	 * Busca o BCP de um processo na tabela de processos do SO.
	 */
	private BlocoDeControleDeProcesso buscarBcp(Processo p, List<BlocoDeControleDeProcesso> tp) {
		
		for (BlocoDeControleDeProcesso i : tp) {
			
			if (i.getProcesso() == p) return i;
		}
		
		return null;
	}
	
	/*
	 * Decrementa o tempo de espera de todos os processos na fila de bloqueados.
	 * Só decrementa o tempo se for maior que zero.
	 * Quando um processo possui zero de tempo, é adicionado na fila de prontos.
	 */
	private void decrementarBloqueados() {
		
		for (int i = 0; i < filaDeBloqueados.size(); i++) {
			
			if (filaDeBloqueados.get(i).getTempoEspera() > 0) filaDeBloqueados.get(i).decrementarTempoEspera();
			else adicionarFilaProntos(filaDeBloqueados.remove(i));
		}
	}
	
	/*
	 * Imprime a lista de processos prontos.
	 * Para teste.
	 */
	public void imprimirTestes() {
		
		System.out.println("Quantum: " + this.quantum);
		System.out.println("Fila de prontos: " + this.filaDeProntos + " | tamanho: " + filaDeProntos.size());
		System.out.println("Fila de bloqueados: " + this.filaDeBloqueados);
	}
	
	public void imprimirProntos() {
		
		System.out.println("Fila de prontos: " + this.filaDeProntos);
	}
}
