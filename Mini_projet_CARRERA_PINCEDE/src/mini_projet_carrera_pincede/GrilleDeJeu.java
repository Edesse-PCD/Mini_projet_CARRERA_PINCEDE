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
        
for (int i=0;i<nbLignes;i++){   
for (int j=0;j<nbColonnes;j++){
    matriceCellules[i][j]= new Cellule();
}
}
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
    
    
    
    public void calculerBombesAdjacentes() {
    for (int i = 0; i < nbLignes; i++) {  // Remplacer -2 par nbLignes pour inclure toutes les lignes
        for (int j = 0; j < nbColonnes; j++) {  // Remplacer -2 par nbColonnes pour inclure toutes les colonnes
            if (!matriceCellules[i][j].isPresenceBombe()) {  // Vérifier si la cellule n'est pas une bombe
                if (i > 0 && j > 0 && matriceCellules[i-1][j-1].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (i > 0 && matriceCellules[i-1][j].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (i > 0 && j < nbColonnes - 1 && matriceCellules[i-1][j+1].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (j > 0 && matriceCellules[i][j-1].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (j < nbColonnes - 1 && matriceCellules[i][j+1].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (i < nbLignes - 1 && j > 0 && matriceCellules[i+1][j-1].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (i < nbLignes - 1 && matriceCellules[i+1][j].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                if (i < nbLignes - 1 && j < nbColonnes - 1 && matriceCellules[i+1][j+1].isPresenceBombe()) matriceCellules[i][j].IncrementerNbBombesAdj(i,j);
                
            }
        }
    }
    }
    
public void placerBombesAleatoirement(int nbBombes){
    Random random = new Random();
 
     for (int k =0; k <nbBombes;k++){

    int i = random.nextInt(nbLignes);
    int  j = random.nextInt(nbColonnes);
    while (matriceCellules[i][j].isPresenceBombe()){
    i = random.nextInt(nbLignes);
    j = random.nextInt(nbColonnes);
    }
   matriceCellules[i][j].placerBombe();
    }


}
public void revelerCellule(int ligne, int colonne) {
    for (int i = ligne - 1; i <= ligne + 1; i++) {
        for (int j = colonne - 1; j <= colonne + 1; j++) {
            // Vérification pour s'assurer que i et j sont dans les limites de la matrice
            if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes) {
                if (!matriceCellules[i][j].isPresenceBombe() && matriceCellules[i][j].getNbBombesAdjacentes() == 0) {
                    matriceCellules[i][j].revelerCellule();
                }
            }
        }
    }

    // Révéler la cellule cible si elle n'est pas une bombe
    if (!cellAtCoord(ligne, colonne).revelerCellule() && cellAtCoord(ligne, colonne).isPresenceBombe()) {
        System.out.println("Erreur : Bombe détectée !");
    } else {
        cellAtCoord(ligne, colonne).revelerCellule();
    }
}

    
    
    
    

       

public boolean getPresenceBombe(int i, int j) {
if (cellAtCoord(i,j).isPresenceBombe()) return(true);
else return(false);
}


public boolean toutesCellulesRevelees() {
    // Vérifie si toutes les cellules non-bombe sont révélées
    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            // Si une cellule non-bombe n'est pas révélée, retourne false
            if (!cellAtCoord(i, j).isPresenceBombe() && !cellAtCoord(i, j).estDevoilee()) {
                return false;
            }
        }
    }

    return true;
}


 

    

   @Override
public String toString() {
    for (int i = 0; i < nbLignes; i++) {
        System.out.print("|");  // Ajout du premier séparateur avant chaque ligne
        for (int j = 0; j < nbColonnes; j++) {  // Utilisation de nbColonnes, pas nbLignes
            System.out.print(cellAtCoord(i, j).toString() + " | ");  // Affichage du contenu de chaque cellule avec un séparateur
        }
        System.out.println();  // Ajoute une nouvelle ligne après chaque ligne de la grille
    }
    return "";  // Retourne une chaîne vide si nécessaire
}

}

    

  
        

