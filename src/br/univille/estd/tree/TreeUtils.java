package br.univille.estd.tree;

import java.util.Iterator;

public class TreeUtils {
	
	public static <E> int depth(Tree<E> T, Position<E> v) {
		if(T.isRoot(v)) return 0;
		return  1 + depth(T,T.parent(v));
	}
	
	public static <E> int height(Tree<E> T, Position<E> v) {
		if(T.isExternal(v)) return 0;
		int h = 0;
		Iterator<Position<E>> iterator = T.children(v);
		while(iterator.hasNext()){
			Position<E> child = iterator.next();
			h = Integer.max(h,height(T,child));
		}
		return 1 + h;
	}
	
	public static <E> String toStringPreOrder(Tree<E> T, Position<E> v) {
		String s = v.getElement().toString();
		Iterator<Position<E>> iterator = T.children(v);
		while(iterator.hasNext()) {
			Position<E> child = iterator.next();
			s = s+", "+toStringPreOrder(T,child);
		}
		return s;
	}
	
	public static <E> String toStringPostOrder(Tree<E> T, Position<E> v) {
		String s = "";
		Iterator<Position<E>> iterator = T.children(v);
		while(iterator.hasNext()) {
			Position<E> child = iterator.next();
			String temp = toStringPostOrder(T,child);
			if(s.isEmpty()){
				s = temp;
			}else{
				s = s+", "+temp;
			}
		}
		if(s.isEmpty()){
			s = v.getElement().toString();
		}else{
			s = s+", "+v.getElement().toString();
		}
		return s;
	}

}
