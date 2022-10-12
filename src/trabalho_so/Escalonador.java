/*
 * Representar o escalonador do sistema operacional.
	- Cont�m uma composi��o com a classe processo: assim poder� retirar ou colocar os processos na CPU;
	- Cont�m uma vari�vel para indicar o processo que est� usando a CPU;
	- Cont�m uma fila de processos prontos, ORDENADOS POR PRIORIDADE;
	- Cont�m uma fila de processos bloqueados, ORDENADOS POR ORDEM DE CHEGADA;
	- Cont�m uma vari�vel para indicar a quantidade de comandos/instru��es que cada processo poder� executar antes de uma preemp��o;
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
	
	private Processo processo = new Processo();
	private Processo processoEmCPU = null;
	private Queue<Processo> filaDeProntos = new PriorityQueue<>();			// Necess�rio verificar ordena��o por cr�ditos
	private Queue<Processo> filaDeBloqueados = new PriorityQueue<>();		// Pode manter a ordena��o natural, de chegada.
	private int quantum = 0;
	
	
	public Escalonador() {
		
		
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
