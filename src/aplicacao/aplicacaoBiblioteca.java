/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import biblioteca.Livro;
import biblioteca.Usuario;
import cadastroDeLivros.TelaDeLogin;
import dao.UsuariosDaoJdbc;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Millychurch
 */
public class aplicacaoBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form aplicacaoBiblioteca
     * @param usuario
     */
    
    Usuario usuario;
    
    public aplicacaoBiblioteca(Usuario usuario) {
        
        this.usuario = usuario;
        initComponents();
        verificarLivros(usuario);
        agradecimento.setText("Obrigado " + usuario.getNome());

    }

    public final void sort(Usuario usuario){
    }
    
    
    public final void verificarLivros(Usuario usuario){
        DefaultTableModel tblModel = (DefaultTableModel) tabelaDeLivros.getModel();
        tblModel.setRowCount(0);
        ArrayList<Livro> livros = new ArrayList();
        livros = usuario.getLivros();
        
        if(Classify.getSelectedItem().toString() == "Título"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getTitulo().compareToIgnoreCase(livros.get(j).getTitulo()) > 0){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
        
        else if(Classify.getSelectedItem().toString() == "Autor"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getAutor().compareToIgnoreCase(livros.get(j).getAutor()) > 0){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
    
        else if(Classify.getSelectedItem().toString() == "Gênero"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getGenero().compareToIgnoreCase(livros.get(j).getGenero()) > 0){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
        
        else if(Classify.getSelectedItem().toString() == "Ano de Lançamento"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getAnoDePublicacao() > livros.get(j).getAnoDePublicacao()){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
        
        else if(Classify.getSelectedItem().toString() == "Páginas Lidas"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getPaginasLidas() > livros.get(j).getPaginasLidas()){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
        
        else if(Classify.getSelectedItem().toString() == "Número de Páginas"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getNumeroDePaginas() > livros.get(j).getNumeroDePaginas()){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
        
        else if(Classify.getSelectedItem().toString() == "%lido"){
            for(int i = 0; i<livros.size(); i++){

                        for(int j = i+1 ; j < livros.size(); j++ ){

                        if (livros.get(i).getPaginasLidas()/livros.get(i).getNumeroDePaginas() > livros.get(j).getPaginasLidas()/livros.get(j).getNumeroDePaginas() ){
                            Collections.swap(livros, i, j); 
                    } 
                } 
            }
        }
        
        if(jComboBox1.getSelectedItem().toString() == "Crescente"){
            for(int i = 0; i< usuario.getLivros().size(); i++){

                String dadosParaATabela[] = {
                livros.get(i).getTitulo(), 
                livros.get(i).getAutor(),
                livros.get(i).getGenero(),
                Integer.toString(livros.get(i).getAnoDePublicacao()), 
                Integer.toString(livros.get(i).getPaginasLidas()), 
                Integer.toString(livros.get(i).getNumeroDePaginas()),
                Integer.toString(((livros.get(i).getPaginasLidas())/(livros.get(i).getNumeroDePaginas()))*100) + "%",
                "#" + String.format("%06d", livros.get(i).getLivroId())
                };
                tblModel.addRow(dadosParaATabela);
            }
        }
     
        else{
            for(int i = usuario.getLivros().size()-1; i>=0; i--){

                    String dadosParaATabela[] = {
                    livros.get(i).getTitulo(), 
                    livros.get(i).getAutor(),
                    livros.get(i).getGenero(),
                    Integer.toString(livros.get(i).getAnoDePublicacao()), 
                    Integer.toString(livros.get(i).getPaginasLidas()), 
                    Integer.toString(livros.get(i).getNumeroDePaginas()),
                    Integer.toString((((livros.get(i).getPaginasLidas())*100)/(livros.get(i).getNumeroDePaginas()))) + "%",
                    "#" + String.format("%06d", livros.get(i).getLivroId())
                    };
                    tblModel.addRow(dadosParaATabela);
            }
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaDeLivros = new javax.swing.JScrollPane();
        tabelaDeLivros = new javax.swing.JTable();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        satoko = new javax.swing.JLabel();
        agradecimento = new javax.swing.JLabel();
        agradecimentMsg = new javax.swing.JLabel();
        agradecimentMsg1 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        sairBotao = new javax.swing.JButton();
        Classify = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaDeLivros.setBorder(null);

        tabelaDeLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Genero", "Ano de Lançamento", "Páginas Lidas", "Páginas Totais", "% Lido", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDeLivros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabelaDeLivros.setAutoscrolls(false);
        tabelaDeLivros.setRowHeight(30);
        listaDeLivros.setViewportView(tabelaDeLivros);

        getContentPane().add(listaDeLivros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 838, 630));

        add.setText("Adicionar Livro");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 636, 128, 35));

        edit.setText("Editar Livro");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 636, 128, 35));

        delete.setText("Excluir Livro");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 636, 128, 35));

        satoko.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        satoko.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        satoko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacao/aplicacaoIcons/satokoTable.png"))); // NOI18N
        getContentPane().add(satoko, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 81, 480, -1));

        agradecimento.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 24)); // NOI18N
        agradecimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(agradecimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 260, 30));

        agradecimentMsg.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 24)); // NOI18N
        agradecimentMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agradecimentMsg.setText("Boa leitura!!!");
        getContentPane().add(agradecimentMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 450, 30));

        agradecimentMsg1.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 24)); // NOI18N
        agradecimentMsg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agradecimentMsg1.setText("Por utilizar nossa biblioteca");
        getContentPane().add(agradecimentMsg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 490, 30));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacao/aplicacaoIcons/icons8-refresh-30.png"))); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 636, 30, 35));

        sairBotao.setText("Sair");
        sairBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBotaoActionPerformed(evt);
            }
        });
        getContentPane().add(sairBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 636, 110, 35));

        Classify.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classificar por:", "Título", "Autor", "Gênero", "Ano de Lançamento", "Páginas Lidas", "Número de Páginas", "% Lido" }));
        getContentPane().add(Classify, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 120, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decrescente", "Crescente" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 110, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        CadastroDeLivro cadastro = new CadastroDeLivro(usuario);
        cadastro.setVisible(true);
        
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        
        if(tabelaDeLivros.getSelectedRow() == -1 ){
            
            JOptionPane.showMessageDialog(this, "Selecione um livro para editar");
            
        }else{
        
            Livro livro = new Livro();
            UsuariosDaoJdbc dao = new UsuariosDaoJdbc();
            String idLivro = tabelaDeLivros.getValueAt(tabelaDeLivros.getSelectedRow(), 7).toString().substring(1);
            livro.setLivroId(Integer.parseInt(idLivro));
            dao.buscarLivro(livro, livro.getLivroId());
            System.out.println(livro.getTitulo());
            
            EdicaoDeLivro1 edit = new EdicaoDeLivro1(livro);
            edit.setVisible(true);
        
        }
        
        
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        if(tabelaDeLivros.getSelectedRow() == -1 ){
            
            JOptionPane.showMessageDialog(this, "Selecione um livro para deletar");
            
        }        
        
        else if(JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar o livro " + tabelaDeLivros.getValueAt( tabelaDeLivros.getSelectedRow(), 0) + "?" )  == 0 ){
        
            UsuariosDaoJdbc dao = new UsuariosDaoJdbc();
            String livroId = tabelaDeLivros.getValueAt(tabelaDeLivros.getSelectedRow(), 7).toString();
            dao.deletarLivro(Integer.parseInt(livroId.substring(1)));
            
        }
       
    }//GEN-LAST:event_deleteActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        
        UsuariosDaoJdbc dao = new UsuariosDaoJdbc();
        usuario.setLivros(dao.carregarLivrosDoUsuario(usuario.getUserId()));
        verificarLivros(usuario);
        
    }//GEN-LAST:event_refreshActionPerformed

    private void sairBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBotaoActionPerformed
        setVisible(false);
        TelaDeLogin telaDeLogin = new TelaDeLogin();
        telaDeLogin.setVisible(true);
    }//GEN-LAST:event_sairBotaoActionPerformed

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
            java.util.logging.Logger.getLogger(aplicacaoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aplicacaoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aplicacaoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aplicacaoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new aplicacaoBiblioteca(usuario).setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Classify;
    private javax.swing.JButton add;
    private javax.swing.JLabel agradecimentMsg;
    private javax.swing.JLabel agradecimentMsg1;
    private javax.swing.JLabel agradecimento;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane listaDeLivros;
    private javax.swing.JButton refresh;
    private javax.swing.JButton sairBotao;
    private javax.swing.JLabel satoko;
    private javax.swing.JTable tabelaDeLivros;
    // End of variables declaration//GEN-END:variables

    
    
}
