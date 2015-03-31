package br.com.estruturaDados.model.manager;

import br.com.estruturaDados.model.exception.StackExcpetion;
import br.com.estruturaDados.model.util.Compare;

public class Stack<T> {

	private int topo = -1;
	private Object[] lista;

	public Stack(int capacidade) {
		lista = new Object[capacidade];
	}

	public void push(T element) {
		if (!isFull())
			lista[++topo] = element;

	}

	@SuppressWarnings("unchecked")
	public T pop() {
		Object element = null;
		if (!isEmpty()) {
			element = lista[topo];
			topo--;
			return (T) element;
		}
		return (T) element;
	}

	public boolean isEmpty() {
		if (topo == -1)
			throw new StackExcpetion("Stack Underflow!");

		return false;
	}

	public boolean isFull() {
		if (topo == (size() - 1))
			throw new StackExcpetion("Stack Overflow!");

		return false;
	}

	public int size() {
		return this.lista.length;
	}

	public String toString() {
		String result = "\n";
		if (!isEmpty()) {
			Object[] aux;
			int tamanho = topo + 1;
			aux = new Object[tamanho];
			for (int i = 0; i < tamanho; i++) {
				result += lista[topo];
				if (!(topo % 1 == 1)) {
					result += "\n";
				}
				aux[i] = lista[topo--];
			}
			for (int i = tamanho - 1; i > -1; i--) {
				lista[++topo] = aux[i];
			}
		}
		return "\nStack\n" + "_______________" + result + "_______________";
	}

	public int find(T element) {
		int result = -1;
		int tamanho = topo + 1;
		Object[] aux;
		aux = new Object[tamanho];

		for (int i = 0; i < tamanho; i++) {
			if (Compare.compare(lista[topo], element) == 0)
				result = topo;
			aux[i] = lista[topo--];
		}

		for (int i = tamanho - 1; i > -1; i--) {
			lista[++topo] = aux[i];
		}

		if (result > -1)
			return result;
		throw new StackExcpetion("Elemento não encontrado");

	}

}
