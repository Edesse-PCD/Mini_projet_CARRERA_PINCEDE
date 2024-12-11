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
      GrilleDeJeu  grille = new GrilleDeJeu(10,10,2);
      grille.placerBombesAleatoirement();
      nbvies = 3;
      
      
    }
    
    public  void tourDeJeu(int nbLignes, int nbColonnes){
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Veuillez entrer les coordonnées en x de la case à révéler : ");
        int x = scanner.nextInt();
        System.out.print("Veuillez entrer les coordonnées en y de la case à révéler : ");
        int y = scanner.nextInt();
        grille.cellAtCoord(x,y).revelerCellule();
        if (grille.getPresenceBombe(x,y)) nbvies-=1;
        
        
       
    }
    public void verifierVictoire(){
    if (grille.toutesCellulesRevelees()) System.out.println("Victoire!");
    
}
    public void demarrerPartie(int nbLignes,int nbColonnes, int nbBombes){ 
    GrilleDeJeu grille = new GrilleDeJeu(nbLignes,nbColonnes,nbBombes);
    while (!verifierVictoire()){
        tourDeJeu(nbLignes, nbColonnes);
    }
    
        
    }
}
