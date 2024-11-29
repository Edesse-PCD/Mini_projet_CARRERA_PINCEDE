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
    
    
    public  boolean placerBombe(){
         presenceBombe=true;
                return(true);
        
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
                 if (revelerCellule() && presenceBombe ==false && nbBombesAdjacentes==0){
            for (int i =1;i<=8;i++){
                if (nbBombesAdjacentes== i){
            return("  ");
                }
        }
        }
        }
    
             
        
    

             
        
    


   
