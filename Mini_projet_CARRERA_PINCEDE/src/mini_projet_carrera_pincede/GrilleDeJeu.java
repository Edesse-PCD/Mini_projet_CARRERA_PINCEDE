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

public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.nbBombes = nbBombes;
    this.matriceCellules = new Cellule[nbLignes][nbColonnes];
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
        if (matriceCellules[i-1][j-1].isPresenceBombe()) setnbBombesAdjacentes+=1;       
    }
}

}
}