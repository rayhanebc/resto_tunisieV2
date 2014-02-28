/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.gui;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class MDIparent extends javax.swing.JFrame {

    /**
     * Creates new form MDIparent
     */
    public MDIparent() {
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

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuExit = new javax.swing.JMenuItem();
        MenuRestau = new javax.swing.JMenu();
        ItemRestaurant = new javax.swing.JMenuItem();
        MenuClient = new javax.swing.JMenu();
        ItemClient = new javax.swing.JMenuItem();
        MenuCommentaire = new javax.swing.JMenu();
        ItemCommentaire = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuFile.setText("File");

        MenuExit.setText("Exit");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        MenuFile.add(MenuExit);

        jMenuBar1.add(MenuFile);

        MenuRestau.setText("Restaurants partenaires");

        ItemRestaurant.setText("Restaurants");
        ItemRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRestaurantActionPerformed(evt);
            }
        });
        MenuRestau.add(ItemRestaurant);

        jMenuBar1.add(MenuRestau);

        MenuClient.setText("Nos clients");
        MenuClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientActionPerformed(evt);
            }
        });

        ItemClient.setText("Client");
        ItemClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemClientActionPerformed(evt);
            }
        });
        MenuClient.add(ItemClient);

        jMenuBar1.add(MenuClient);

        MenuCommentaire.setText("Commentaire");
        MenuCommentaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCommentaireActionPerformed(evt);
            }
        });

        ItemCommentaire.setText("Commentaire");
        ItemCommentaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCommentaireActionPerformed(evt);
            }
        });
        MenuCommentaire.add(ItemCommentaire);

        jMenuBar1.add(MenuCommentaire);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez vous Quitter?","Warning",dialogButton);
        if(dialogResult==JOptionPane.YES_OPTION)
             System.exit(0);
    }//GEN-LAST:event_MenuExitActionPerformed

    private void MenuClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuClientActionPerformed

    private void ItemClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemClientActionPerformed
        // TODO add your handling code here:
        GestionClient gestionClient = new GestionClient();
        desktop.add(gestionClient);
        gestionClient.setVisible(true);
        try {
            gestionClient.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MDIparent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ItemClientActionPerformed

    private void MenuCommentaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCommentaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuCommentaireActionPerformed

    private void ItemCommentaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCommentaireActionPerformed
        // TODO add your handling code here:
        GestionCommentaire gestionCommentaire = new GestionCommentaire();
        desktop.add(gestionCommentaire);
        gestionCommentaire.setVisible(true);
        try {
            gestionCommentaire.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MDIparent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ItemCommentaireActionPerformed

    private void ItemRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRestaurantActionPerformed
        // TODO add your handling code here:
        
        GestionResto resto = new GestionResto();
        desktop.add(resto);
        resto.setVisible(true);
        try {
            resto.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MDIparent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ItemRestaurantActionPerformed

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
            java.util.logging.Logger.getLogger(MDIparent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIparent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIparent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIparent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIparent().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemClient;
    private javax.swing.JMenuItem ItemCommentaire;
    private javax.swing.JMenuItem ItemRestaurant;
    private javax.swing.JMenu MenuClient;
    private javax.swing.JMenu MenuCommentaire;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuRestau;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}