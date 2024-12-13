package mini_projet_carrera_pincede;

import java.util.Random;


/**
 *
 * @author valentin
 */

public class GrilleDeJeu {
    private Cellule[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    
        public Cellule cellAtCoord(int i,int j){
        return(getMatriceCellules()[i][j]);
        }
        

public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.nbBombes = nbBombes;
    this.matriceCellules = new Cellule[nbLignes][nbColonnes];
    }

    public Cellule[][] getMatriceCellules() {
        return matriceCellules;
    }



    public int getNbLignes() {
        return nbLignes;
    }
    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
public void placerBombesAleatoirement(){
    Random random = new Random();
     for (int k =1; k <=nbBombes;k++){

    int i = random.nextInt();
    int  j = random.nextInt();
    while (matriceCellules[i][j].isPresenceBombe()){
    i = random.nextInt();
    j = random.nextInt();
    }
   matriceCellules[i][j].placerBombe();
    }
}
public void calculerBombesAdjacentes() {
    for (int i =1;i<nbLignes-2;i++){
        for (int j=1;j<nbColonnes-2;j++)
    if (!matriceCellules[i][j].isPresenceBombe()){
        if (matriceCellules[i-1][j-1].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);  
        if (matriceCellules[i-1][j].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
        if (matriceCellules[i-1][j+1].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
        if (matriceCellules[i][j-1].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
        if (matriceCellules[i][j+1].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
        if (matriceCellules[i+1][j-1].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
        if (matriceCellules[i+1][j].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
        if (matriceCellules[i+1][j+1].isPresenceBombe())   matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
    }
}

}
public void revelerCellule(int ligne, int colonne){
    for ( int i = ligne-1;i<=ligne+1;i++){
        for (int j = colonne-1;j<=ligne+1;j++){
            if (!matriceCellules[i][j].isPresenceBombe() && matriceCellules[i][j].getNbBombesAdjacentes()==0){
        matriceCellules[i][j].revelerCellule();
        }
    }
        if (!cellAtCoord(ligne,colonne).revelerCellule() && cellAtCoord(ligne,colonne).isPresenceBombe()){
        System.out.println("Erreur");
    } else { 
            cellAtCoord(ligne,colonne).revelerCellule();
 
    
        
    }
    
    
    
    

        }
}

public boolean getPresenceBombe(int i, int j) {
if (cellAtCoord(i,j).isPresenceBombe()) return(true);
else return(false);
}


public boolean toutesCellulesRevelees(){
    boolean gagner = true;
    for(int i =1; i<=nbLignes;i++){
        for(int j=1;j<=nbColonnes;j++){
           if (cellAtCoord(i,j).revelerCellule()) gagner = true;
           else gagner = false;
        }
    }
           return(gagner);
}


            
        }
    
    


