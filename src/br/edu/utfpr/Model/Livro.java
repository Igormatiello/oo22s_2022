package br.edu.utfpr.Model;

public class Livro extends Entity{

    private String titulo;
    private String autor;
    private int numeroPaginas;
    private int anoPublicacao;
    private boolean estaAlugado;

    public Livro(int cod_livro,String titulo, String autor, int numeroPaginas, int anoPublicacao, boolean estaAlugado) {
        super.id=cod_livro;
        this.estaAlugado=estaAlugado;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.anoPublicacao = anoPublicacao;
    }



    public int getCod_livro() {
        return super.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isEstaAlugado() {
        return estaAlugado;
    }


    public void setEstaAlugado(boolean estaAlugado) {
        this.estaAlugado = estaAlugado;
    }
}
