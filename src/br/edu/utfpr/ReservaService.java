package br.edu.utfpr;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ReservaService {


    public  boolean verificaDisponibilidadeDeReserva(int cod_livro, LocalDate dataInicial, LocalDate dataFinal) {

        boolean parte1 = true;

        if (BancoDeDados.livros.stream()
                .filter(livro -> livro.getCod_livro() == cod_livro)
                .findFirst()
                .get().isEstaAlugado()) ;
        {
            Livro livro = BancoDeDados.livros.stream()
                    .filter(livro1 -> livro1.getCod_livro() == cod_livro)
                    .findFirst()
                    .get();

            Locacao loca = BancoDeDados.locacoes.stream().filter(locacao -> locacao.getLivro().equals(livro) )
                    .findFirst()
                    .get();


            //verifica
            parte1 = ChronoUnit.DAYS.between(loca.getDataFinal(), dataInicial) >= 0;
        }
            if (parte1 == false) {
                System.out.println("Livro indisponível");
                return false;

            }


            Livro livro1 = BancoDeDados.livros.stream()
                    .filter(livro2 -> livro2.getCod_livro() == cod_livro)
                    .findFirst()
                    .get();

            Stream<Reserva> streamReserva = BancoDeDados.reservas.stream().
                    filter(reserva -> reserva.getLivro().equals(livro1));

            Long reservasLivro = streamReserva.count();

            if (reservasLivro == 0) {
                System.out.println("Livro disponível");
                return true;

            } else {
                Long reservaSobrepostas = streamReserva.filter(reserva ->
                                ChronoUnit.DAYS.between(dataInicial, reserva.getDataInicial()) < 0 &&
                                        ChronoUnit.DAYS.between(dataFinal, reserva.getDataInicial()) < 0 ||
                                        ChronoUnit.DAYS.between(dataInicial, reserva.getDataInicial()) > 0 &&
                                                ChronoUnit.DAYS.between(dataInicial, reserva.getDataFinal()) > 0)
                        .count();

                if (reservaSobrepostas > 0) {
                    System.out.println("Livro indisponível");
                    return false;


                }

            }

            System.out.println("Livro disponível");

        return true;
    }

    public  void reservaLivro(Reserva re ){


    BancoDeDados.reservas.add(new Reserva(re.getLivro(),re.getDataInicial(),re.getDataFinal(),re.getPessoa()));

    }







}
