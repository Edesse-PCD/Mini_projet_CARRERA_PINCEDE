/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_projet_carrera_pincede;

/**
 *
 * @author valen
 */
public class MatriceCellules {
    public Cellule[][] grilleCellules;
    int nbLignes;
    int nbColonnes;

    public MatriceCellules(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.grilleCellules = new Cellule[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grilleCellules[i][j] = new Cellule();
            }
        }
    }
    
    public void afficherMatrice() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                System.out.print(grilleCellules[i][j] + " ");
            }
            System.out.println();
        }
    }
}
