package Model;

public interface ProdutoRepository {

    //CRUD
    public void listarTodos();
    public void listarPorId(int id);
    public void cadastrar(Produto produto);
    public void editar(Produto produto);
    public void excluir(int id);


}
