package br.com.estruturaDados.model.manager;

import br.com.estruturaDados.model.exception.StackExcpetion;

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
		String result = "";
		if (!isEmpty()) {
			//TODO implementar
			//desempilha em ordem contrária
			//empilha de volta
			//se vira
			return "Stack [" + result + "]";
		}
		
		return result;
	}
	
	//TODO: Implementar um método de busca;
}
