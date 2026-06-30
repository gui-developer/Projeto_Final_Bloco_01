package Model;

public class Livro extends Produto{
    private int anoPublicado, numeroPaginas;

    public Livro (int codigo, String titulo, String autor,int anoPublicado, int numeroPaginas) {
        super (codigo, titulo, autor);
        this.anoPublicado = anoPublicado;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void imprimir () {
        super.imprimir ();
        System.out.println ("Ano de publicação: "+getAnoPublicado ());
        System.out.println ("Número de páginas: "+getNumeroPaginas ());
    }

    public int getAnoPublicado () {return anoPublicado;}

    public void setAnoPublicado (int anoPublicado) {this.anoPublicado = anoPublicado;}

    public int getNumeroPaginas () {return numeroPaginas;}

    public void setNumeroPaginas (int numeroPaginas) {this.numeroPaginas = numeroPaginas;}
}
