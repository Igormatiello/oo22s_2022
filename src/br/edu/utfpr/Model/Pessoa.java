package br.edu.utfpr;

public class Pessoa {
    private String nome;
    private int cod_pessoa;

    public Pessoa(String nome, int cod_pessoa){
        this.cod_pessoa=cod_pessoa;
        this.nome=nome;

    }


    public Pessoa(){


    }


    public String getNome() {
        return nome;
    }

    public int getCod_pessoa() {
        return cod_pessoa;
    }
}
