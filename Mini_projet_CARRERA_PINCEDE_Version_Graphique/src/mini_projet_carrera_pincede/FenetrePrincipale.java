package mini_projet_carrera_pincede;

import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

public final class FenetrePrincipale extends javax.swing.JFrame {
    private GrilleDeJeu grilleDeJeu;
    private final Scanner sc = new Scanner (System.in);
    
    public FenetrePrincipale() {
        initComponents();
        int nbLignes = 10;
        int nbColonnes = 10;
        int nbBombes = 15;
        int nbVie = 1;
        
        this.grilleDeJeu = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes, nbVie);
        
        initialiserPartie();
        
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        
        for (int i=0; i< nbLignes;i++) {
            for (int j=0; j< nbColonnes; j++) {
                final int a = i;
                final int b = j;
                CelluleGraphique c = new CelluleGraphique (i,j,grilleDeJeu.matriceCellules[i][j]);
                PanneauGrille.add(c);
                
                c.addActionListener(evt -> {
                    grilleDeJeu.revelerCellule(a,b);
                    PanneauGrille.repaint();
                    
                    if(c.celluleAssociee.isPresenceBombe()) {
                        System.out.println("Vous avez cliqué sur une bombe !");
                    }
                    else {
                        System.out.println(""+ c.celluleAssociee.getNbBombesAdjacentes() + "");
                    }
                    
                    if (grilleDeJeu.getnbVie() <= 0) {
                        System.out.println("Defaite");
                        Defaite();
                    }
                    else if (grilleDeJeu.toutesCellulesRevelees()){
                        System.out.println("Victoire");
                        Victoire();
                    }
                });
                
            }
        }
    PanneauGrille.revalidate();
    PanneauGrille.repaint();
    }
    
    public void initialiserPartie() {
        grilleDeJeu.placerBombesAleatoirement(SOMEBITS);
        grilleDeJeu.calculerBombesAdjacentes();
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 490, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
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
        java.awt.EventQueue.invokeLater(() -> {
            new FenetrePrincipale().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    // End of variables declaration//GEN-END:variables
public void Defaite() {
    Defaite d = new Defaite();
    d.setVisible(true);
    dispose();
            
}
public void Victoire() {
    Victoire v = new Victoire();
    v.setVisible(true);
    dispose();
            
}}