package br.com.estruturaDados.model.manager;

import br.com.estruturaDados.model.exception.QueueException;

public class Queue<T> {

	private int begin;
	private int end;
	private Object[] queue;
	
	public Queue(int capacidade){
		queue = new Object[capacidade];
		begin=end=-1;
	}

	public void add(T element){
		if(!isFull()){
			this.updateEnd();
			if(!isEmpty()){
				this.updateBegin();
				queue[end]=element;
			}else{
				queue[end]=element;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T remove(){
		T element=null;
		if(!isEmpty()){
			this.updateBegin();
			element = (T) this.queue[begin];
			if(begin == end)
				this.updateEnd();
		}
		return element;
	}
	
	public boolean isEmpty(){
		if(begin == -1 && end == -1)
			throw new QueueException("Queue Underflow!");
		
		return false;
	}
	
	public boolean isFull(){
		if(begin == ((end+1) % size()))
			throw new QueueException("Queue Overflow!");
		
		return false;
	}
	
	public int size(){
		return this.queue.length;
	}
	
	public String toString(){
		String result="";
		return "Queue: [" + result + "]";
	}
	
	protected void updateBegin(){
		this.begin = ((this.begin+1) % this.size());
	}
	
	protected void updateEnd(){
		this.end = ((this.end+1) % this.size());
	}
	
}
