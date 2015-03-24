package br.com.estruturaDados.model;

import java.io.Serializable;
import java.lang.reflect.Array;

import br.com.estruturaDados.model.enums.TypeSorted;
import br.com.estruturaDados.model.enums.WaySorted;
import br.com.estruturaDados.model.exception.SequencialException;
import br.com.estruturaDados.model.interfaces.Linear;

public class Sequencial<T> extends Sorted<T> implements Linear<T>, Serializable {
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

	protected Class<?> persistentClass = Object.class;

	protected TypeSorted tipoOrdenacao = TypeSorted.NONE;

	protected WaySorted ordem = WaySorted.NONE;

	@SuppressWarnings("unchecked")
	public Sequencial(int tamanhoInicial) throws SequencialException {
		if (tamanhoInicial <= 0)
			throw new SequencialException(
					"Tamanho inicial não pode ser menor ou igual 0");
		this.elementData = (T[]) Array.newInstance(this.getPersistentClass(),
				tamanhoInicial);
	}

	@Override
	public int find(T element) {
		this.isEmpty();
		for (int i = 0; i < this.qtdElements; i++) {
			if (this.elementData[i].equals(element)) {
				return i;
			}
		}
		throw new SequencialException(
				"Elemento não encontrado: o elemento passado não foi encontrado na lista");
	}

	@Override
	public T get(int pos) {
		if (pos < 0)
			throw new SequencialException("Posição menor que zero");
		if (pos >= this.qtdElements)
			throw new SequencialException("Posição não alocada");

		return this.elementData[pos];
	}

	/**
	 * Método que realiza a busca binária dentro do vetor;
	 * 
	 * @param element
	 *            é o elemento que deseja procurar no vetor utilizando busca
	 *            binária;
	 * @return retorna a posição do elemento dentro do vetor
	 * @author matheuscastro;
	 * @Lembrar realizar um método para calcular quanto tempo é gasto na busca
	 *          para realizar um comparativo entre a busca sequencial;
	 */
	public int binarySearch(T element) {
		this.isEmpty();
		int base = 0;
		int topo = this.qtdElements;
		// if (this.tipoOrdenacao == TypeSorted.NONE)
		// throw new SequencialException(
		// "Para a busca binária funcionar a lista tem que está ordenada!");

		while (true) {
			int meio = (topo + base) / 2;
			T e = this.get(meio);

			if (e.equals(element)) {
				return meio;
			}

			if (topo == base) {
				return -1;
			}

			if (e.toString().compareTo(element.toString()) < 0)
				base = meio + 1;
			if (e.toString().compareTo(element.toString()) > 0)
				topo = meio - 1;
		}

	}

	@Override
	public boolean add(T element) throws SequencialException {
		if (element == null)
			return false;

		if (this.persistentClass == null
				|| this.persistentClass == Object.class)
			this.persistentClass = element.getClass();

		this.isFull();
		this.elementData[this.qtdElements] = element;
		this.qtdElements += 1;
		return true;
	}
	
	@Override
	public boolean remove(T element) throws SequencialException {
		if (element == null)
			throw new SequencialException("Elemento nulo!");

		int pos = this.find(element);
		this.qtdElements -= 1;
		this.reorganize(pos);
		return true;
	}

	@Override
	public int size() {
		return this.elementData.length;
	}

	@Override
	public boolean isEmpty() throws SequencialException {
		if (this.qtdElements <= 0)
			throw new SequencialException(
					"Lista Vazia: não contém nenhum elemento na lista");

		return false;
	}

	@Override
	public boolean isFull() throws SequencialException {
		if (this.qtdElements == this.size())
			throw new SequencialException(
					"[ListOverFlow] Lista Cheia: o limite de elementos na lista já foi alcançado");

		return false;
	}

	@Override
	public void sort(TypeSorted ts, WaySorted ws) {
		this.tipoOrdenacao = ts;
		this.ordem = ws;
		this.elementData = super.sort(elementData, this.tipoOrdenacao,
				this.ordem);
	}

	@Override
	public String toString() {
		String result = "";
		String tipo = this.getPersistentClass().getSimpleName();

		for (int i = 0; i < this.qtdElements; i++) {
			result += this.elementData[i];
			if (!(this.qtdElements - i == 1)) {
				result += ", ";
			}

		}

		return "Lista Linear Sequencial<" + tipo + ">" 
				+ " | " + tipoOrdenacao + " - " + ordem 
				+ "\n[" + result + "]\n";
	}

	/************************ Métodos da classe ******************************/

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
	 * Método que reorganiza o vetor realocando o último elemento para a posição
	 * passada por parametro;
	 * 
	 * @param pos
	 *            Posição passada como referencia para a realocação;
	 * 
	 * @author matheuscastro;
	 */
	protected void reorganizeLastElement(int pos) {
		this.elementData[pos] = this.elementData[this.qtdElements];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected Class<?> getPersistentClass() {
		return this.persistentClass;
	}
}
