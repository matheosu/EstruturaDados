package br.com.estruturaDados.model.interfaces;

import br.com.estruturaDados.model.enums.TypeSorted;
import br.com.estruturaDados.model.enums.WaySorted;

public interface ISorted<T> {

	/**
	 * Método que identifica qual tipo de ordenação e chama o método da
	 * ordenação identificada passando de qual forma será ordenado;
	 * 
	 * @param elementData
	 *            é o array de elementos a serem ordenados;
	 * 
	 * @param ts
	 *            TypeSorted: Tipo de Ordenação;
	 * @param ws
	 *            WaySorted: Estilo de Ordenação;
	 * 
	 * @author matheuscastro
	 */
	public abstract T[] sort(T[] elementData, TypeSorted ts, WaySorted ws);
}
