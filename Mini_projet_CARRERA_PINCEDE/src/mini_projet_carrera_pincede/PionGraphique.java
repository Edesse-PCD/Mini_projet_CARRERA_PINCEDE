/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_projet_carrera_pincede;

/**
 *
 * @author Edess
 */
public class PionGraphique extends Jbutton{
    int x;
    int y;
    Cellule celluleAssociee;


    public PionGraphique(int x, int y, Cellule celluleAssociee) {
        this.x = x;
        this.y = y;
        this.celluleAssociee = celluleAssociee;
    }
    
    
    System.out.println("Création du pion aux coordonnées "+x+","+y);
    
}




