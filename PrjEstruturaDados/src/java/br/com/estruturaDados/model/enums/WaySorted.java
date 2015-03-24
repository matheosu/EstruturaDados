package br.com.estruturaDados.model.enums;

/**
 * "Pior nome que ja dei em um enum" Enum para ordenar os elementos da lista
 * em ordem: ASC = Crescente; DESC = Decrescente; NONE = Nenhum;
 * 
 * @author matheuscastro
 */
public enum WaySorted {

	ASC("Crescente"),
	DESC("Decrescente"),
	NONE("Desordenado");
	
	private static final String ORDEM = "Ordem: ";
	private final String nome;
	
	
	private WaySorted(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String toString(){
		return ORDEM + this.nome;
	}
}
