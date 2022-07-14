package br.edu.utfpr.Service;

import br.edu.utfpr.BancoDeDados;
import br.edu.utfpr.Model.Livro;
import br.edu.utfpr.Model.Locacao;
import br.edu.utfpr.Model.Reserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class ReservaService implements CrudService<Reserva,Integer>{


    @Override
    public Reserva save(Reserva entity) {
        BancoDeDados.reservas.add(entity);
        return entity;
    }

    @Override
    public Reserva getById(Integer id) {
        return BancoDeDados.reservas.stream()
                .filter(re->re.getId()==id)
                .findFirst()
                .get();
    }

    @Override
    public void delete(Reserva entity) {
        BancoDeDados.reservas.remove(entity);
    }

    public  boolean verificaDisponibilidadeDeReserva(int cod_livro, LocalDate dataInicial, LocalDate dataFinal) {

        boolean parte1 = true;

        Livro livro = BancoDeDados.livros.stream()
                .filter(livro1 -> livro1.getCod_livro() == cod_livro)
                .findFirst()
                .get();
        if (BancoDeDados.livros.stream()
                .filter(livro1 -> livro1.getCod_livro() == cod_livro)
                .findFirst()
                .get().isEstaAlugado())
        {


            Locacao loca = BancoDeDados.locacoes.stream().filter(locacao -> locacao.getLivro().equals(livro) )
                    .findFirst()
                    .orElse(null);


            //verifica
            if(loca!= null)
            parte1 = ChronoUnit.DAYS.between(loca.getDataFinal(), dataInicial) >= 0;
        }
            if (parte1 ) {
                System.out.println("Livro indisponível");
                return false;

            }






            Long reservasLivro = BancoDeDados.reservas.stream().
                    filter(reserva -> reserva.getLivro().equals(livro)).count();

            if (reservasLivro == 0) {
                System.out.println("Livro disponível");
                return true;

            } else {
                Long reservaSobrepostas = BancoDeDados.reservas.stream().
                        filter(reserva -> reserva.getLivro().equals(livro)).filter(reserva ->
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





}
