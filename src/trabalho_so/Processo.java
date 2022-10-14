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

public class Processo {

	private String programa;
	private List<String> comandos = new ArrayList(); // Guarda as instruções do programa.
	private String estado;
	private int prioridade;
	private int creditos;
	private int numComandos = 0;
	private int tempoEspera;

	public Processo() {

	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPrioridade() {
		return prioridade;
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

	public int getNumComandos() {
		return numComandos;
	}

	public void setNumComandos(int numComandos) {
		this.numComandos = numComandos;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	/*
	 * Adiciona instruções do programa na lista de instruções. A cada comando
	 * recebido do programa, incrementa a variável numComandos.
	 */
	public void adicionarComando(String instrucao) {

		comandos.add(instrucao);
		++numComandos;
	}

	// falta implementar os outros métodos...
}
