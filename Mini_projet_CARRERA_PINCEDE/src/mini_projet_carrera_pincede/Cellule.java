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
    private boolean devoilee = false;
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
    
    public boolean estDevoilee(){
       return(devoilee);
       
       
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
        if (estDevoilee()==false){
            return("?");
        }
             if (estDevoilee() && presenceBombe ==true){
            return("B");
             }
             
            if (estDevoilee() && presenceBombe ==false && nbBombesAdjacentes>0){
            for (int i =1;i<=8;i++){
                if (nbBombesAdjacentes== i){
            return("  "+i);
                }
              
            }
                 if (estDevoilee() && presenceBombe ==false && nbBombesAdjacentes==0){
            for (int i =1;i<=8;i++){
                if (nbBombesAdjacentes== i){
            return("  ");
                }
                
        }
        }
    
        }
            return("  ");
    }
     

    
         public void IncrementerNbBombesAdj(int i,int j){
       nbBombesAdjacentes+=1;
       }

 


    

}
     
        
    

             
        
    


   
