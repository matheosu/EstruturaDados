package br.com.estruturaDados.model.exception;

public class LinearSequencialException extends LinearException{

	private static final long serialVersionUID = -1423351104267564542L;
	
	public LinearSequencialException(String msg) {
		super("Sequencial]\n\t"+msg);
	}
}
