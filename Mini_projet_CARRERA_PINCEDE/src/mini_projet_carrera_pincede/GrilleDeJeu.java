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
}
