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
    GrilleDeJeu grille ;
    int nbvies;
    public void initialiserPartie(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le nombre de lignes souhaité : ");
        int nbLignes = scanner.nextInt();
        System.out.print("Veuillez entrer le nombre de colonnes souhaité : ");
        int nbColonnes = scanner.nextInt();
        System.out.print("Veuillez entrer le nombre de bombes souhaité : ");
        int nbBombes = scanner.nextInt();
        
      GrilleDeJeu  grille = new GrilleDeJeu(nbLignes,nbColonnes,nbBombes);
      grille.placerBombesAleatoirement();
      nbvies = 3;
      
      
    }
    
    public  void tourDeJeu(){
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Veuillez entrer les coordonnées en x de la case à révéler : ");
        int x = scanner.nextInt();
        System.out.print("Veuillez entrer les coordonnées en y de la case à révéler : ");
        int y = scanner.nextInt();
        grille.cellAtCoord(x,y).revelerCellule();
        if (grille.getPresenceBombe(x,y)) nbvies-=1;
        
        
       
    }
    public boolean verifierVictoire(){
    if (grille.toutesCellulesRevelees()) return(true);
    else return(false);
    
}
    public boolean demarrerPartie(){ 
    initialiserPartie();
    while (!verifierVictoire()){
        tourDeJeu();
    }
    System.out.println("Victoire") ;
            return(true);
        
    }
    
        
    }

