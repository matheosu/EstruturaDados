package br.com.estruturaDados.model;

import java.lang.reflect.Array;

import br.com.estruturaDados.util.Compare;

public class Sorted<T> {

	/**
	 * Vetor de copia da Lista
	 * 
	 * @author matheuscastro
	 */
	protected T[] copyElementData = null;

	private T[] elementData = null;

	private Class<?> tipo = null;

	/**
	 * "Pior nome que ja dei em um enum" Enum para ordenar os elementos da lista
	 * em ordem: ASC = Crescente; DESC = Decrescente; NONE = Nenhum;
	 * 
	 * @author matheuscastro
	 */
	public enum WaySorted {
		ASC, DESC, NONE
	}

	/**
	 * Enum para defenir o tipo de ordenação a ser implementado na lista: HEAP =
	 * INSERTION = Ordenação por inserção; BUBBLE = SELECTION = Ordenação por
	 * seleção; MERGE = Ordenação por intercalação; QUICK = Ordenação rápida;
	 * NONE = Nenhum;
	 * 
	 * @author matheuscastro
	 * 
	 */
	public enum TypeSorted {
		HEAP, INSERTION, BUBBLE, SELECTION, MERGE, QUICK, NONE
	}

	/**
	 * Método que identifica qual tipo de ordenação e chama o método da
	 * ordenação identificada passando de qual forma será ordenado;
	 * 
	 * @param ts
	 *            TypeSorted: Tipo de Ordenação;
	 * @param ws
	 *            WaySorted: Estilo de Ordenação;
	 * 
	 * @author matheuscastro
	 */
	public T[] sort(T[] elementData, TypeSorted ts, WaySorted ws) {
		if (elementData != null)
			this.elementData = elementData;

		switch (ts) {
		case HEAP:
			this.sortHeap(ws);
			break;

		case INSERTION:
			this.sortInsertion(ws);
			break;

		case BUBBLE:
			this.sortBubble(ws);
			break;

		case SELECTION:
			this.sortSelection(ws);
			break;

		case MERGE:
			this.sortMerge(ws);
			break;

		case QUICK:
			this.sortQuick(ws);
			break;

		default:
			break;
		}

		return this.elementData;
	}

	protected void sortHeap(WaySorted ws) {
		switch (ws) {
		case ASC:
			break;
		case DESC:
			break;
		case NONE:
			break;
		default:
		}
	}

	protected void sortInsertion(WaySorted ws) {
		switch (ws) {
		case ASC:
			for (int i = 1; i <= this.elementData.length - 1; i++) {
				T aux = this.elementData[i];
				int j = i - 1;

				while (j >= 0
						&& (Compare.compare(this.elementData[j], aux) > 0)) {
					this.elementData[j + 1] = this.elementData[j];
					j -= 1;
				}
				this.elementData[j + 1] = aux;
			}
			break;
		case DESC:
			for (int i = 1; i <= this.elementData.length - 1; i++) {
				T aux = this.elementData[i];
				int j = i - 1;

				while (j >= 0
						&& (Compare.compare(this.elementData[j], aux) < 0)) {
					this.elementData[j + 1] = this.elementData[j];
					j -= 1;
				}
				this.elementData[j + 1] = aux;
			}
			break;
		case NONE:
			break;
		default:
		}
	}

	protected void sortBubble(WaySorted ws) {
		switch (ws) {
		case ASC:
			for (int i = 0; i < this.elementData.length; i++) {
				for (int x = 0; x < this.elementData.length; x++) {
					if (Compare.compare(this.elementData[i],
							this.elementData[x]) < 0) {
						T aux = this.elementData[i];
						this.elementData[i] = this.elementData[x];
						this.elementData[x] = aux;
					}
				}
			}
			break;
		case DESC:
			for (int i = 0; i < this.elementData.length; i++) {
				for (int x = 0; x < this.elementData.length; x++) {
					if (Compare.compare(this.elementData[i],
							this.elementData[x]) > 0) {
						T aux = this.elementData[i];
						this.elementData[i] = this.elementData[x];
						this.elementData[x] = aux;
					}
				}
			}
			break;
		case NONE:
			break;
		default:
		}
	}

	protected void sortSelection(WaySorted ws) {
		switch (ws) {
		case ASC:
			break;
		case DESC:
			break;
		case NONE:
			break;
		default:
		}
	}

	protected void sortMerge(WaySorted ws) {
		switch (ws) {
		case ASC:
			break;
		case DESC:
			break;
		case NONE:
			break;
		default:
		}
	}

	protected void sortQuick(WaySorted ws) {
		switch (ws) {
		case ASC:
			break;
		case DESC:
			break;
		case NONE:
			break;
		default:
		}
	}

	/**
	 * Método que faz cópia de cada elemento da lista original para a lista de
	 * copia
	 * 
	 * @params original seria a lista que contém os elementos
	 * @author matheuscastro
	 */
	@SuppressWarnings("unchecked")
	protected void copyListToCopy(T[] original, Class<?> tipo) {
		this.tipo = tipo;
		if (this.copyElementData == null) {
			this.copyElementData = (T[]) Array.newInstance(this.tipo,
					original.length);
		}

		for (int i = 0; i < original.length; i++) {
			if (original[i] != null) {
				this.copyElementData[i] = original[i];
			}
		}
	}

}
