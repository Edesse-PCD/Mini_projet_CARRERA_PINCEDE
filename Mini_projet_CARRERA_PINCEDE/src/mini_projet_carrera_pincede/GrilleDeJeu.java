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
public void placerBombesAleatoirement() {
    Random random = new Random();
    int bombesPlacees = 0;

    while (bombesPlacees < nbBombes) {
        int i = random.nextInt(nbLignes);
        int j = random.nextInt(nbColonnes);

        if (!matriceCellules[i][j].presenceBombe()) {
            matriceCellules[i][j].placerBombe();
            bombesPlacees++;
        }
    }
}
}
