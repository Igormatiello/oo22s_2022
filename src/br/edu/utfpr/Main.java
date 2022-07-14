package br.edu.utfpr;

import br.edu.utfpr.Model.Livro;
import br.edu.utfpr.Model.Pessoa;
import br.edu.utfpr.Model.Reserva;
import br.edu.utfpr.Service.LivroService;
import br.edu.utfpr.Service.LocacaoService;
import br.edu.utfpr.Service.PessoaService;
import br.edu.utfpr.Service.ReservaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
Criar programa orientado à objetos para solucionar os seguintes casos de uso:
- Será o controle de uma biblioteca
- Desenvolver método para a locação de livro
- deverá validar se livro está disponível
- Método para reserva de livro
- Validá se há alguma reserva para data e se estará disponível
- Método para devolução do livro
- Válida se a data da entrega é anterior a data máxima
- caso tenha vencido calcular 50 centavos ao dia até 20 reais, depois 1 real por dia

 */
public class Main {




    public static void main(String[] args) {
	// write your code here
LocacaoService ls=new LocacaoService();
PessoaService ps=new PessoaService();
ReservaService rs=new ReservaService();
LivroService livroService=new LivroService();
        DateTimeFormatter formatter=  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        BancoDeDados.livros.add(new Livro(1,"a era do gelo","gabriel gotardo",190,2020,false));
        BancoDeDados.livros.add(new Livro(2,"a era da revolução","negrao matos",197,2022,false));
        BancoDeDados.livros.add(new Livro(3,"gremio","joão marcelo",200,2020,false));
        BancoDeDados.livros.add(new Livro(4,"quem é o culpado?","valcir junior",190,2020,false));
        BancoDeDados.livros.add(new Livro(5,"musica e besouros","john lenon",190,2010,false));
        BancoDeDados.livros.add(new Livro(6,"cavalos","rodrigo faro",210,2012,false));
        BancoDeDados.livros.add(new Livro(7,"a era do futebol","cristiano ronaldo",110,2020,false));
        BancoDeDados.livros.add(new Livro(8,"princesa","artur angelo",220,2021,false));
        BancoDeDados.livros.add(new Livro(9,"dragão","vitor mike",620,2007,false));


        Pessoa p1= new Pessoa("igor matiello", 1);
        BancoDeDados.pessoas.add(p1);
        BancoDeDados.pessoas.add(new Pessoa("jaque silva", 2));
        BancoDeDados.pessoas.add(new Pessoa("mauricio barbosa", 3));
        BancoDeDados.pessoas.add(new Pessoa("gabriel fernandes", 4));
        BancoDeDados.pessoas.add(new Pessoa("joao pedro", 5));
        BancoDeDados.pessoas.add(new Pessoa("lucas lima", 6));

        Scanner scanner=new Scanner(System.in);
        int repeticao = 0;
        do {
            System.out.println("\nDigite 0 ->para sair " +
                    "\n1-para locar livro" +
                    "\n2-para reservar livro"+
                    "\n3-para devolver livro"+
                    "\n4-para consultar locacações" +
                    "\n5- para consultar reservas");

             repeticao = scanner.nextInt();


             switch (repeticao) {

                 case 1:
                 {


                 System.out.println("Informe o código do livro para busca-lo: ");
                 int codigo = scanner.nextInt();

                 if (ls.livroDisponivel(codigo) == true) {
                 }
                     System.out.println("Digite o cod da pessoa para locar o livro: ");

                  ls.locarLivro(codigo,ps.encontraPessoaPeloCodigo(scanner.nextInt()));


                     break;



                 }

                 case 2:
                 {
                     System.out.println("Informe o código do livro para busca-lo: ");
                     int codigoReserva = scanner.nextInt();


                     System.out.println("Informe a data de reserva inicial: ");
                     scanner.nextLine();

                     LocalDate dataInicial =LocalDate.parse( scanner.nextLine(),formatter);
                     System.out.println("Informe a data de devolucao: ");
                     LocalDate dataFinal =LocalDate.parse( scanner.nextLine(),formatter);



                    if( rs.verificaDisponibilidadeDeReserva(codigoReserva,dataInicial,dataFinal))
                     {
                         System.out.println("Informe o codigo da pessoa: ");
                         scanner.nextLine();
                         int codPessoa = scanner.nextInt();
                         int aux=1;

                         Reserva reserva=new Reserva(aux,livroService.encontraLivroPeloCodigo(codigoReserva),dataInicial,dataFinal,
                                ps.encontraPessoaPeloCodigo( codPessoa));
                         BancoDeDados.reservas.add(reserva);
                        aux++;
                     }

                break;
                 }
                 case 3:
                 {
                     System.out.println("Informe o codigo do livro para devolucao: ");
                    ls.devolveLivro( ls.encontraLocacao(scanner.nextInt()),LocalDate.now());

                     break;
                 }
                 case 4:
                 {
                     BancoDeDados.locacoes.stream().forEach(System.out::println);


                     break;
                 }
                 case 5:
                 {
                     BancoDeDados.reservas.stream().forEach(x -> System.out.println(x));


                     break;
                 }

                 default:
                 {
                     repeticao=0;
                 }

             }


        }while (repeticao == 1 || repeticao==2 || repeticao==3 || repeticao==4 || repeticao==5);
    }
}
