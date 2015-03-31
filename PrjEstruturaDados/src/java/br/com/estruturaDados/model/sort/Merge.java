package br.com.estruturaDados.model.sort;

import br.com.estruturaDados.model.enums.WaySorted;
import br.com.estruturaDados.model.util.Compare;

/**
 * Classe Merge dentro de Sorted para realizar a busca separada por métodos
 * 
 * @author matheuscastro
 */
public abstract class Merge {
	
	/**
	 * Método merge que realiza a junção do vetor com o auxilio de um outro
	 * vetor;
	 * 
	 * @param elements
	 *            é o vetor que quer realizar a ordenação do tipo Merge
	 *            (Junção);
	 * @param inicio
	 *            é de onde começa o ínico do vetor;
	 * @param fim
	 *            é o final do vetor, normalmente passamos a quantidade de
	 *            elementos de um vetor -1;
	 * @return retorna um Array de Objects já ordenado;
	 */
	public static Object[] merge(Object[] elements, int inicio, int fim, WaySorted ws) {
		int meio;
		if (inicio < fim) {
			meio = (inicio + fim) / 2;
			merge(elements, inicio, meio, ws);
			merge(elements, meio + 1, fim, ws);
			return intercala(elements, inicio, fim, meio, ws);
		}
		return null;

	}
	

	private static Object[] intercala(Object[] elements, int inicio,
			int fim, int meio, WaySorted ws) {
		int posLivre, inicio_1, inicio_2, i;
		Object[] aux = new Object[elements.length];
		inicio_1 = inicio;
		inicio_2 = meio + 1;
		posLivre = inicio;

		while (inicio_1 <= meio && inicio_2 <= fim) {
			
			if(ws == WaySorted.ASC){
				if (Compare.compare(elements[inicio_1], elements[inicio_2]) < 1) {
					aux[posLivre] = elements[inicio_1];
					inicio_1 = inicio_1 + 1;
				} else {
					aux[posLivre] = elements[inicio_2];
					inicio_2 = inicio_2 + 1;
				}
			}else if(ws == WaySorted.DESC){
				if (Compare.compare(elements[inicio_2], elements[inicio_1]) < 1) {
					aux[posLivre] = elements[inicio_1];
					inicio_1 = inicio_1 + 1;
				} else {
					aux[posLivre] = elements[inicio_2];
					inicio_2 = inicio_2 + 1;
				}
			}
			posLivre += 1;
		}

		for (i = inicio_1; i <= meio; i++) {
			aux[posLivre] = elements[i];
			posLivre += 1;
		}

		for (i = inicio_2; i <= fim; i++) {
			aux[posLivre] = elements[i];
			posLivre += 1;
		}

		for (i = inicio; i <= fim; i++) {
			elements[i] = aux[i];
		}

		return elements;
	}
}