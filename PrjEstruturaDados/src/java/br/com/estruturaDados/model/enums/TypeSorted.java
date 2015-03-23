package br.com.estruturaDados.model.enums;

/**
 * Enum para defenir o tipo de ordenação a ser implementado na lista: HEAP =
 * INSERTION = Ordenação por inserção; BUBBLE = SELECTION = Ordenação por
 * seleção; MERGE = Ordenação por intercalação; QUICK = Ordenação rápida;
 * 
 * @author matheuscastro
 * 
 */
public enum TypeSorted {
	
	
	HEAP ("Pilha"), 
	INSERTION ("Inserção"),
	BUBBLE ("Bolha"),
	SELECTION ("Seleção"),
	MERGE ("Junção"),
	QUICK ("Rápida");
	
	private static final String ORDENACAO = "Tipo de Ordenação: ";
	private final String nome;
	
	private TypeSorted(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String toString(){
		return ORDENACAO + this.nome;
	}
}
