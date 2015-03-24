package br.com.estruturaDados.control;

import br.com.estruturaDados.model.manager.Queue;



public class Main{
	
	public static void main(String[] args) {
//		Linear<String> lista = new Sequencial<String>(15); 
//		
//		lista.add("Bruna");
//		lista.add("Carlos");
//		lista.add("Amanda");
//		lista.add("Fernando");
//		lista.add("Jose");
//		lista.add("Alfredo");
//		lista.add("Pedro");
//		lista.add("Luis");
//		lista.add("Nathan");
//		lista.add("Marcos");
//		lista.add("Isabel");
//		lista.add("Gabriel");
//		System.out.println(lista);
//		
//		lista.sort(TypeSorted.SELECTION,WaySorted.ASC);
//		
//		System.out.println(lista);
//		
//		Linear<Integer> inteiros = new Sequencial<Integer>(9);
//		
//		inteiros.add(5);
//		inteiros.add(3);
//		inteiros.add(9);
//		inteiros.add(7);
//		inteiros.add(10);
//		inteiros.add(2);
//		System.out.println(inteiros);
//		
//		inteiros.sort(TypeSorted.BUBBLE, WaySorted.ASC);
//		
//		System.out.println(inteiros);
//		
//		inteiros.add(6);
//		
//		System.out.println(inteiros);
		
		
//		Stack<String> pilha = new Stack<String>(10);
//		System.out.println(pilha.size());
//		pilha.push("Teste1");
//		pilha.push("Teste2");
//		pilha.push("Teste3");
//		pilha.push("Teste4");
//		pilha.push("Teste5");
//		pilha.push("Teste6");
//		pilha.push("Teste7");
//		pilha.push("Teste8");
//		pilha.push("Teste9");
//		pilha.push("Teste10");
//		
//		System.out.println(pilha);
//		
//		System.out.println(pilha.pop());
		
		Queue<String> fila = new Queue<String>(5);
		fila.add("Teste1");
		fila.add("Teste2");
		fila.add("Teste3");
		fila.add("Teste4");
		fila.add("Teste5");
		
		System.out.println(fila);
	}

}
