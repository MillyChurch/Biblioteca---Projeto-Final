package dao;
import java.util.List;
import biblioteca.Usuario;
import biblioteca.Livro;
import java.util.ArrayList;

/**
 *
 * @author Millychurch
 */
public interface UsuariosDao {
    
    public int cadastrarUsuario(Usuario usuario);
    public int logarUsuario(Usuario usuario);
    public ArrayList<Livro> carregarLivrosDoUsuario(int userId);
    public void cadastrarLivro(Livro livro);
    public void deletarLivro(int livroId);
    public void editarLivro(Livro livro);
    public Livro buscarLivro(Livro livro, int livroId);
}
