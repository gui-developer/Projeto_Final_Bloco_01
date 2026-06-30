import Model.Livro;
import Model.LivrosNaoEncontradoException;
import Model.Produto;
import Model.Validacao;
import org.w3c.dom.ls.LSOutput;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.InputMismatchException;
import java.util.Scanner;

private static final ProdutoController produtoController = new ProdutoController ();
// Paleta Cyberpunk
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_CIANO = "\u001B[96m";   // Azul neon brilhante
public static final String ANSI_ROSA = "\u001B[95m";    // Magenta/Pink neon
public static final String ANSI_AMARELO = "\u001B[93m"; // Amarelo elétrico
public static final String ANSI_VERDE = "\u001B[92m";   // Verde tipo "Matrix"

public static void main () {
    Scanner scanner = new Scanner (System.in);
    boolean rodando = true;

    Produto livro = new Livro (23,"Harry Potter","JJK",2003,250);
    Produto livro2 = new Livro (21,"Game Of Thrones","JJK",2008,550);
    Produto livro3 = new Livro (22,"Hail Mary","RyanGosling",2024,350);


    produtoController.cadastrar (livro);
    produtoController.cadastrar (livro2);
    produtoController.cadastrar (livro3);

    try{
        do {
            System.out.println (ANSI_CIANO + "*************************************" + ANSI_RESET);
            System.out.println (ANSI_ROSA + "               Livraria               " + ANSI_RESET);
            System.out.println (ANSI_CIANO + "*************************************" + ANSI_RESET);

            System.out.println (ANSI_AMARELO + "1 " + ANSI_RESET + "- " + ANSI_CIANO + "Cadastrar livro" + ANSI_RESET);
            System.out.println (ANSI_AMARELO + "2 " + ANSI_RESET + "- " + ANSI_CIANO + "Listar livros" + ANSI_RESET);
            System.out.println (ANSI_AMARELO + "3 " + ANSI_RESET + "- " + ANSI_CIANO + "Buscar livro por código" + ANSI_RESET);
            System.out.println (ANSI_AMARELO + "4 " + ANSI_RESET + "- " + ANSI_CIANO + "Editar livro" + ANSI_RESET);
            System.out.println (ANSI_AMARELO + "5 " + ANSI_RESET + "- " + ANSI_CIANO + "Excluir livro" + ANSI_RESET);
            System.out.println (ANSI_AMARELO + "6 " + ANSI_RESET + "- " + ANSI_CIANO + "Sair" + ANSI_RESET);
            System.out.println (ANSI_CIANO + "*************************************" + ANSI_RESET);
            System.out.print (ANSI_VERDE + "Entre com a opção desejada: " + ANSI_RESET);
            int acao = scanner.nextInt ();
            scanner.nextLine ();

            switch (acao) {
                case 1: //Cadastro de livros Funcionando!
                    System.out.println ("Digite o código do livro");
                    int codigo = scanner.nextInt ();
                    scanner.nextLine ();

                    System.out.println ("Digite o título do livro");
                    String titulo = scanner.nextLine ();

                    System.out.println ("Digite o autor do livro");
                    String autor = scanner.nextLine ();

                    System.out.println ("Digite o ano de publicação do livro");
                    int anoPublicado = scanner.nextInt ();

                    System.out.println ("Digite o número de páginas do livro");
                    int numeroPaginas = scanner.nextInt ();

                    Produto cadastro = new Livro (codigo, titulo, autor, anoPublicado, numeroPaginas);
                    produtoController.cadastrar (cadastro);
                    break;

                case 2:
                    produtoController.listarTodos ();
                    break;
                case 3:
                    System.out.println ("Digite o código do livro");
                    int id = Validacao.lerInteiro (scanner);
                    scanner.nextLine ();
                    try {
                        produtoController.listarPorId(id); // O Controller lança a exceção se não achar
                    } catch (LivrosNaoEncontradoException e) {
                        System.err.println(e.getMessage()); // Exibe a SUA mensagem
                    }
                    break;
                case 4:
                    System.out.println ("Digite o código do livro que deseja editar");
                    int idDoLivroParaAtualizar = scanner.nextInt ();
                    scanner.nextLine ();
                    System.out.println ("Digite o novo título do livro");
                    String novoTitulo = scanner.nextLine ();
                    System.out.println ("Digite o novo autor do livro");
                    String novoAutor = scanner.nextLine ();
                    System.out.println ("Digite o novo ano de publicação do livro");
                    int novoAnoPublicado = scanner.nextInt ();
                    System.out.println ("Digite o novo número de páginas do livro");
                    int novoNumeroPaginas = scanner.nextInt ();
                    Produto novoLivro = new Livro (idDoLivroParaAtualizar, novoTitulo, novoAutor, novoAnoPublicado, novoNumeroPaginas);
                    produtoController.editar (novoLivro);
                    break;
                case 5:
                    System.out.println ("Digite o código do livro que deseja excluir");
                    int idDoLivroParaExcluir = scanner.nextInt ();
                    produtoController.excluir (idDoLivroParaExcluir);
                    break;

                case 6:
                    rodando = false;
                    break;
                default:
                    System.out.println ("Opção inválida");
            }
        } while (rodando == true);
    } catch (Exception e) {
        throw new RuntimeException (e.getMessage ());
    }
}

public static void listarLivros(){
    produtoController.listarTodos ();
}
