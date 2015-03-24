package br.com.estruturaDados.model.exception;

public class QueueException extends RuntimeException {

	private static final long serialVersionUID = 6937335757080224499L;

	public QueueException(String msg) {
		super("\n\t[QueueException]: " + msg);
	}

	
}
