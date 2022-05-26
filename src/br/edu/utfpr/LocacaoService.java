package br.edu.utfpr;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocacaoService {


    public boolean livroDisponivel(int cod_livro) {

        boolean resposta= !BancoDeDados.livros.stream()
                .filter(livro -> livro.getCod_livro() == cod_livro)
                .findFirst()
                .get().isEstaAlugado();

        if(resposta==true)
        {
            System.out.println("Livro disponível");

        }
        else {

            System.out.println("Livro indisponível");
        }


        return resposta;


    }

    public void locarLivro(int cod_livro, Pessoa pe) {
        Livro l = BancoDeDados.livros.stream()
                .filter(livro -> livro.getCod_livro() == cod_livro)
                .findFirst()
                .get();


        if (livroDisponivel(cod_livro)) {

            BancoDeDados.locacoes.add(
                    new Locacao(l, pe, LocalDate.now(), ChronoUnit.DAYS.addTo(LocalDate.now(), 30)));


//TORNAR O LIVRO INDISPONIVEL
            BancoDeDados.livros.stream()
                    .filter(livro -> livro.getCod_livro() == cod_livro)
                    .findFirst()
                    .get().setEstaAlugado(true);


        } else {

//sout +TAB
            System.out.println("Livro não está disponível");
        }


    }


    public void devolveLivro(Locacao locacao, LocalDate entrega) {
        BancoDeDados.livros.stream()
                .filter(livro1 -> livro1.getCod_livro() == locacao.getLivro().getCod_livro())
                .findFirst()
                .get().setEstaAlugado(false);

        int diasAtras=verificaDataEntrega(entrega,locacao);
        if (diasAtras>0){

            System.out.println("Valor da Multa é: "+calculaMulta(diasAtras) );
        }


    }




    public int verificaDataEntrega(LocalDate entrega,Locacao l){

        return (int) ChronoUnit.DAYS.between(l.getDataFinal(),entrega);



    }

    private   double calculaMulta(int dias){

        double multa=0;
        if (dias > 40){
            multa=20+ ((dias-40)*1);

        }
        if (dias<=40)
        {
            multa=dias*0.5;
        }
        return multa;

    }


    public Locacao encontraLocacao(int cod)
    {
       return  BancoDeDados.locacoes.stream().filter(locacao -> locacao.getLivro().getCod_livro()==cod)
                .findFirst()
                .get();


    }

}


