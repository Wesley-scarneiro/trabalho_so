/*
 * Representa os processos que ser�o executados no computador (Processos).
	- Cont�m uma composi��o com a classe Processador: assim poder� operar em um processador e realizar as intru��es da CPU;
	- Uma vari�vel para indicar o nome do programa a que o processo se refere;
	- Uma lista para guardar as intru��es do programa, em ordem de leitura do arquivo.
	- Uma vari�vel para indicar o estado do processo : pronto, executando ou bloqueado;
	- Uma vari�vel para indicar a prioridade do processo: quanto maior o n�mero, maior a prioridade;
	- Uma vari�vel para indicar o n�mero de cr�ditos do processo: inicia com o mesmo valor da prioridade;
	- Uma vari�vel para indicar a quantidade de comandos do processo: representa a quantidade de quanta do processo;
	- Uma vari�vel para representar o tempo de espera do processo: o tempo necess�rio para o processo ser desbloqueado da fila de bloqueados;
 */


package trabalho_so;

import java.util.*;

public class Processo {
	
	private Processador processador = new Processador();
	private String programa;
	private List<String> comandos = new ArrayList();		// Guarda as instru��es do programa.
	private String estado;
	private int prioridade;
	private int creditos;
	private int numComandos = 0;
	private int tempoEspera;
	
	public Processo() {
		
	}
	
	/*
	 * Define o nome do programa.
	 */
	public void setPrograma(String nome) {
		
		this.programa = nome;
	}
	
	/*
	 * Retorna o nome do programa.
	 */
	public String getPrograma() {
		
		return this.programa;
	}
	
	
	// Fazer outros gets ...
	
	
	/*
	 * Adiciona instru��es do programa na lista de instru��es.
	 * A cada comando recebido do programa, incrementa a vari�vel numComandos.
	 */
	public void adicionarComando(String instrucao) {
		
		comandos.add(instrucao);
		++numComandos;
	}
	
	// falta implementar os outros m�todos...
}
