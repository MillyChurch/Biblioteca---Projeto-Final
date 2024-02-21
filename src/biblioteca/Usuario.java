
package biblioteca;

import biblioteca.Livro;
import java.util.ArrayList;

/**
 *
 * @author Millychurch
 */
public class Usuario {
    
    private String nome;
    private String senha;
    private int userId;
    private ArrayList<Livro> livros = new ArrayList(); 

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + ", userId=" + userId + '}';
    }
    
    
    
}

