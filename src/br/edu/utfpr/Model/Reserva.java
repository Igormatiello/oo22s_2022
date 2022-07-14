package br.edu.utfpr.Model;

import br.edu.utfpr.Model.Livro;
import br.edu.utfpr.Model.Pessoa;

import java.time.LocalDate;

public class Reserva extends Entity{

   private Livro livro;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Pessoa pessoa;


    public Reserva(int codReserva,Livro l, LocalDate di, LocalDate df, Pessoa p){
        super.id=codReserva;
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
