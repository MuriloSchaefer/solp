/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.controladorCliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author murilo
 */
public class UIConsultarCliente extends javax.swing.JFrame {

    /**
     * Creates new form UIConsultaCliente
     */
    
    public class MyTableModel extends DefaultTableModel {

       public MyTableModel(Object[][] tableData, Object[] colNames) {
          super(tableData, colNames);
       }

       public boolean isCellEditable(int row, int column) {
          return false;
       }
    }
    
    public UIConsultarCliente() {
        initComponents();
        
        List<model.Cliente> lista = null;
        try {
            lista = controladorCliente.consultar(txtNomeFantasia.getText(), txtRazaoSocial.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UIConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] columnNames = {"Id",
            "CNPJ",
            "Razão Social",
            "Nome Fantasia"};
        Object[][] data = null;
        MyTableModel dtm = new MyTableModel(data, columnNames);

        int n = lista.size();
        for(int i=0; i<n; i++){
            Object[] linha = {lista.get(i).getId().toString(),
                lista.get(i).getCnpj(),
                lista.get(i).getRazaoSocial(),
                lista.get(i).getNomeFantasia()};
            dtm.addRow(linha);
        }

        tblCliente.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cliente");

        jLabel1.setText("Nome Fantasia:");

        txtNomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeFantasiaKeyReleased(evt);
            }
        });

        jLabel2.setText("Razão Social:");

        txtRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRazaoSocialKeyReleased(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeFantasia)
                            .addComponent(txtRazaoSocial))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeFantasiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeFantasiaKeyReleased
        // TODO add your handling code here:
        /**
        * Quando uma tecla é precionada, ou solta-la é disparada a ação para uma nova consulta ao banco
        * atualizando a tabela contendo os clientees com o nome fantasia desejado.
        */
        List<model.Cliente> lista = null;
        try {
            lista = controladorCliente.consultar(txtNomeFantasia.getText(), txtRazaoSocial.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UIConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] columnNames = {"Id",
            "CNPJ",
            "Razão Social",
            "Nome Fantasia"};
        Object[][] data = null;
        MyTableModel dtm = new MyTableModel(data, columnNames);

        int n = lista.size();
        for(int i=0; i<n; i++){
            Object[] linha = {lista.get(i).getId().toString(),
                lista.get(i).getCnpj(),
                lista.get(i).getRazaoSocial(),
                lista.get(i).getNomeFantasia()};
            dtm.addRow(linha);
        }

        tblCliente.setModel(dtm);
    }//GEN-LAST:event_txtNomeFantasiaKeyReleased

    private void txtRazaoSocialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoSocialKeyReleased
        // TODO add your handling code here:
        /**
        * Quando uma tecla é precionada, ou solta-la é disparada a ação para uma nova consulta ao banco
        * atualizando a tabela contendo os clientees com a razão social desejado.
        */
        List<model.Cliente> lista = null;
        try {
            lista = controladorCliente.consultar(txtNomeFantasia.getText(), txtRazaoSocial.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UIConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] columnNames = {"Id",
            "CNPJ",
            "Razão Social",
            "Nome Fantasia"};
        Object[][] data = null;
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);

        int n = lista.size();
        for(int i=0; i<n; i++){
            Object[] linha = {lista.get(i).getId().toString(),
                lista.get(i).getCnpj(),
                lista.get(i).getRazaoSocial(),
                lista.get(i).getNomeFantasia()};
            dtm.addRow(linha);
        }

        tblCliente.setModel(dtm);
    }//GEN-LAST:event_txtRazaoSocialKeyReleased

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
            java.util.logging.Logger.getLogger(UIConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIConsultarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtRazaoSocial;
    // End of variables declaration//GEN-END:variables
}