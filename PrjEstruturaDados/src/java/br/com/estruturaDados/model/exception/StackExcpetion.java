package br.com.estruturaDados.model.exception;

public class StackExcpetion extends RuntimeException {

	private static final long serialVersionUID = 8102018804616821245L;

	public StackExcpetion(String msg) {
		super("\n\t[StackException]: " + msg);
	}

	
}
