package br.com.estruturaDados.model.interfaces;

import br.com.estruturaDados.model.enums.TypeSorted;
import br.com.estruturaDados.model.enums.WaySorted;
import br.com.estruturaDados.model.exception.LinearException;

/**
 * Interface de Lista Linear para definir os métodos que irão ser utilizados e
 * diminuir o acoplamento com futuras classes de Lista Linear que irá ser
 * implementado;
 * 
 * @author matheuscastro
 *
 * @param <T>
 *            Lista linear homogênea o tipo da lista deve ser passado para
 *            <tt>T</tt> e ser pego por reflexão;
 */
public interface Linear<T> {

	/**
	 * Método onde procura qual é a posição do elemento passado por parametro;
	 * 
	 * @param element
	 *            Elemento a procurar na lista;
	 * @return A posição do elemento, caso não encontrou retorna -1;
	 * @author matheuscastro
	 * @throws LinearException
	 *             Elemento não encontrado
	 */
	public abstract int find(T element) throws LinearException;

	/**
	 * Método que insere na lista um novo elemento passado por parametro;
	 * 
	 * @param element
	 *            Elemento a ser inserido na lista;
	 * @return <tt>True</tt> para inserção com sucesso; </tt>False</tt> para
	 *         falhas;
	 * @author matheuscastro
	 */
	public abstract boolean add(T element);

	/**
	 * Método que remove da lista o elemento passado por parametro;
	 * 
	 * @param element
	 *            Elemento a ser removido da lista;
	 * @return <tt>True</tt> para remoção com sucesso; <tt>False</tt> para
	 *         falhas;
	 * @author matheuscastro
	 */
	public abstract boolean remove(T element);
	
	/**
	 * Método que retorna qual é o elemento através da posição informada por parametro;
	 * @param pos posição do elemento dentro do array;
	 * @return T é o elemento a ser retornado;
	 * @author matheuscastro
	 */
	public abstract T get(int pos);

	/**
	 * Método que verifica se lista está vazia;
	 * 
	 * @return Dispara exceção ListException para vazia; <tt>False</tt> para
	 *         lista diferente de vazia;
	 * @throws LitException
	 *             Lista vazia
	 * @author matheuscastro
	 */
	public abstract boolean isEmpty() throws LinearException;

	/**
	 * Método que verifica se a lista está cheia;
	 * 
	 * @return Dispara exceção ListException para cheia; <tt>False</tt> para
	 *         lista diferente de cheia;
	 * @throws LinearException
	 *             Lista cheia = Overflow
	 * @author matheuscastro
	 */
	public abstract boolean isFull() throws LinearException;

	/**
	 * Método que retorna o tamaho da lista;
	 * 
	 * @return int contendo o tamanho da lista
	 * @author matheuscastro
	 */
	public abstract int size();
	
	/**
	 * Ordenar
	 * @param ts
	 * @param ws
	 * @author matheuscastro
	 */
	public abstract void sort(TypeSorted ts, WaySorted ws);

//	/**
//	 * Método que informa qual é a ordem atual da lista
//	 * 
//	 * @author matheuscastro
//	 */
//	public abstract String getSort();

	// /**
	// * Mé todo que reorganiza a lista;
	// * @author matheuscastro
	// */
	// public abstract void reorganize(int pos);

}
