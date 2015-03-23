package br.com.estruturaDados.control;

import br.com.estruturaDados.model.Sequencial;
import br.com.estruturaDados.model.enums.TypeSorted;
import br.com.estruturaDados.model.enums.WaySorted;
import br.com.estruturaDados.model.interfaces.Linear;


public class Main{
	
	public static void main(String[] args) {
		Linear<String> lista = new Sequencial<String>(15); 
		
		lista.add("Bruna");
		lista.add("Carlos");
		lista.add("Amanda");
		lista.add("Fernando");
		lista.add("Jose");
		lista.add("Alfredo");
		lista.add("Pedro");
		lista.add("Luis");
		lista.add("Nathan");
		lista.add("Marcos");
		lista.add("Isabel");
		lista.add("Gabriel");
		System.out.println(lista);
		
		lista.sort(TypeSorted.SELECTION,WaySorted.ASC);
		
		System.out.println(lista);
		
//		Linear<Integer> inteiros = new Sequencial<Integer>(9);
//		
//		inteiros.add(5);
//		inteiros.add(3);
//		inteiros.add(9);
//		inteiros.add(7);
//		inteiros.add(10);
//		inteiros.add(2);
//		
//		inteiros.sort(TypeSorted.BUBBLE, WaySorted.ASC);
//		
//		System.out.println(inteiros);
		
		
		
	}

}
