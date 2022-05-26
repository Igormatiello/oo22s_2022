package br.edu.utfpr;

import java.time.LocalDate;
import java.util.Date;

public class Locacao {

    private Livro livro;
    private Pessoa pessoa;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public Locacao(Livro l, Pessoa p, LocalDate di, LocalDate df){
        this.livro=l;
        this.pessoa=p;
        this.dataInicial=di;
        this.dataFinal=df;

    }


    public Livro getLivro() {
        return livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "livro=" + livro.getTitulo() +
                ", pessoa=" + pessoa.getNome() +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                '}';
    }
}
