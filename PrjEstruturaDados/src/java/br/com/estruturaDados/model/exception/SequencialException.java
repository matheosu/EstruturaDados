package br.com.estruturaDados.model.exception;

public class SequencialException extends LinearException{

	private static final long serialVersionUID = -1423351104267564542L;
	
	public SequencialException(String msg) {
		super("Sequencial]\n\t"+msg);
	}
}
