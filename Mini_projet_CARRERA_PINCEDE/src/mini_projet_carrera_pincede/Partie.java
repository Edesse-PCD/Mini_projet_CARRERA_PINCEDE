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
    private int nbVies;

    // Constructeur par défaut sans arguments
    public Partie() {
        initialiserPartie();
    }

    // Méthode pour initialiser la partie
    public void initialiserPartie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes : ");
        int nbLignes = scanner.nextInt();

        System.out.print("Entrez le nombre de colonnes : ");
        int nbColonnes = scanner.nextInt();

        System.out.print("Entrez le nombre de bombes : ");
        int nbBombes = scanner.nextInt();
        
         System.out.print("Entrez le nombre de vies souhaitées : ");
        int nbVies = scanner.nextInt();

        // Initialisation de la grille avec les paramètres saisis
        grille = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes);
        grille.placerBombesAleatoirement(nbBombes);
        grille.calculerBombesAdjacentes();

}
      
      
    
    
    public  boolean  tourDeJeu(){ //je crée une méthode boolean pour qu'elle renvoie quand le joueur n'a plus de vie 
         Scanner scanner = new Scanner(System.in);
         System.out.println(grille);
        
        System.out.print("Veuillez entrer les coordonnées en x de la case à révéler : ");
        int x = scanner.nextInt();
        System.out.print("Veuillez entrer les coordonnées en y de la case à révéler : ");
        int y = scanner.nextInt();
        grille.cellAtCoord(x,y).revelerCellule();
        if (grille.getPresenceBombe(x,y)) nbVies-=1;
        
        if (nbVies == 0) {
            System.out.println("Vous avez perdu!");
                    return false ;
                            }
        else return(true);
            
       
    }
    public boolean verifierVictoire(){
    if (grille.toutesCellulesRevelees()) return(true);
    else return(false);
    
}
    public boolean demarrerPartie(){ 
  
    while (!verifierVictoire() && tourDeJeu()){
        
        tourDeJeu();
    }
    
    System.out.println("Victoire") ;
            return(true);
        
    }
    
        
    }

