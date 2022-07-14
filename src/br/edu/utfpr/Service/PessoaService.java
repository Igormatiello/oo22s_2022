package br.edu.utfpr.Service;

import br.edu.utfpr.BancoDeDados;
import br.edu.utfpr.Model.Pessoa;

public class PessoaService implements CrudService<Pessoa, Integer> {

    @Override
    public Pessoa save(Pessoa entity) {
        BancoDeDados.pessoas.add(entity);
        return entity;
    }

    @Override
    public Pessoa getById(Integer id) {
        return BancoDeDados.pessoas.stream()
                .filter(pe -> pe.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public void delete(Pessoa entity) {
        BancoDeDados.pessoas.remove(entity);
    }


    public Pessoa encontraPessoaPeloCodigo(int cod) {

        Pessoa pessoa = BancoDeDados.pessoas.stream().filter(pessoa1 -> pessoa1.getCodPessoa() == cod)
                .findFirst()
                .get();
        return pessoa;

    }
}



