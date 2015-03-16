package br.com.estruturaDados.control;

import br.com.estruturaDados.model.Sequencial;
import br.com.estruturaDados.model.Sorted;
import br.com.estruturaDados.model.interfaces.Linear;


public class Main{
	
	public static void main(String[] args) {
		Linear<String> lista = new Sequencial<String>(15); 
		
		lista.addElement("Bruna");
		lista.addElement("Carlos");
		lista.addElement("Amanda");
		lista.addElement("Fernando");
		lista.addElement("Jose");
		lista.addElement("Alfredo");
		lista.addElement("Pedro");
		lista.addElement("Luis");
		lista.addElement("Nathan");
		lista.addElement("Marcos");
		lista.addElement("Isabel");
		lista.addElement("Gabriel");
		System.out.println(lista);
		
		lista.sort(Sorted.ASC);
		
		System.out.println(lista);
		
		lista.sort(Sorted.NONE);
		
		System.out.println(lista);
		
		
		
	}

}
