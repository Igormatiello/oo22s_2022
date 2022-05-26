package br.edu.utfpr;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {

   private Livro livro;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Pessoa pessoa;


    public Reserva(Livro l, LocalDate di, LocalDate df, Pessoa p){
        this.livro=l;
        this.dataInicial=di;
        this.dataFinal=df;
        this.pessoa=p;

    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "livro=" + livro.getTitulo() +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", pessoa=" + pessoa.getNome() +
                '}';
    }
}
