/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_projet_carrera_pincede;

/**
 *
 * @author Edess
 */
public class Cellule {
    
    private boolean presenceBombe;
    private boolean devoilee;
    private int nbBombesAdjacentes;


    public boolean isPresenceBombe() {
        return presenceBombe;
    }

    public int getNbBombesAdjacentes() {
        return nbBombesAdjacentes;
    }

    public void setNbBombesAdjacentes(int nbBombesAdjacentes) {
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }
    
    
    public  void placerBombe(){
        presenceBombe=true;
        
    }
    
    public  boolean revelerCellule(){
        devoilee=true;
        return(devoilee);
       
    }
    

    @Override
    public String toString() {
        if (revelerCellule()==false){
            return("?");
        }
             if (revelerCellule() && presenceBombe ==true){
            return("B");
             }
             
            if (revelerCellule() && presenceBombe ==false && nbBombesAdjacentes>0){
            for (int i =1;i<=8;i++){
                if (nbBombesAdjacentes== i){
            return("  "+i);
                }
              
            }
            }
                 if (revelerCellule() && presenceBombe ==false && nbBombesAdjacentes==0){
            for (int i =1;i<=8;i++){
                if (nbBombesAdjacentes== i){
            return("  ");
                }
                
            }
                 }
                 return("  "); //Permet d'assurer à mon programme que to string retourne quelque chose quoi qu'il arrive même si ce return ne sera pas utilisé
    }
}
                 
    
    
    