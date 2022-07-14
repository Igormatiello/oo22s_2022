package br.edu.utfpr.Service;

import br.edu.utfpr.BancoDeDados;
import br.edu.utfpr.Model.Livro;

import java.io.Serializable;

public class LivroService implements CrudService<Livro, Integer> {

    @Override
    public Livro save(Livro entity) {
        BancoDeDados.livros.add(entity);
        return entity;
    }

    @Override
    public Livro getById(Integer id) {
        Livro livro= BancoDeDados.livros.stream()
                .filter(l->l.getCod_livro()==id)
                .findFirst()
                .get();

        return livro;
    }

    @Override
    public void delete(Livro entity) {

        BancoDeDados.livros.remove(entity);
    }

    public Livro encontraLivroPeloCodigo(int cod){

        Livro livro=  BancoDeDados.livros.stream().filter(livro1 -> livro1.getCod_livro()==cod)
                .findFirst()
                .get();
        return livro;



    }




}
