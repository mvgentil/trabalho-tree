package br.univille.estd.tree;

import java.util.ArrayList;

public class Diretorio {

  private int tamanho;
  private String nome;
  private ArrayList<Arquivo> arquivos;

  public ArrayList getArquivos() {
    return arquivos;
  }

  public void setArquivos(ArrayList arquivos) {
    this.arquivos = arquivos;
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Diretorio(String nome){
    this.tamanho = 1;
    this.nome = nome;
    this.arquivos = new ArrayList<Arquivo>();
  }

  public void addArquivo(Arquivo arquivo){
    this.arquivos.add(arquivo);
    this.tamanho += arquivo.getTamanho();
  }

  public void removeArquivo(Arquivo arquivo){
    this.arquivos.remove(arquivo);
    this.tamanho -= arquivo.getTamanho();
  }


}