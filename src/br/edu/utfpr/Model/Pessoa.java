package br.edu.utfpr.Model;

public class Pessoa extends Entity{
    private String nome;

    public Pessoa( String nome,int cod_pessoa){
        super.id=cod_pessoa;
        this.nome=nome;

    }


public int getCodPessoa(){return super.id;}

    public String getNome() {
        return nome;
    }

}
