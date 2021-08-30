package br.univille.estd.tree;

import java.util.Iterator;

/*
 *  árvore onde os nodos podem ter uma quantidade arbitrária de filhos.
 * */
public class Tree<E> {
	
	private int size;
	private Position<E> root;
	
	/** Retorna a raiz da árvore. */
	public Position<E> root() throws EmptyTreeException{
		return root;
	}
	
	/** Retorna o pai de um dado nodo. */
	public Position<E> parent(Position<E> position) throws  BoundaryViolationException{
		if(isRoot(position)) throw  new BoundaryViolationException("Raiz não possui pai.");
		return position.getParent();
	}
	
	/** Retorna uma coleção iterável dos filhos de um dado nodo. */
	public Iterator<Position<E>> children(Position<E> position)  throws InvalidPositionException {
		checkIsPositionValid(position);
		return position.getChildren();
	}
	
	/** Retorna se um dado nodo é interno. */
	public boolean isInternal(Position<E> position) throws InvalidPositionException  {
		return !isExternal(position);
	}
	
	/** Retorna se um dado nodo é externo. */
	public boolean isExternal(Position<E> position)  throws InvalidPositionException {
		checkIsPositionValid(position);
		return position.size() == 0;
	}
	
	/** Retorna se um dado nodo é a raiz da árvore. */
	public boolean isRoot(Position<E> position) throws InvalidPositionException   {
		checkIsPositionValid(position);
		return root == position;
	}

	/** Retorna a quantidade de nodos da árvore. */
	public int size() {
		return size;
	}
	
	/** Retorna se a árvore está vazia. */
	public boolean isEmpty() {
		return size() == 0;
	}

	/** Retorna uma coleção iterável dos nodos. */
	public Iterator<Position<E>> positions(){
		return null;
	}
	
	/** Substitui o elemento armazenado em um dado nodo. */
	public E replace(Position<E> position, E element) throws InvalidPositionException {
		checkIsPositionValid(position);
		E old = position.getElement();
		position.setElement(element);
		return old;
	}
	
	/**
	 * Adiciona a raiz em uma árvore vazia
	 * @param element
	 */
	public Position<E> addRoot(E element) throws NonEmptyTreeException {
		if(!isEmpty()){ throw  new NonEmptyTreeException("Árvore não está vazia.");}
		root = new Position<>(element);
		size++;
		return root;
	}
	
	/** Adicione um filho no nodo */
	public Position<E> addChild(Position<E> parent, E element) throws InvalidPositionException{
		checkIsPositionValid(parent);
		size++;
		return parent.addChild(element);
	}

	private void checkIsPositionValid(Position<E> position) throws InvalidPositionException {
		if(position == null) throw new InvalidPositionException("A posição é inválida.");
	}
	
}
