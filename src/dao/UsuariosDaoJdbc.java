/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import biblioteca.Livro;
import conexao.ConexaoMySQL;
import java.sql.Connection;;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import biblioteca.Usuario;
import cadastroDeLivros.TelaDeCadastro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Millychurch
 */
public class UsuariosDaoJdbc implements UsuariosDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet resultSetFromUsuarios = null;
    
    @Override
    public int cadastrarUsuario(Usuario usuario) {
        
        String sqlQuerryConflictUser = "SELECT userName FROM `usuarios`WHERE (userName = '" + usuario.getNome() +  "')"; 
        String sqlGetUserId = "SELECT userId FROM `usuarios` WHERE (userName = '" + usuario.getNome() + "')";
        String InsertUserInDb = "INSERT INTO usuarios(userName, userPass) VALUES" + "('" + usuario.getNome() + "','" + usuario.getSenha() + "')";
        
        //Fazer uma consulta no banco para verificar se há um usuário com esse nome
        
        try {
            
            conexao = ConexaoMySQL.getConexao();

            pst = conexao.prepareStatement(sqlQuerryConflictUser);
            resultSetFromUsuarios = pst.executeQuery(sqlQuerryConflictUser);
            
            if(resultSetFromUsuarios.next() && resultSetFromUsuarios.getString("userName").equals(usuario.getNome())){
                JOptionPane.showMessageDialog(null, "Um usuário já escolheu esse nome, tente outro!!");
                return 0;
            }
            
        } 
        
        catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possível te registrar");
                Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível te registrar");
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        //Cadastro do usuário permitido
        try {
            
            pst = conexao.prepareStatement(InsertUserInDb);
            pst.executeUpdate(InsertUserInDb);
            JOptionPane.showMessageDialog(null, "Registro concluído!");
            
            pst = conexao.prepareStatement(sqlGetUserId);
            resultSetFromUsuarios = pst.executeQuery(sqlGetUserId);
            return 1;
            
        } 
        catch (SQLException ex){
            
                JOptionPane.showMessageDialog(null, "Não foi possível te registrar");
                Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
        }
        
        finally{
            fecharConexao();
        }
            

    }

    @Override
    public int logarUsuario(Usuario usuario) {
        
        String sqlGetUserId = "SELECT userId FROM `usuarios` WHERE (userName = '" + usuario.getNome() + "')";
        String sqlQuerryUserExist = "SELECT userName FROM `usuarios` WHERE (userName = '" + usuario.getNome() +  "')";
        String sqlQuerryPasswordCorrect = "SELECT `userPass` FROM `usuarios` WHERE (userName = '" + usuario.getNome() +  "')";
        
        try {
            
            conexao = ConexaoMySQL.getConexao();
            pst = conexao.prepareStatement(sqlQuerryUserExist);
            pst.executeQuery(sqlQuerryUserExist);
            resultSetFromUsuarios = pst.executeQuery(sqlQuerryUserExist);
            
               
                
                pst.executeQuery(sqlQuerryPasswordCorrect);
                resultSetFromUsuarios = pst.executeQuery(sqlQuerryPasswordCorrect);
                
                if(resultSetFromUsuarios.next()){
                    
                    if(resultSetFromUsuarios.getString("userPass").equals(usuario.getSenha())){

                        pst = conexao.prepareStatement(sqlGetUserId);
                        resultSetFromUsuarios = pst.executeQuery(sqlGetUserId);
                        
                        while(resultSetFromUsuarios.next()){
                            usuario.setUserId((resultSetFromUsuarios.getInt("userId")));
                            usuario.setLivros(carregarLivrosDoUsuario((usuario.getUserId())));
                        }
                        
                        JOptionPane.showMessageDialog(null, "Você foi logado com sucesso");

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                        return 0;
                    }
                }
                
                else{
                    
                    JOptionPane.showMessageDialog(null, "Nome de usuario incorreto/Usuário não existe!!");
                    return 0;
                    
                }
        } 
        
        catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possível se conectar com o servidor de nossa biblioteca digital");
                Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
                
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

        return 1;
        
    }
    
    private void fecharConexao() {
        try {
            if (resultSetFromUsuarios != null) {
                resultSetFromUsuarios.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }

    @Override
    public ArrayList<Livro> carregarLivrosDoUsuario(int userId) {
        
        ArrayList<Livro> livrosDoUsuario = new ArrayList<Livro>();
        String sqlQuerryUserBooks = "SELECT * FROM `estanteDeLivros` WHERE (userId = '" + userId +  "')";
        
        try{
            
            conexao = ConexaoMySQL.getConexao();
            pst = conexao.prepareStatement(sqlQuerryUserBooks);
            pst.executeQuery(sqlQuerryUserBooks);
            resultSetFromUsuarios = pst.executeQuery(sqlQuerryUserBooks);
            
            while(resultSetFromUsuarios.next()){
                
                Livro book = new Livro();
                book.setTitulo(resultSetFromUsuarios.getString("nome"));
                book.setGenero(resultSetFromUsuarios.getString("genero"));
                book.setAutor(resultSetFromUsuarios.getString("autor"));
                book.setAnoDePublicacao(resultSetFromUsuarios.getInt("AnoDePublicacao"));
                book.setNumeroDePaginas(resultSetFromUsuarios.getInt("pagTotais"));
                book.setPaginasLidas(resultSetFromUsuarios.getInt("pagLidas"));
                book.setLivroId(resultSetFromUsuarios.getInt("livroId"));
                book.setUserId(resultSetFromUsuarios.getInt("userId") );
                livrosDoUsuario.add(book);
                
            }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Não foi possível carregar seus livros");
            Logger.getLogger(sqlQuerryUserBooks);
            
        }
        
        return livrosDoUsuario;
    }

    @Override
    public void cadastrarLivro(Livro livro) {
        
        String dataBook = 
        "'" + livro.getTitulo() + "','" + livro.getGenero() + "','" + livro.getAutor() + "'," +
        livro.getAnoDePublicacao() + "," + livro.getNumeroDePaginas() + "," + livro.getPaginasLidas() + "," + livro.getUserId() + "";
        String sqlQuerryRegisterBooks = "INSERT INTO `estanteDeLivros`(nome,genero,autor,AnoDePublicacao,pagTotais,pagLidas,userId) VALUES(" + dataBook + ");";
        
        try{
            
            conexao = ConexaoMySQL.getConexao();
            pst = conexao.prepareStatement(sqlQuerryRegisterBooks);
            pst.executeUpdate(sqlQuerryRegisterBooks);
            //pst.setString(1, dataBook);
            JOptionPane.showMessageDialog(null, "Livro Registrado!!!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar seu livro");
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deletarLivro(int livroId) {
        
        String sqlDeletarLivros = "DELETE FROM estanteDeLivros WHERE livroId="+ livroId + ";";
        
        try{
            
           conexao = ConexaoMySQL.getConexao();
           pst = conexao.prepareStatement(sqlDeletarLivros);
           pst.executeUpdate(sqlDeletarLivros);
           JOptionPane.showMessageDialog(null, "Livro Deletado!!!");
           
        } 
        
        catch (Exception ex) {
            
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível deletar o livro!!!");
            
        }
        
    }

    @Override
    public void editarLivro(Livro livro) {
        
        String sqlQuerryBookFind = "SELECT * FROM `estanteDeLivros` WHERE (livroId = '" + livro.getLivroId() +  "')";
        String sqlChangeBook = "UPDATE estanteDeLivros SET autor = '"+ livro.getAutor()+"' , genero =  '" + livro.getGenero()+ "', nome = '" + livro.getTitulo() + "',AnoDePublicacao = " + livro.getAnoDePublicacao()+ ", pagLidas = " + livro.getPaginasLidas() + ", pagTotais =" + livro.getNumeroDePaginas() + " WHERE (livroId = " + livro.getLivroId() + ");" ;
        
        try{
            
           conexao = ConexaoMySQL.getConexao();
           pst = conexao.prepareStatement(sqlQuerryBookFind);
           resultSetFromUsuarios = pst.executeQuery(sqlQuerryBookFind);
           
           if(resultSetFromUsuarios != null){
               pst=conexao.prepareStatement(sqlChangeBook);
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null, "Livro Atualizado!!!");
           }
           
           else{
           
               JOptionPane.showMessageDialog(null, "Este Livro Já Foi Deletado!!!");
               
           }
           
           
           
        } 
        
        catch (Exception ex) {
            
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados do livro!!!");
            
        }
        
    }

    @Override
    public Livro buscarLivro(Livro livro, int livroId) {
        
        String sqlQuerryBookFind = "SELECT * FROM `estanteDeLivros` WHERE (livroId = " + livroId +  ")";
        
        try {
            conexao = ConexaoMySQL.getConexao();
            pst = conexao.prepareStatement(sqlQuerryBookFind);
            resultSetFromUsuarios = pst.executeQuery(sqlQuerryBookFind);
            
             while(resultSetFromUsuarios.next()){
                
                livro.setTitulo(resultSetFromUsuarios.getString("nome"));
                livro.setGenero(resultSetFromUsuarios.getString("genero"));
                livro.setAutor(resultSetFromUsuarios.getString("autor"));
                livro.setAnoDePublicacao(resultSetFromUsuarios.getInt("AnoDePublicacao"));
                livro.setNumeroDePaginas(resultSetFromUsuarios.getInt("pagTotais"));
                livro.setPaginasLidas(resultSetFromUsuarios.getInt("pagLidas"));
                livro.setLivroId(resultSetFromUsuarios.getInt("livroId"));
                livro.setUserId(resultSetFromUsuarios.getInt("userId") );
                
            }
             
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o livro em nossa base de dados");
            Logger.getLogger(UsuariosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return livro;
    }
    
    
    
}

