package main;

import org.newdawn.slick.state.StateBasedGame;

import main.gameObjects.Jeu;

/**
 * La classe qui va contenir le code � �x�cuter par le processus / Thread lanc�e
 * du processus principale ( lancement du jeu )
 * @author Stoufa
 *
 */
public class GameRunnable implements Runnable {
    /**
     * objet repr�sentant le jeu
     */
    Jeu            jeu = null;
    /**
     * l'orchestrateur des �tats du jeu
     * avec cet objet on peut changer d'un �tat � un autre
     */
    StateBasedGame sbg = null;

    /**
     * constructeur
     * @param jeu
     * @param sbg
     */
    public GameRunnable( Jeu jeu, StateBasedGame sbg ) {
        this.jeu = jeu;
        this.sbg = sbg;
    }

    /**
     * le code � �x�cuter par le Thread
     */
    @Override
    public void run() {
        try {
            jeu.lancer( sbg ); // lancer le jeu
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
