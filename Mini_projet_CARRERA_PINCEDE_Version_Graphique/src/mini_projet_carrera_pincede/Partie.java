/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_projet_carrera_pincede;


/**
 *
 * @author Edess
 */
public class Partie {
    GrilleDeJeu grille ;
    int nbCoups;
    public void initialiserPartie(){
      GrilleDeJeu  grille = new GrilleDeJeu(10,10);
      grille.placerBombesAleatoirement();
      
    }
    
}