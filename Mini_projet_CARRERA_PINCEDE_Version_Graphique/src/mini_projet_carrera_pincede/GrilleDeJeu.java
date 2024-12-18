package mini_projet_carrera_pincede;

import java.util.Random;
import mini_projet_carrera_pincede.Cellule;

public class GrilleDeJeu {
    private Cellule[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;

    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.matriceCellules = new Cellule[nbLignes][nbColonnes]; // Initialisation correcte de la matrice

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new Cellule(); // Initialisation de chaque cellule
            }
        }
    }
    
public Cellule[][] getMatriceCellules() {
        return matriceCellules;
    }
    public Cellule cellAtCoord(int i, int j) {
        return getMatriceCellules()[i][j];
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

    public void placerBombesAleatoirement(int nbBombes) {
        Random random = new Random();
        for (int k = 0; k < nbBombes; k++) {
            int i = random.nextInt(nbLignes);
            int j = random.nextInt(nbColonnes);
            while (matriceCellules[i][j].isPresenceBombe()) {
                i = random.nextInt(nbLignes);
                j = random.nextInt(nbColonnes);
            }
            matriceCellules[i][j].placerBombe();
        }
    }

    public void calculerBombesAdjacentes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].isPresenceBombe()) {
                    int nbBombesAdj = 0;

                    // Vérification des cellules voisines
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int ni = i + x;
                            int nj = j + y;

                            // S'assurer que les indices sont dans les limites
                            if (ni >= 0 && ni < nbLignes && nj >= 0 && nj < nbColonnes) {
                                if (matriceCellules[ni][nj].isPresenceBombe()) {
                                    nbBombesAdj++;
                                }
                            }
                        }
                    }
                    matriceCellules[i][j].setNbBombesAdjacentes(nbBombesAdj);
                }
            }
        }
    }

    public void revelerCellule(int ligne, int colonne) {
        // Vérifier si la cellule est dans les limites de la grille
        if (ligne >= 0 && ligne < nbLignes && colonne >= 0 && colonne < nbColonnes) {
            // Révéler la cellule
            matriceCellules[ligne][colonne].revelerCellule();

            // Si aucune bombe adjacente, révéler les cellules voisines
            if (matriceCellules[ligne][colonne].getNbBombesAdjacentes() == 0) {
                for (int i = ligne - 1; i <= ligne + 1; i++) {
                    for (int j = colonne - 1; j <= colonne + 1; j++) {
                        if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes && !matriceCellules[i][j].estDevoilee()) {
                            revelerCellule(i, j); // Appel récursif pour révéler les cellules voisines
                        }
                    }
                }
            }
        }
    }

    public boolean getPresenceBombe(int i, int j) {
        return cellAtCoord(i, j).isPresenceBombe();
    }

    public boolean toutesCellulesRevelees() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!cellAtCoord(i, j).estDevoilee() && !cellAtCoord(i, j).isPresenceBombe()) {
                    return false; // Si une cellule non révélée n'est pas une bombe
                }
            }
        }
        return true; // Toutes les cellules sans bombe sont révélées
        

}
 @Override
public String toString() {
    String result = "";
    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            result += "|" + matriceCellules[i][j].toString(); // Appel de toString() sur chaque cellule
        }
        result += "|\n"; // Retour à la ligne après chaque ligne
    }
    return result;
}

}


    

