package br.univille.estd.tree;

public class Main {

  public static void main(String[] args){

    //inicializa uma arvore de diretórios
    Tree<Diretorio> tree = new Tree<>();
    //cria um diretório C
    Diretorio c = new Diretorio("c");
    //seta o diretório C como root
    Position<Diretorio> root = tree.addRoot(c);

    //cria novos diretórios
    Diretorio downloads = new Diretorio("downloads");
    Diretorio windows = new Diretorio("windows");
    Diretorio documentos = new Diretorio("documentos");
    Diretorio videos = new Diretorio("videos");
    Diretorio fotos = new Diretorio("fotos");

    //cria arquivos nos diretorios
    Arquivo video1 = new Arquivo("video1.mp4",1000000000, videos);
    Arquivo explorer = new Arquivo("explorer.exe", 30000, windows);
    Arquivo foto1 = new Arquivo("foto1.png", 231000, fotos);
    Arquivo foto2 = new Arquivo("foto2.jpg", 341000, fotos);

    //adiciona os diretorios aos seus respectivos parents
    Position<Diretorio> filhoDownloads = tree.addChild(tree.root(),downloads);
    Position<Diretorio> filhoWindows = tree.addChild(tree.root(), windows);
    Position<Diretorio> filhoDocumentos = tree.addChild(tree.root(), documentos);
    Position<Diretorio> filhoVideos = tree.addChild(filhoDocumentos, videos);
    Position<Diretorio> filhoFotos = tree.addChild(filhoDocumentos, fotos);

    int tamanho = TreeService.tamanho(tree, filhoFotos);
    System.out.println("Tamanho do diretório fotos: " + TreeService.tamanho(tree, filhoFotos) +"Kbs");
    System.out.println("Tamanho do diretório videos: " + TreeService.tamanho(tree, filhoVideos) +"Kbs");
    System.out.println("Tamanho do diretório downloads: " + TreeService.tamanho(tree, filhoDownloads) +"Kbs");
    System.out.println("Tamanho do diretório documentos: " + TreeService.tamanho(tree, filhoDocumentos) +"Kbs");
    System.out.println("Tamanho do diretório windows: " + TreeService.tamanho(tree, filhoWindows) +"Kbs");
    System.out.println("Tamanho do diretório c: " + TreeService.tamanho(tree, root) +"Kbs");
  }

}