package main.java.fr.univlille.view.gameview.allview.iaview;

import main.java.fr.univlille.view.gameview.AllViewEnum;

/**
 * 
 * Classe {@code IAHunterView} permettant un affichage lorsque l'IA du Chasseur est en train de jouer.
 * 
 * @author Baptiste Bertout
 * @author Pierre Planchon
 * @author Arthur Keller
 * @author Gaspard Souliez
 * @author Mathis Decoster
 * 
 * Voir <a href="https://docs.oracle.com/javafx/2/api/">JavaFx</a> pour trouver la documentation lié à JavaFx.
 * 
 * @see IAView
 */
public class IAHunterView extends IAView{

    /**
     * Constructeur principale de la classe {@code IAHunterView} permettant de créer l'affichage.
     */
    public IAHunterView(){
        this.title = "Tour du chasseur IA";
        this.text = "Le Chasseur a joué, à votre tour.";
        this.view = AllViewEnum.HUNTERVIEW;
        this.start();
    }
}
