package br.com.estruturaDados.model;

import java.io.Serializable;
import java.lang.reflect.Array;

import br.com.estruturaDados.model.exception.LinearSequencialException;
import br.com.estruturaDados.model.interfaces.Linear;

public class Sequencial<T> implements Serializable, Linear<T> {
	private static final long serialVersionUID = 7672934496211625736L;

	/**
	 * Nome representativo da lista
	 */
	private String name;

	/**
	 * Quantidade de elementos contidos na Lista Linear Sequencial.
	 * 
	 * @serial
	 */
	private int qtdElements = 0;

	/**
	 * Vetor da Lista
	 */
	private T[] elementData;

	/**
	 * Pega a classe passada por reflexão
	 */
	protected Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public Sequencial(int tamanhoInicial) throws LinearSequencialException {
		super();
		if (this.reflection()) {
			if (tamanhoInicial <= 0)
				throw new LinearSequencialException(
						"Tamanho inicial não pode ser menor ou igual 0");
			this.elementData = (T[]) Array.newInstance(
					this.getPersistentClass(), tamanhoInicial);
		} else {
			this.elementData = null;
		}
	}

	@Override
	public int findElement(T element) throws LinearSequencialException {
		this.isEmpty();
		for (int i = 0; i < this.size(); i++) {
			if (this.elementData[i].equals(element)) {
				return i;
			}
		}
		throw new LinearSequencialException(
				"Elemento não encontrado: o elemento passado não foi encontrado na lista");
	}

	@Override
	public T findElementByPos(int pos) {
		return this.elementData[pos];
	}

	@Override
	public boolean addElement(T element) throws LinearSequencialException {
		if (element == null)
			return false;

		this.isFull();
		this.elementData[this.qtdElements] = element;
		this.qtdElements += 1;
		return true;
	}

	@Override
	public boolean removeElement(T element) throws LinearSequencialException {
		if (element == null)
			throw new LinearSequencialException("Elemento nulo!");

		int pos = this.findElement(element);
		this.qtdElements -= 1;
		this.reorganizeLastElement(pos);
		return true;
	}

	@Override
	public int size() {
		return this.elementData.length;
	}

	@Override
	public boolean isEmpty() throws LinearSequencialException {
		if (this.size() == -1)
			throw new LinearSequencialException(
					"Lista Vazia: não contém nenhum elemento na lista");

		return false;
	}

	@Override
	public boolean isFull() throws LinearSequencialException {
		if (this.qtdElements == this.size())
			throw new LinearSequencialException(
					"[ListOverFlow] Lista Cheia: o limite de elementos na lista já foi alcançado");

		return false;
	}

	/**
	 * Método que reorganiza o vetor realocando, a partir da posição passada por
	 * parametro, as posições da direita para esquerda;
	 * 
	 * @param pos
	 *            Posição passada como referencia para a realocação;
	 *            
	 * @author matheuscastro;
	 */
	protected void reorganize(int pos) {
		for (int i = pos; i < qtdElements; i++) {
			this.elementData[i] = this.elementData[i + 1];
		}
	}

	/**
	 * Método que reorganiza o vetor realocando o último elemento para a posição passada por parametro;
	 * 
	 * @param pos
	 *            Posição passada como referencia para a realocação;
	 *            
	 * @author matheuscastro;
	 */
	protected void reorganizeLastElement(int pos) {
		this.elementData[pos] = this.elementData[this.qtdElements];
	}

	private Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	private boolean reflection() {
		// Type tipo = ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.persistentClass = (Class<T>) getClass().getGenericSuperclass();
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.qtdElements; i++) {
			result += this.elementData[i];
			if (!(this.qtdElements - i == 1)) {
				result += ", ";
			}

		}
		return "Lista Linear Sequencial: [" + result + "]";
	}
}
