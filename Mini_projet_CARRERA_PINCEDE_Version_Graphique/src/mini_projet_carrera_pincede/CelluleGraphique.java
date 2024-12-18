    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_projet_carrera_pincede;

import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Valentin
 */
public class CelluleGraphique extends JButton{
    int x;
    int y;
    Cellule celluleAssociee;


    public CelluleGraphique(Cellule celluleAssociee, int x, int y) {
        this.x = x;
        this.y = y;
        this.celluleAssociee = celluleAssociee;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        this.setText(celluleAssociee.toString());
    }
    
}