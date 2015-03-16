package br.com.estruturaDados.model;

/**
 * Enum para organizar e padronizar a ordenação que poderá ser reutilizada em
 * outras possíveis classes
 * 
 * @author matheuscastro
 */
public enum Sorted {
	ASC, DESC, NONE
}

// TODO: Criar uma classe abstrata Sorted com o intuito de generalizar a
// ordenação para que possa reutilzar os métodos em qualquer tipo de Lista
// Linear, seja ela Sequencial, Simplesmente Encadeada ou Duplamente Encadeada.
// TODO: Enum statico chamado TypeSorted dentro de Sorted
