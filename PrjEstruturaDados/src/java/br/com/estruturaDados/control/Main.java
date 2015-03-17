package br.com.estruturaDados.control;

import br.com.estruturaDados.model.Sequencial;
import br.com.estruturaDados.model.Sorted.TypeSorted;
import br.com.estruturaDados.model.Sorted.WaySorted;
import br.com.estruturaDados.model.interfaces.Linear;


public class Main{
	
	public static void main(String[] args) {
//		Linear<String> lista = new Sequencial<String>(15); 
//		
//		lista.addElement("Bruna");
//		lista.addElement("Carlos");
//		lista.addElement("Amanda");
//		lista.addElement("Fernando");
//		lista.addElement("Jose");
//		lista.addElement("Alfredo");
//		lista.addElement("Pedro");
//		lista.addElement("Luis");
//		lista.addElement("Nathan");
//		lista.addElement("Marcos");
//		lista.addElement("Isabel");
//		lista.addElement("Gabriel");
//		System.out.println(lista);
//		
//		lista.sort(Sorted.ASC);
		
		
		Linear<Integer> inteiros = new Sequencial<Integer>(9);
		
		inteiros.addElement(5);
		inteiros.addElement(3);
		inteiros.addElement(9);
		inteiros.addElement(7);
		inteiros.addElement(10);
		inteiros.addElement(2);
		
		System.out.println(inteiros);
		
		inteiros.sort(TypeSorted.INSERTION, WaySorted.DESC);
		
		inteiros.addElement(8);
		inteiros.addElement(6);
		
		System.out.println(inteiros);
		
		
		
		
	}

}
