package br.edu.utfpr.Model;

import br.edu.utfpr.Model.Livro;
import br.edu.utfpr.Model.Pessoa;

import java.time.LocalDate;

public class Locacao extends Entity {

    private Livro livro;
    private Pessoa pessoa;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public Locacao(int cod_locacao,Livro l, Pessoa p, LocalDate di, LocalDate df){
        super.id=cod_locacao;
        this.livro=l;
        this.pessoa=p;
        this.dataInicial=di;
        this.dataFinal=df;

    }
    public int getCodLocacao(){return super.id;}

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
