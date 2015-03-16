package br.com.estruturaDados.model;

import java.io.Serializable;
import java.lang.reflect.Array;

import br.com.estruturaDados.model.exception.LinearSequencialException;
import br.com.estruturaDados.model.interfaces.Linear;
import br.com.estruturaDados.util.Compare;

public class Sequencial<T> implements Linear<T>, Serializable {
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
	 * Pega a classe passada por reflexão
	 */
	protected Class<?> persistentClass;

	/**
	 * Vetor da Lista
	 */
	private T[] elementData;

	/**
	 * Vetor de copia da Lista
	 */
	private T[] copyElementData = null;

	/**
	 * Atributo que armazena qual é a ordenação da Lista
	 */
	private Sorted ordenacao = Sorted.NONE;

	@SuppressWarnings("unchecked")
	public Sequencial(int tamanhoInicial) throws LinearSequencialException {
		if (reflection()) {
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
	public int findElement(T element) {
		this.isEmpty();
		for (int i = 0; i < this.qtdElements; i++) {
			if (this.elementData[i].equals(element)){
				return i;
			}
		}
		throw new LinearSequencialException(
				"Elemento não encontrado: o elemento passado não foi encontrado na lista");
	}

	/**
	 * Método que retorna o elemento através da posição passada por parametro;
	 * 
	 * @param pos
	 *            é a posição do elemento dentro do vetor;
	 * @return T é o elemento a ser retornado;
	 * @author matheuscastro
	 */
	protected T get(int pos) {
		if (pos >= 0)
			return this.elementData[pos];

		throw new LinearSequencialException("Posição menor que zero");
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
		if (this.ordenacao == Sorted.NONE)
			throw new LinearSequencialException(
					"Para a busca binária funcionar a lista tem que está ordenada!");

		while (true) {
			int meio = (topo + base) / 2;
			T e = this.get(meio);

			if (e.equals(element)){
				return meio;
			}

			if (topo == base){
				return -1;
			}

			if (e.toString().compareTo(element.toString()) < 0)
				base = meio + 1;
			if (e.toString().compareTo(element.toString()) > 0)
				topo = meio - 1;
		}

	}

	@Override
	public boolean addElement(T element) throws LinearSequencialException {
		if (element == null)
			return false;

		if (this.persistentClass == null
				|| this.persistentClass == Object.class)
			this.persistentClass = element.getClass();

		this.isFull();
		this.elementData[this.qtdElements] = element;

		if (this.copyElementData != null)
			this.copyElementData[this.qtdElements] = element;

		this.qtdElements += 1;
		this.organize();
		return true;
	}

	@Override
	public boolean removeElement(T element) throws LinearSequencialException {
		if (element == null)
			throw new LinearSequencialException("Elemento nulo!");

		int pos = this.findElement(element);
		this.qtdElements -= 1;
		this.reorganize(pos);
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

	@Override
	public void sort(Sorted s) {
		this.ordenacao = s;

		if (this.copyElementData == null)
			this.copyListToCopy(elementData);

		switch (this.ordenacao) {
		case ASC:
			for (int i = 0; i < this.qtdElements; i++) {
				for (int x = 0; x < this.qtdElements; x++) {
					if (Compare.compare(this.elementData[i], this.elementData[x]) < 0) {
						T aux = this.elementData[i];
						this.elementData[i] = this.elementData[x];
						this.elementData[x] = aux;
					}
				}
			}
			break;

		case DESC:
			for (int i = 0; i < this.qtdElements; i++) {
				for (int x = 0; x < this.qtdElements; x++) {
					if (Compare.compare(this.elementData[i], this.elementData[x]) > 0) {
						T aux = this.elementData[x];
						this.elementData[x] = this.elementData[i];
						this.elementData[i] = aux;
					}
				}
			}
			break;

		default:
			this.copyListToData(this.copyElementData);
			this.copyElementData = null;
		}

	}

	@Override
	public Sorted getSort() {
		return this.ordenacao;
	}

	@Override
	public String toString() {
		String result = "";
		String ordem = "";
		String tipo = "";

		for (int i = 0; i < this.qtdElements; i++) {
			result += this.elementData[i];
			if (!(this.qtdElements - i == 1)) {
				result += ", ";
			}

		}

		if (this.getSort() == Sorted.DESC)
			ordem = "Ordenação Decrescente";
		else if (this.getSort() == Sorted.ASC)
			ordem = "Ordenação Crescente";
		else
			ordem = "Sem ordenação";

		tipo = this.getPersistentClass().getSimpleName();

		return "Lista Linear Sequencial<" + tipo + "> (" + ordem + "):\n["
				+ result + "]\n";
	}

	/************************ Métodos da classe ******************************/

	protected void organize() {
		if (this.ordenacao == Sorted.ASC)
			this.sort(Sorted.ASC);
		else if (this.ordenacao == Sorted.DESC)
			this.sort(Sorted.DESC);
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

	protected boolean reflection() {
		this.persistentClass = (Class<?>) this.getClass()
				.getGenericSuperclass();
		return true;
	}

	protected Class<?> getPersistentClass() {
		return this.persistentClass;
	}

	/**
	 * Método que faz cópia de cada elemento da lista original para a lista de
	 * copia
	 * 
	 * @params original seria a lista que contém os elementos
	 * @author matheuscastro
	 */
	@SuppressWarnings("unchecked")
	protected void copyListToCopy(T[] original) {
		if (this.copyElementData == null) {
			this.copyElementData = (T[]) Array.newInstance(
					this.getPersistentClass(), original.length);
		}

		for (int i = 0; i < original.length; i++) {
			if (original[i] != null) {
				this.copyElementData[i] = original[i];
			}
		}
	}

	/**
	 * Método que faz cópia de cada elemento da lista original para a lista de
	 * elementsData
	 * 
	 * @params original seria a lista que contém os elementos
	 * @author matheuscastro
	 */
	@SuppressWarnings("unchecked")
	protected void copyListToData(T[] original) {
		if (this.elementData == null) {
			this.elementData = (T[]) Array.newInstance(
					this.getPersistentClass(), original.length);
		}

		for (int i = 0; i < original.length; i++) {
			if (original[i] != null) {
				this.elementData[i] = original[i];
			}
		}
	}

}
