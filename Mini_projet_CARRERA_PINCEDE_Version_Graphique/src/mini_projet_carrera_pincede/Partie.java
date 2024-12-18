/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_projet_carrera_pincede;

import java.util.Scanner;


/**
 *
 * @author Edess
 */
public class Partie {

    private GrilleDeJeu grille;
    public int nbVie;
    private static final Scanner scanner = new Scanner(System.in);

    public int getnbVie() {
        return nbVie;
    }

    public Partie() {
        initialiserPartie();
    }

    public void initialiserPartie() {
        System.out.print("Entrez le nombre de lignes : ");
        int nbLignes = scanner.nextInt();

        System.out.print("Entrez le nombre de colonnes : ");
        int nbColonnes = scanner.nextInt();

        System.out.print("Entrez le nombre de bombes : ");
        int nbBombes = scanner.nextInt();

        System.out.print("Entrez le nombre de vies souhaitées : ");
        this.nbVie = scanner.nextInt();

        // Initialisation de la grille avec les paramètres saisis
        grille = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes, nbVie);
        grille.placerBombesAleatoirement(nbBombes); 
        grille.calculerBombesAdjacentes();
      
    }

    public boolean tourDeJeu() {
        System.out.println(grille); // Affiche la grille

        System.out.print("Quel est le numéro de ligne de la case que vous souhaitez révéler? : ");
        int x = scanner.nextInt();
        System.out.print("Quel est le numéro de colonne de la case que vous souhaitez révéler? : ");
        int y = scanner.nextInt();

        grille.revelerCellule(x,y);

        if (grille.getPresenceBombe(x, y)) {
            nbVie = nbVie - 1; // Perte d'une vie si la case contient une bombe
        }

        return nbVie > 0; // Retourne true si le joueur a encore des vies, sinon false
    }

    public boolean verifierVictoire() {
        if (grille.toutesCellulesRevelees()) return true; 
                else return false;
    }

    public void demarrerPartie() {
        while (!verifierVictoire()) {
            if (!tourDeJeu()) {
                System.out.println("Vous avez perdu... \nVoulez vous rejouer ? \nTapez 1 pour oui, 2 pour non");
                int rejouer = scanner.nextInt();
                if (rejouer == 1) {
                    initialiserPartie(); // Relance la partie
                    return; // Sortie de la méthode pour redémarrer la partie
                } else {
                    System.out.println("A bientôt!");
                    return; // Sortie de la méthode si le joueur choisit de ne pas rejouer
                }
            }
        }
        System.out.println("Victoire");
    }
}
