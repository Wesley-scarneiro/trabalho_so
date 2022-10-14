/*
 * Representar o escalonador do sistema operacional.
	- Cont�m uma vari�vel para indicar o processo que est� usando a CPU;
	- Cont�m uma fila de processos prontos, ORDENADOS POR PRIORIDADE;
	- Cont�m uma fila de processos bloqueados, ORDENADOS POR ORDEM DE CHEGADA;
	- Cont�m uma vari�vel quantum para indicar o intervalo de tempo em que um processo poder� fazer uso da CPU.
	� defino na instancia��o da classe, a partir da leitura do arquivo quantum.txt;
	
	- A classe possui os seguintes m�todos:
		- Distribui��o de cr�ditos: Cada processo, na fila de prontos, ter� o seu cr�dito inicial igual a sua prioridade;
		- Ordenar a fila de prontos: Ordenar a fila de processos prontos por ordem de cr�dito, do maior para o menor;
		- Executar processo: 
			- concede a CPU para um processo; 
			- a cada comando/instru��o o processo perde 1 de cr�dito; 
			- quando o cr�dito do processo acabar ser� recolocado na fila de prontos (necess�rio reordenar a fila de prontos); 
			- Quando TODOS os processos estiverem com ZERO de cr�dito, os cr�ditos de cada processo ser�o redistribu�dos e a fila 
			de prontos reeordenada. Depois disso, os processos voltam a executar.
			- Se um processo for bloqueado durante a sua execu��o na CPU, por uma chamada de E/S:
				- Processo � marcado como bloqueado, seu contexto � salvo no BPC e enviado para a fila de bloqueados;
				- Atribui-se um tempo de espera para o processo aguardar o desbloqueio: para cada ada processo que terminar de executar na CPU, o
				tempo de espera de todos os bloqueados ser�o decrementados. Um processo � desbloqueado quando 2 outros processos j� terminaram seu quantum. 
				(O tempo de espera pode ser definido como 2 vezes o n�mero de quantum de um processo).
				- Quando o tempo de espera de um bloqueado acabar, o processo ter� seu contexto restaurado e ser� enviado para a fila de prontos 
				(necess�rios reeordenar a fila de prontos). O processo entra na fila de prontos e executa a pr�xima instru��o guardada no PC (salva no BCP);
				
	- Se a fila de prontos estiver vazia e existir somente bloqueados, o tempo de espera de todos os processos bloqueados ser�o decrementados. Assim, uma hora
	ou outra haver� um processo na fila de prontos para executar.
	- Quando um processo executar a instru��o SAIDA, deixar� de executar na CPU, sair� da fila de prontos e da tabela de processos (perdendo tamb�m o BPC). 
 */

package trabalho_so;

import java.util.*;

public class Escalonador {
	
	private Processo processoEmExecucao = null;								// Processo escolhido para usar a CPU.
	private Queue<Processo> filaDeProntos = new PriorityQueue<>();			// Ordena��o por cr�ditos.
	private List<Processo> filaDeBloqueados = new LinkedList<>();			// Ordena��o natural (FIFO).
	private int quantum;
	
	
	/*
	 	Um escalonador � instanciado ao receber o valor do quantum.
	 */
	public Escalonador(int quantum) {
		
		this.quantum = quantum;
	}
	
	/*
	 * M�todo para adicionar um processo na fila de prontos.
	 * A inser��o � por ordem de cr�ditos.
	 * Processos com maiores quantidade de cr�ditos ficam entre os primeiros.
	 * Processos com menores quantidade de cr�ditos ficam entre os �ltimos.
	 */
	public void adicionarFilaProntos(Processo p) {
		
		filaDeProntos.add(p);
	}
	
	/*
	 * M�todo para remover um processo na fila de prontos.
	 * Remove o primeiro da fila e retorna a sua refer�ncia.
	 * Retorna null se n�o houver mais processos na fila para retirar.
	 */
	public Processo removerFilaProntos() {
		
		if (filaDeProntos.isEmpty()) return filaDeProntos.remove();
		else return null;
	}
	
	/*
	 * Adiciona um processo na fila de bloqueados.
	 * Segue a ordem de chegada: primeiro a entrar � o primeiro a sair (FIFO).
	 */
	public void adicionarFilaBloqueados(Processo p) {
		
		filaDeBloqueados.add(p);
	}
	
	/*
	 * Remove um processo da fila de bloqueados.
	 * Retorna a refer�ncia do processo retirado (sempre o primeiro da fila).
	 * Se n�o houver processos bloqueados, retorna null.
	 */
	public Processo removerFilaBloqueados() {
		
		if (filaDeBloqueados.isEmpty()) return filaDeBloqueados.remove(0);
		else return null;
	}
	
	
	/*
	 * Distribui os cr�ditos para todos os processos da fila de prontos.
	 * Cada processo ter� o seu cr�dito inicial igual a sua prioridade;
	 * J� adiciona os processos em na fila de prontos.
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
