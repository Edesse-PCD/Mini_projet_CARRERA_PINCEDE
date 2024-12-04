/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mini_projet_carrera_pincede;

/**
 *
 * @author Edess
 */
public class Mini_projet_CARRERA_PINCEDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    GrilleDeJeu grille = new GrilleDeJeu(10,10,2);
    int ligne =1;
    int colonne=1;
    if (!grille.cellAtCoord(ligne,colonne).revelerCellule()){
        if (grille.cellAtCoord(ligne,colonne).isPresenceBombe()){
       
    
        System.out.println("Erreur");
    } else { 
            grille.cellAtCoord(ligne,colonne).revelerCellule();
 
    
        }

    }
    
    
    for(int i =1; i<=ligne;i++){
        for(int j=1;j<=colonne;j++){
            if (!grille.getPresenceBombe(i,j) && !cellAtCoord(i,j).estDevoilee()) {
                System.out.println(true);
            }
            else{
            System.out.println(false);
        }
        }
            
        }
    }
    }
