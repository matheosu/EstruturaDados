package br.com.estruturaDados.model.exception;

public abstract class LinearException extends RuntimeException{
	private static final long serialVersionUID = -8753962234006713868L;

	public LinearException(String msg) {
		super("\n\tExeceção [Lista Linear: " + msg);
	}
	
}
