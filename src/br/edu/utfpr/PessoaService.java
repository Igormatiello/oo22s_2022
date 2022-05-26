package br.edu.utfpr;

public class PessoaService {

    public Pessoa encontraPessoaPeloCodigo(int cod){

         Pessoa pessoa=  BancoDeDados.pessoas.stream().filter(pessoa1 -> pessoa1.getCod_pessoa()==cod)
                .findFirst()
                .get();
        return pessoa;

    }






}
