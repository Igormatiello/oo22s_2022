package br.edu.utfpr;

import br.edu.utfpr.Model.Livro;

public class LivroService {

    public Livro encontraLivroPeloCodigo(int cod){

        Livro livro=  BancoDeDados.livros.stream().filter(livro1 -> livro1.getCod_livro()==cod)
                .findFirst()
                .get();
        return livro;



    }




}
