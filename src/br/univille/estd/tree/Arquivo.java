package br.univille.estd.tree;

public class Arquivo {

    private String nome;
    private int tamanho;
    private Diretorio parent;

    public Diretorio getParent() {
        return parent;
    }

    public void setParent(Diretorio parent) {
        this.parent = parent;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Arquivo(String nome, int tamanho, Diretorio parent) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.parent = parent;
        parent.addArquivo(this);
    }
}
