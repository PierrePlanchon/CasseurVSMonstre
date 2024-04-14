package main.java.fr.univlille.utils;

/**
 * Interface {@code Observer} permettant de définir les observeurs, et de définir les méthodes permettant de mettre à jours leurs propres données.
 * 
 * @author Baptiste Bertout
 * @author Pierre Planchon
 * @author Arthur Keller
 * @author Gaspard Souliez
 * @author Mathis Decoster
 * 
 * @see Subject
 */
public interface Observer {
        /**
         * Méthode {@code update(Subject)} permettant de mettre à jour les données de l'objet courant en fonction du sujet donnée en paramètre.
         * 
         * @param subj Ce paramètre représente le sujet qui notifie l'observeur d'un changement de donnée.
         */
        public void update(Subject subj);

        /**
         * Méthode {@code update(Subject, Object)} permettant de mettre à jour les données de l'objet courant en fonction du sujet donnée en paramètre et avec la nouvelle donnée.
         * 
         * @param subj Ce paramètre représente le sujet qui notifie l'observeur d'un changement de donnée.
         * @param data Ce paramètre représente la nouvelle donnée à utiliser.
         */
        public void update(Subject subj, Object data);
}
