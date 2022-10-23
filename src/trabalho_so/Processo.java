/*
 * Representa os processos que serão executados no computador (Processos).
	- Uma variável para indicar o nome do programa a que o processo se refere;
	- Uma lista para guardar as intruções do programa, em ordem de leitura do arquivo.
	- Uma variável para indicar o estado do processo : pronto, executando ou bloqueado;
	- Uma variável para indicar a prioridade do processo: quanto maior o número, maior a prioridade;
	- Uma variável para indicar o número de créditos do processo: inicia com o mesmo valor da prioridade;
	- Uma variável para indicar a quantidade de comandos do processo: representa a quantidade de quanta do processo;
	- Uma variável para representar o tempo de espera do processo: o tempo necessário para o processo ser desbloqueado da fila de bloqueados;
 */

package trabalho_so;

import java.util.*;

public class Processo implements Comparable<Processo>{

	private String nomePrograma;
	private List<String> comandos = new ArrayList(); // Guarda as instruções do programa.
	private String estado;
	private int prioridade;
	private int creditos;
	private int tempoEspera;

	public Processo() {

	}

	public String getPrograma() {
		return nomePrograma;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setTempoEspera(int tempo) {
		this.tempoEspera = tempo;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void decrementarCreditos() {
		--this.creditos;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void decrementarTempoEspera() {
		--this.tempoEspera;
	}
	
	public void setNomePrograma(String nome) {
		
		this.nomePrograma = nome;
	}

	/*
	 * Adiciona instruções do programa na lista de instruções. A cada comando
	 * recebido do programa, incrementa a variável numComandos.
	 */
	public void adicionarComando(String instrucao) {

		comandos.add(instrucao);
	}
	
	/*
	 * Retorna o primeiro comando da lista de comandos do processo.
	 */
	public String getProxComando() {
		
		return comandos.remove(0);
	}
	
	/*
	 * Retorna a referência da lista de comandos do processo.
	 */
	public List<String> getListaComandos() {
		
		return this.comandos;
	}
	
	/*
	 * Imprime os comandos registrados de um processo.
	 * Método para teste, para verificar se os comandos forem lidos corretamente no arquivo.
	 */
	public void imprimirTestes() {
		
		System.out.println("Nome do programa: " + this.nomePrograma + " | Número de comandos: "
							+ " | Prioridade: " + this.prioridade + " | Créditos: " + this.creditos);
		System.out.println("\t"+ comandos);
	}
	
	public String toString() {
		
		return this.nomePrograma;
	}

	@Override
	/*
	 * Especifica o método de comparação entre os processos, utilizado na fila de prioridades.
	 * Processos com  maior quantidade de créditos ficam entre os primeiros da fila.
	 */
	public int compareTo(Processo p) {
		
		if (this.creditos > p.creditos) return -1;
		else if (this.creditos < p.creditos) return 1;
		else return 0;
	}



	// falta implementar os outros métodos...?
}
