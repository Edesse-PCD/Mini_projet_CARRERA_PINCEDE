package mini_projet_carrera_pincede;
 

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Valentin
 */

/**
 * Classe FenetrePrincipale pour afficher la grille du jeu.
 * 
 * @author Valentin
 */
public final class FenetrePrincipale extends javax.swing.JFrame {
    public GrilleDeJeu grilleDeJeu;
    public JPanel panneauGrille;
    
    public FenetrePrincipale() {
        initComponents();
        this.grilleDeJeu = new GrilleDeJeu(10, 10, 15);
        grilleDeJeu.placerBombesAleatoirement(15);
        grilleDeJeu.calculerBombesAdjacentes(); 
        creerGrilleGraphique();  
    }

    public void creerGrilleGraphique() {
        // Initialisation du panneau contenant la grille
        panneauGrille.setLayout(new GridLayout(10, 10));
        
        for (int i = 0; i < grilleDeJeu.getNbLignes(); i++) {
            for (int j = 0; j < grilleDeJeu.getNbColonnes(); j++) {
                Cellule cell = grilleDeJeu.cellAtCoord(i, j);
                
                JButton boutonCellule = new JButton();
                
                boutonCellule.setText(cell.isPresenceBombe() ? "B" : String.valueOf(cell.getNbBombesAdjacentes()));
              
                boutonCellule.addActionListener(e -> {
                    if (cell.isPresenceBombe()) {
                        boutonCellule.setText("BOOM!");
                        JOptionPane.showMessageDialog(this, "Vous avez cliqué sur une bombe !", "Perdu", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    } else {
                        boutonCellule.setEnabled(false);
                        boutonCellule.setText(String.valueOf(cell.getNbBombesAdjacentes()));
                    }
                });
                
                panneauGrille.add(boutonCellule);
            }
        }
        this.add(panneauGrille);
        this.pack();
        this.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(51, 255, 102));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 480, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    // End of variables declaration//GEN-END:variables
}
