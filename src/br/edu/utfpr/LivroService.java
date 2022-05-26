package br.edu.utfpr;

public class LivroService {

    public Livro encontraLivroPeloCodigo(int cod){

        Livro livro=  BancoDeDados.livros.stream().filter(livro1 -> livro1.getCod_livro()==cod)
                .findFirst()
                .get();
        return livro;



    }




}
