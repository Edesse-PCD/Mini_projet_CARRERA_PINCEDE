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

    // Constructeur par défaut sans arguments qui va appaeler intialiser partie 
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
    this.nbVies = scanner.nextInt();

        // Initialisation de la grille avec les paramètres saisis
        grille = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes);
        grille.placerBombesAleatoirement(nbBombes); 
        grille.calculerBombesAdjacentes();

}
      
      
    
    
    public  boolean  tourDeJeu(){ //je crée une méthode boolean pour qu'elle renvoie quand le joueur n'a plus de vie 
         Scanner scanner = new Scanner(System.in);
         System.out.println(grille); // j'affiche ma grille 
        
        System.out.print("Quel est le numéro de colonne de la case que vous souhaitez révéler? : ");
        int x = scanner.nextInt();
        System.out.print("Quel est le numéro de ligne de la case que vous souhaitez révéler? : ");
        int y = scanner.nextInt();
        grille.cellAtCoord(x,y).revelerCellule();
        if (grille.getPresenceBombe(x,y)) nbVies-=1; // si il y a une bombe le joueur perd une vie 
        
        if (nbVies <= 0) {
            
                    return false ; //Le joueur a perdu donc la méthode renvoie false, ça va nous servier pour la méthode demarrerPartie().
                            } else{ return(true);
       
            
       
    }
    }
    public boolean verifierVictoire(){
    if (grille.toutesCellulesRevelees()) return(true);
    else return(false);
    
}
    public void demarrerPartie(){ 
  
    while (!verifierVictoire()){
       if (tourDeJeu()){ //là je teste qu'il reste des vies et tourDeJeu() s'exécute.
        
       } else{
           System.out.println("Vous avez perdu... \nVoulez vous rejouer ? \nTapez 1 pour oui, 2 pour non"); //Ici, il n'a plus de vies.
             Scanner scanner = new Scanner(System.in); //là je vais  donner la possibilité au joueur de relancer la partie 
             int rejouer = scanner.nextInt();
             if (rejouer==1){ //si il dit oui alors la partie se relance ; on en crée une nouvelle 
              Partie partie = new Partie();
               partie.demarrerPartie();
               return;
             } else { System.out.println("A bientôt!"); //Sinon, on affiche à bientôt
           }
           
        
    }
    System.out.println("Victoire") ;      
 }
    
    }
}

