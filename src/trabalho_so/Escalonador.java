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
		
		if (filaDeProntos.isEmpty()) return filaDeProntos.remove();
		else return null;
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
	 * Distribui os créditos para todos os processos da fila de prontos.
	 * Cada processo terá o seu crédito inicial igual a sua prioridade;
	 * Já adiciona os processos em na fila de prontos.
	 */
	public void distruirCreditos() {
		
		
	}
	
	/*
	 * Realiza o gerenciamento dos processos.
	 * Escolhe um processo e o executa na CPU.
	 */
	public void executarProcesso() {
		
		
	}
}
