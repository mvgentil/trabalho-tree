package br.univille.estd.tree;

import java.util.Iterator;

public class TreeService {

    public static int tamanho(Tree<Diretorio> estrutura, Position<Diretorio> diretorio){
        int tamanho = diretorio.getElement().getTamanho();
        Iterator<Position<Diretorio>> iterator = estrutura.children(diretorio);
        while (iterator.hasNext()){
            Position<Diretorio> child = iterator.next();
            tamanho += tamanho(estrutura, child);
        }
        return tamanho;
    }
}
