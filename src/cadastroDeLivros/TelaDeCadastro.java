/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroDeLivros;

import biblioteca.Usuario;
import conexao.ConexaoMySQL;
import dao.UsuariosDaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Millychurch
 */
public class TelaDeCadastro extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form TelaDeCadastro
     */
    public TelaDeCadastro(){
        
         try {
            conexao = ConexaoMySQL.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bibliotecaDigital = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        campoDeNome = new javax.swing.JTextField();
        senha = new javax.swing.JLabel();
        cadastrar = new javax.swing.JButton();
        campoDeSenha = new javax.swing.JPasswordField();
        voltarAoLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        bibliotecaDigital.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        bibliotecaDigital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadastroDeLivros/Icons/iconeLivro.png"))); // NOI18N
        bibliotecaDigital.setText("Biblioteca Digital");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadastroDeLivros/Icons/cadastro.png"))); // NOI18N

        nome.setText("Nome");

        campoDeNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDeNomeActionPerformed(evt);
            }
        });

        senha.setText("Senha");

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        campoDeSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDeSenhaActionPerformed(evt);
            }
        });

        voltarAoLogin.setText("Já tenho uma Conta");
        voltarAoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarAoLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bibliotecaDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarAoLogin)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senha)
                    .addComponent(nome)
                    .addComponent(cadastrar)
                    .addComponent(campoDeSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(campoDeNome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bibliotecaDigital)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarAoLogin)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDeNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha)
                .addGap(1, 1, 1)
                .addComponent(campoDeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cadastrar)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoDeSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDeSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDeSenhaActionPerformed

    private void voltarAoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarAoLoginActionPerformed
        setVisible(false);
        TelaDeLogin retornarAoLogin = new TelaDeLogin();
        retornarAoLogin.setVisible(true);
    }//GEN-LAST:event_voltarAoLoginActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        
        if(campoDeNome.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seu nome de usuário não pode ficar vazio");
        } 
        
        else if(campoDeNome.getText().length() < 5){
            JOptionPane.showMessageDialog(null, "Seu nome de usuário precisa ter no mínimo 5 caracteres ");
        } 
        
        else if(campoDeSenha.getPassword().length < 5){
            JOptionPane.showMessageDialog(null, "Sua senha de usuário precisa ter no mínimo 5 caracteres ");
        }
        
        else{
            
            Usuario usuario = new Usuario();
            usuario.setNome(campoDeNome.getText());
            usuario.setSenha(campoDeSenha.getText());
            UsuariosDaoJdbc dao = new UsuariosDaoJdbc();
            
            if(dao.cadastrarUsuario(usuario) == 1){
                dispose();
                TelaDeLogin tela = new TelaDeLogin();
                tela.setVisible(true);
            }
            
        }
        
    }//GEN-LAST:event_cadastrarActionPerformed

    private void campoDeNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDeNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDeNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bibliotecaDigital;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField campoDeNome;
    private javax.swing.JPasswordField campoDeSenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel senha;
    private javax.swing.JButton voltarAoLogin;
    // End of variables declaration//GEN-END:variables
}