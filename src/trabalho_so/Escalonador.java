/*
 * Representar o escalonador do sistema operacional.
	- Contém uma composição com a classe processo: assim poderá retirar ou colocar os processos na CPU;
	- Contém uma variável para indicar o processo que está usando a CPU;
	- Contém uma fila de processos prontos, ORDENADOS POR PRIORIDADE;
	- Contém uma fila de processos bloqueados, ORDENADOS POR ORDEM DE CHEGADA;
	- Contém uma variável para indicar a quantidade de comandos/instruções que cada processo poderá executar antes de uma preempção;
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
	
	private Processo processo = new Processo();
	private Processo processoEmCPU = null;
	private Queue<Processo> filaDeProntos = new PriorityQueue<>();			// Necessário verificar ordenação por créditos
	private Queue<Processo> filaDeBloqueados = new PriorityQueue<>();		// Pode manter a ordenação natural, de chegada.
	private int quantum = 0;
	
	
	public Escalonador() {
		
		
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
