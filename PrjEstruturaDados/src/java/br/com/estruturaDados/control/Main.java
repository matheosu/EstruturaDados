package br.com.estruturaDados.control;

import br.com.estruturaDados.model.Sequencial;
import br.com.estruturaDados.model.Sorted;
import br.com.estruturaDados.model.interfaces.Linear;


public class Main{

	
	public static void main(String[] args) {
		Linear<String> lista = new Sequencial<String>(15); 
		
		lista.addElement("Bruna");
		lista.addElement("Amanda");
		lista.addElement("Carlos");
		lista.addElement("Fernando");
		lista.addElement("Jose");
		lista.addElement("Alfredo");
		lista.addElement("Luis");
		lista.addElement("Nathan");
		lista.addElement("Marcos");
		lista.addElement("Gabriel");
		lista.addElement("Isabel");
		lista.addElement("Pedro");
		System.out.println(lista);
		
		lista.sort(Sorted.ASC);
		
		
		
	}

}
