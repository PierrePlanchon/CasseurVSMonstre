package main.java.fr.univlille.model.parameters;

import main.java.fr.univlille.utils.Subject;

/**
 * 
 * Classe {@code Parameters} permettant de définir les paramètres par défaut du jeu. Tous ces paramètres pourront être changé au lancement du jeu
 * dans l'onglet paramètres.
 * 
 * @author Baptiste Bertout
 * @author Pierre Planchon
 * @author Arthur Keller
 * @author Gaspard Souliez
 * @author Mathis Decoster
 * 
 * @see AllParameters
 */
public class Parameters extends Subject{
    /**
     * Paramètre {@code labyrinthKnowledge} permettant de définir le mode de connaissance du labyrinthe.
    */
    public static AllParameters labyrinthKnowledge = AllParameters.COMPLETE_KNOWLEDGE; 

    /**
     * Paramètre {@code movement} permettant de définir le mode de mouvement du {@code Monstre}.
    */
    public static AllParameters movement = AllParameters.MOVEMENT_8_WITHOUT_PASSING_WALL;

    /**
     * Paramètre {@code maxMouvementPartialKnowledgeValue} qui définit le nombre de case maximum que le Monstre peut voir autour de lui 
    */
    public static int maxMouvementPartialKnowledgeValue = 5;

     /**
     * Paramètre {@code minMouvementPartialKnowledgeValue} qui définit le nombre de case maximum que le Monstre peut voir autour de lui 
    */
    public static int minMouvementPartialKnowledgeValue = 2;

    /**
     * Paramètre {@code mouvementPartialKnowledgeValue} qui définit le nombre de case par défaut que le Monstre peut voir autour de lui 
     * (Ce paramètre est utilisé seulement si le paramètre {@code labyrinthKnowledge} est définit sur {@code AllParameters.PARTIAL_KNOWLEDGE}).
    */
    public static int mouvementPartialKnowledgeValue = Parameters.minMouvementPartialKnowledgeValue;
    
    /**
     * Paramètre {@code maxLengthLabyrinth} définissant la taille maximale du labyrinthe.<br>
     * Respectivement 30 case de largeur et 20 case de hauteur.
     */
    public static final int[] maxLengthLabyrinth = new int[]{30,20};

    /**
     * Paramètre {@code minLengthLabyrinth} définissant la taille minimale du labyrinthe.<br>
     * Respectivement 10 case de largeur et 8 case de hauteur.
     */
    public static final int[] minLengthLabyrinth = new int[]{10,8};

    /**
     * Paramètre {@code LENGTH_LABYRINTH} qui définit la taille par défaut du labyrinthe. Ici elle est définit sur la valeur maximale.
    */
    public static int[] lengthLabyrinth = Parameters.maxLengthLabyrinth;

    /**
     * Paramètre {@code MAX_PROBABILITY_WALL} qui définit la probabilité maximal d'apparition de mûr.
     */
    public static final double MAX_PROBABILITY_WALL = 0.5;
    
    /**
     * Paramètre {@code MIN_PROBABILITY_WALL} qui définit la probabilité minimal d'apparition de mûr.
     */
    public static final double MIN_PROBABILITY_WALL = 0.15;

    /**
     * Paramètre {@code PROBABILITY_WALL} qui définit la probabilité d'apparition de mûr. Ici il est définit au maximum.
     */
    public static double probabilityForWall = Parameters.MAX_PROBABILITY_WALL;

    /**
     * Paramètre {@code choiseLaby} qui définit le choix du labyrinthe, qui peut être soit un labyrinthe prédéfinit soit un labyrinthe aléatoire. <br>
     * Ici il est définit avec un labyrinthe aléatoire.
     */
    public static AllParameters choiseLaby = AllParameters.LABYRAND;

    /**
     * Paramètre {@code pathForLabyPredef} qui définit le chemin vers un fichier contenant un labyrinthe prédéfinit sous forme de texte.
     */
    public static String pathForLabyPredef = "petitLaby.txt";

    /**
     * Paramètre {@code zoneForSpawnAroundExit} qui définit le rayon autour de la position courante du monstre permettant de définir la zone qui va être affichée.
     */
    public static int zoneForSpawnAroundExit = 10;

    /**
     * Paramètre {@code gameMode} qui définit le mode de jeu. <br>
     * Ici le mode de jeu est définit sur {@code BOTH_PLAYER}. C'est à dire que les deux entités seront joués par deux humains.
     */
    public static AllParameters gameMode = AllParameters.BOTH_PLAYER;

    private int height;
    private int width;
    private int partialKnowledgeValue;
    private double proba;
    private int monster;
    private int hunter;

    /**
     * Constructeur de la classe {@link Parameters} permettant d'intancier les attributs pouvants être mis à jour par les joueurs.
     */
    public Parameters(){
        this.width = Parameters.lengthLabyrinth[0];
        this.height = Parameters.lengthLabyrinth[1];
        this.partialKnowledgeValue = Parameters.mouvementPartialKnowledgeValue;
        this.proba = Parameters.probabilityForWall;
        this.monster = 0;
        this.hunter = 0;
    }

    /**
     * Méthode {@code setHeight()} permettant de fixer une nouvelle hauteur (ou nombres de lignes).
     * 
     * @param height Ce paramètre représente la nouvelle hauteur du labyrinthe ( ou nombre de lignes ).
     */
    public void setHeight(int height){
        this.height = height;
        notifyObservers();
    }
    /**
     * Méthode {@code setWidth()} permettant de fixer une nouvelle largeur (ou nombres de colonnes).
     * 
     * @param width Ce paramètre représente la nouvelle largeur du labyrinthe (ou nombres de colonnes).
     */
    public void setWidth(int width){
        this.width = width;
        notifyObservers();
    }

    /**
     * Méthode {@code getHeight()} permettant de récupérer la hauteur du labyrinthe.
     * 
     * @return Cette méthode retourne la hauteur du labyrinthe.
     */
    public int getHeight(){
        return height;
    }

    /**
     * Méthode {@code getWidth()} permettant de récupérer la largeur du labyrinthe.
     * 
     * @return Cette méthode retourne la largeur du labyrinthe.
     */
    public int getWidth(){
        return width;
    }

    /**
     * Méthode {@code incrementHeight()} permettant d'incrémenter la hauteur de 1.
     */
    public void incrementHeight(){
        setHeight(height+1);
    }

    /**
     * Méthode {@code decrementHeight()} permettant de décrémenter la hauteur de 1.
     */
    public void decrementHeight(){
        setHeight(height-1);
    }

    /**
     * Méthode {@code incrementWidth()} permettant d'incrémenter la largeur de 1.
     */
    public void incrementWidth(){
        setWidth(width+1);
    }

    /**
     * Méthode {@code decrementWidth()} permettant de décrémenter la largeur de 1.
     */
    public void decrementWidth(){
        setWidth(width-1);
    }

    /**
     * Methode {@code movementEightWithPassingWall()} permettant de changer le paramètre du mouvement et de le passer en mouvement en 8 avec 
     * la possibilité de passer les murs en diagonale.
     */
    public void movementEightWithPassingWall(){
        Parameters.movement = AllParameters.MOVEMENT_8_WITH_PASSING_WALL;
    }

    /**
     * Methode {@code movementEightWithoutPassingWall()} permettant de changer le paramètre du mouvement et de le passer en mouvement en 8 sans 
     * la possibilité de passer les murs en diagonale
     */
    public void movementEightWithoutPassingWall(){
        Parameters.movement = AllParameters.MOVEMENT_8_WITHOUT_PASSING_WALL;
    }

    /**
     * Methode {@code movementFour()} permettant de changer le paramètre du mouvement et de le passer en mouvement en 4.
     */
    public void movementFour(){
        Parameters.movement = AllParameters.MOVEMENT_4;
    }

    /**
     * Methode {@code knowledgeComplete()} permettant de changer le paramètre de la connaissance du labyrinthe et de le passer en connaissance complète.
     */
    public void knowledgeComplete(){
        Parameters.labyrinthKnowledge = AllParameters.COMPLETE_KNOWLEDGE;
    }

    /**
     * Methode {@code knowledgePartial()} permettant de changer le paramètre de la connaissance du labyrinthe et de le passer en connaissance partielle.
     */
    public void knowledgePartial(){
        Parameters.labyrinthKnowledge = AllParameters.PARTIAL_KNOWLEDGE;
    }

    /**
     * Méthode {@code getValue()} permettant de récupérer la valeur qui determine la zone de connaissance autour de la position du monstre lorsque 
     * le paramètre de connaissance partiel est choisit.
     * 
     * @return Cette méthode retourne la largeur du labyrinthe.
     */
    public int getPartialKnowledgeValue(){
        return this.partialKnowledgeValue;
    }
    
    /**
     * Méthode {@code incrementValue()} permettant d'incrémenter le rayon de la zone de connaissance de 1.
     */
    public void incrementValue(){
        setPartialKnowledgeValue(partialKnowledgeValue+1);
    }
    
    /**
     * Méthode {@code decrementValue()} permettant de décrémenter le rayon de la zone de connaissance de 1.
     */
    public void decrementValue(){
        setPartialKnowledgeValue(partialKnowledgeValue-1);
    }
    
    /**
     * Méthode {@code setValue(int)} permettant de fixer le paramètre value.
     * 
     * @param value Ce paramètre représente la nouvelle valeur pour la connaissance partielle.
     */
    public void setPartialKnowledgeValue(int value){
        this.partialKnowledgeValue=value;
    }

    /**
     * Méthode {@code labyRandom()} qui permet de définir le choix du labyrinthe sur aléatoire.
     */
    public void labyRandom(){
        Parameters.choiseLaby = AllParameters.LABYRAND;
    }

    /**
     * Méthode {@code setLabyPredef(String)} qui permet de définir le choix du labyrinthe avec comme paramètre un des 3 labyrinthe prédéfinit.
     * 
     * @param labyPredef Ce paramètre représente l'un des 3 labyrinthes prédéfinit.
     */
    public void setLabyPredef(String labyPredef){
        Parameters.choiseLaby = AllParameters.LABYPREDEF;
        Parameters.pathForLabyPredef = labyPredef;
    }

    /**
     * Méthode {@code setPlayModeMonster(int)} qui permet de définir le mode de jeu pour le Monstre.
     * 
     * @param choice Ce paramètre représente le choix du mode de jeu : 0 pour {@code PLAYER}, 1 pour {@code IA}
     */
    public void setPlayModeMonster(int choice){
        this.monster = choice;
        this.setBothPlayer();
    }

    /**
     * Méthode {@code setPlayModeHunter(int)} qui permet de définir le mode de jeu pour le Chasseur.
     * 
     * @param choice Ce paramètre représente le choix du mode de jeu : 0 pour {@code PLAYER}, 1 pour {@code IA}
     */
    public void setPlayModeHunter(int choice){
        this.hunter = choice;
        this.setBothPlayer();
    }

    /**
     * Méthode {@code setBothPlayer()} permet de définir le paramètre de mode de jeu.
     */
    private void setBothPlayer(){
        if(this.monster == 0 && this.hunter == 0) gameMode = AllParameters.BOTH_PLAYER;
        else if(this.monster == 1 && this.hunter == 1) gameMode = AllParameters.BOTH_AI;
        else if(this.monster == 1 && this.hunter == 0) gameMode = AllParameters.MONSTER_AI_ONLY;
        else gameMode = AllParameters.HUNTER_AI_ONLY;
    }

    /**
     * Méthode {@code getProba()} qui permet d'obtenir la probabilité d'apparition des mûrs.
     * 
     * @return Cette méthode retourne la probabilité d'apparition des mûrs.
     */
    public double getProba(){
        return this.proba;
    }

    /**
     * Méthode {@code setProba(double)} permettant de définir la probabilité d'apparition des mûrs.
     * 
     * @param proba Ce paramètre représente la probabilité d'apparition des mûrs.
     */
    public void setProba(double proba){
        this.proba = proba;
    }

    /**
     * Méthode {@code incrementProbaLittle()} qui permet d'incrémenter la probabilité d'apparition des mûrs de 0.01.
     */
    public void incrementProbaLittle(){
        this.proba += 0.01;
        this.round();
    }

    /**
     * Méthode {@code incrementProbaLittle()} qui permet de décrémenter la probabilité d'apparition des mûrs de 0.01.
     */
    public void decrementProbaLittle(){
        this.proba -= 0.01;
        this.round();
    }

    /**
     * Méthode {@code incrementProbaLittle()} qui permet d'incrémenter la probabilité d'apparition des mûrs de 0.05.
     */
    public void incrementProbaMid(){
        this.proba += 0.05;
        this.round();
    }

    /**
     * Méthode {@code incrementProbaLittle()} qui permet de décrémenter la probabilité d'apparition des mûrs de 0.05.
     */
    public void decrementProbaMid(){
        this.proba -= 0.05;
        this.round();
    }

    /**
     * Méthode {@code incrementProbaLittle()} qui permet d'incrémenter la probabilité d'apparition des mûrs de 0.1.
     */
    public void incrementProbaBig(){
        this.proba += 0.1;
        this.round();
    }

    /**
     * Méthode {@code incrementProbaLittle()} qui permet de décrémenter la probabilité d'apparition des mûrs de 0.1.
     */
    public void decrementProbaBig(){
        this.proba -= 0.1;
        this.round();
    }

    /**
     * Méthode privée {@code round()} permettant d'arrondir la probabilité.
     */
    private void round(){
        this.proba = Math.round((this.proba*100.0))/100.0;
    }

    /**
     * Méthode {@code setZoneSpawn()} permettant de définir la zone autour de la sortie dans laquelle le Monstre ne peut pas apparaitre 
     * La zone est calculée à partir d'un rayon (calculé à partir de la taille du labyrinthe).
     */
    public static void setZoneForSpanwn(){
        int min = Parameters.lengthLabyrinth[0] < Parameters.lengthLabyrinth[1] ? Parameters.lengthLabyrinth[0] : Parameters.lengthLabyrinth[1];

        Parameters.zoneForSpawnAroundExit = min / 2;
    }

    /**
     * Méthode {@code updateParameters()} permettant de mettre à jour les paramètres..
     */
    public void updateParameters(){
        Parameters.lengthLabyrinth = new int[]{this.width, this.height};
        Parameters.mouvementPartialKnowledgeValue=this.partialKnowledgeValue;
        Parameters.probabilityForWall = proba;
    }
}
