package br.com.estruturaDados.model;

import br.com.estruturaDados.model.enums.TypeSorted;
import br.com.estruturaDados.model.enums.WaySorted;
import br.com.estruturaDados.model.interfaces.ISorted;
import br.com.estruturaDados.model.util.Compare;

public class Sorted<T> implements ISorted<T>{
	

	private T[] elementData = null;
	private int qtdElements = 0;

	public T[] sort(T[] elementData, TypeSorted ts,WaySorted ws) {
		this.count(elementData);
		
		switch (ts) {
		case HEAP:
			this.sortHeap(ws);
			break;

		case INSERTION:
			this.sortInsertion(ws);
			break;

		case BUBBLE:
			this.sortBubble(ws);
			break;

		case SELECTION:
			this.sortSelection(ws);
			break;

		case MERGE:
			this.sortMerge(ws);
			break;

		case QUICK:
			this.sortQuick(ws);
			break;

		default:
			break;
		}

		return this.elementData;
	}

	protected void sortHeap(WaySorted ws) {
		switch (ws) {
		case ASC:
			break;
		case DESC:
			break;
		default:
		}
	}

	protected void sortInsertion(WaySorted ws) {
		switch (ws) {
		case ASC:
			for (int i = 1; i <= this.qtdElements - 1; i++) {
				T aux = this.elementData[i];
				int j = i - 1;

				while (j >= 0
						&& (Compare.compare(this.elementData[j], aux) > 0)) {
					this.elementData[j + 1] = this.elementData[j];
					j -= 1;
				}
				this.elementData[j + 1] = aux;
			}
			break;
		case DESC:
			for (int i = 1; i <= this.qtdElements - 1; i++) {
				T aux = this.elementData[i];
				int j = i - 1;

				while (j >= 0
						&& (Compare.compare(this.elementData[j], aux) < 0)) {
					this.elementData[j + 1] = this.elementData[j];
					j -= 1;
				}
				this.elementData[j + 1] = aux;
			}
			break;
		default:
		}
	}

	protected void sortBubble(WaySorted ws) {
		switch (ws) {
		case ASC:
			for (int i = 0; i < this.qtdElements; i++) {
				for (int x = 0; x < this.qtdElements; x++) {
					if (Compare.compare(this.elementData[i],
							this.elementData[x]) < 0) {
						T aux = this.elementData[i];
						this.elementData[i] = this.elementData[x];
						this.elementData[x] = aux;
					}
				}
			}
			break;
		case DESC:
			for (int i = 0; i < this.qtdElements; i++) {
				for (int x = 0; x < this.qtdElements; x++) {
					if (Compare.compare(this.elementData[i],
							this.elementData[x]) > 0) {
						T aux = this.elementData[i];
						this.elementData[i] = this.elementData[x];
						this.elementData[x] = aux;
					}
				}
			}
			break;
		default:
		}
	}

	protected void sortSelection(WaySorted ws) {
		switch (ws) {
		case ASC:
			for(int i=0;i<this.qtdElements-2;i++){
				T eleito = this.elementData[i];
				T menor = this.elementData[i+1];
				int pos = i+1;
				
				for(int j=i+2;j<=this.qtdElements-1;j++){
					if(Compare.compare(this.elementData[j],menor)<0){
						menor = this.elementData[j];
						pos = j;
					}
				}
				
				if(Compare.compare(menor,eleito)<0){
					this.elementData[i] = this.elementData[pos];
					this.elementData[pos] = eleito;
				}
			}
			break;
		case DESC:
			for(int i=0;i<this.qtdElements-2;i++){
				T eleito = this.elementData[i];
				T menor = this.elementData[i+1];
				int pos = i+1;
				
				for(int j=i+2;j<=this.qtdElements-1;j++){
					if(Compare.compare(this.elementData[j],menor)>0){
						menor = this.elementData[j];
						pos = j;
					}
				}
				
				if(Compare.compare(menor,eleito)>0){
					this.elementData[i] = this.elementData[pos];
					this.elementData[pos] = eleito;
				}
			}
			break;
		default:
		}
	}

	protected void sortMerge(WaySorted ws) {
		
		switch (ws) {
		case ASC:
			
			break;
		case DESC:
			break;
		default:
		}
	
		
	}

	protected void sortQuick(WaySorted ws) {
		switch (ws) {
		case ASC:
			break;
		case DESC:
			break;
		default:
		}
	}
	
	protected void count(T[] list){
		this.elementData = list;
		for(int i=0; i<this.elementData.length;i++){
			if(list[i]!=null)
				this.qtdElements +=1;
		}
	}

//	/**
//	 * Método que faz cópia de cada elemento da lista original para a lista de
//	 * copia
//	 * 
//	 * @params original seria a lista que contém os elementos
//	 * @author matheuscastro
//	 */
//	@SuppressWarnings("unchecked")
//	protected void copyListToCopy(T[] original, Class<?> tipo) {
//		this.tipo = tipo;
//		if (this.copyElementData == null) {
//			this.copyElementData = (T[]) Array.newInstance(this.tipo,
//					original.length);
//		}
//
//		for (int i = 0; i < original.length; i++) {
//			if (original[i] != null) {
//				this.copyElementData[i] = original[i];
//			}
//		}
//	}

}
