package Model;

public abstract class Produto {

    private int id;
    private  String titulo;
    private  String autor;

    public Produto (int codigo, String titulo, String autor) {
        this.id = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public void imprimir(){
        System.out.println ("*************************************");
        System.out.println ("Título: "+getTitulo ());
        System.out.println ("Autor: "+getAutor ());
        System.out.println ("Código: " + getId ());
    }

    //Getters e Setters
    public int getId () {return id;}
    public void setId (int id) {this.id = id;}
    public String getTitulo () {return titulo;}
    public void setTitulo (String titulo) {this.titulo = titulo;}
    public String getAutor () {return autor;}
    public void setAutor (String autor) {this.autor = autor;}
}
