import Model.LivrosNaoEncontradoException;
import Model.Produto;
import Model.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {

    ArrayList<Produto> listaProdutos = new ArrayList<> ();

    public Produto buscarNaLista(int id){
        for (Produto produto : listaProdutos){
            if (produto.getId() == id){
                return produto;
            }
        }
        throw new LivrosNaoEncontradoException ("O livro solicitado não existe");
    }

    @Override
    public void listarTodos () {
        for (Produto produto:listaProdutos){
            produto.imprimir ();
        }
    }

    @Override
    public void listarPorId (int id) {
        Produto produtoId = buscarNaLista (id);
        if (produtoId != null){
            produtoId.imprimir ();
        }else
            System.err.println ("Id do livro não encontrado");
    }

    @Override
    public void cadastrar (Produto produto) {
        listaProdutos.add (produto);
    }

    @Override
    public void editar (Produto produto) {
        int idDoLivroParaAtualizar = produto.getId ();

        Produto produtoId = buscarNaLista (idDoLivroParaAtualizar);

        if (produtoId != null){
            int posicao = listaProdutos.indexOf (produtoId);
            listaProdutos.set (posicao,produto);
            System.out.println ("Livro atualizado com sucesso!");
        }else
            System.out.println ("Livro não encontrada");
    }

    @Override
    public void excluir (int id) {
        Produto produtoId = buscarNaLista (id);

        if (produtoId != null){
            listaProdutos.remove (produtoId);
            System.out.println ("Livro removido com sucesso!");
        }else
            System.out.println ("O Livro solicitado não existe");

    }
}

