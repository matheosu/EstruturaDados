package br.com.estruturaDados.model.exception;

public class CompareException extends RuntimeException{
	private static final long serialVersionUID = -5127306689776392809L;

	public CompareException(String msg){
		super("\n[Exceção na comparação]:\n" + msg);
	}
}
