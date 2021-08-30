package br.univille.estd.tree;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	
	private E[] array;
	private int cursorPosition;
	
	public ArrayIterator(E[] lista) {
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}

}
