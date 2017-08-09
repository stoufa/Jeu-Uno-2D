package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import main.common.Config;
import main.common.Debug;
import main.io.Audio;
import main.states.GameOverState;
import main.states.GameState;

/**
 * @author Stoufa
 * Classe principale, o� se trouve le point d'entr�e du programme ( fonction main )
 */
public class Game extends StateBasedGame {
    /**
     * Dimensions de la fen�tre du jeu
     */
    public static int    WIDTH, HEIGHT;
    /**
     * Titre de la fen�tre du jeu
     */
    public static String TITLE;

    /**
     * Constructeur
     * @param title	titre de la fen�tre du jeu
     */
    public Game( String title ) {
        super( title );
    }

    /**
     * Fonction main, point d'entr�e du programme
     * @throws SlickException Exception offerte par la librairie Slick2D
     */
    public static void main( String[] args ) throws SlickException {
        Config.load(); // Chargement du param�trage du jeu ( du fichier .ini )

        WIDTH = Integer.parseInt( Config.get( "largeur" ) );
        HEIGHT = Integer.parseInt( Config.get( "longueur" ) );
        Audio.musicEnabled = Boolean.parseBoolean( Config.get( "jouerMusique" ) );
        Audio.soundEnabled = Boolean.parseBoolean( Config.get( "jouerSons" ) );

        Audio.load(); // Chargement des sons
        //WIDTH = Integer.parseInt(Config.get("width"));
        //HEIGHT = WIDTH * 9 / 16;	// 16/9 format, w = 16/9 h
        //HEIGHT = WIDTH;	// fen�tre carr�e

        TITLE = Config.get( "title" );

        AppGameContainer app = new AppGameContainer( new Game( TITLE ) );
        app.setDisplayMode( WIDTH, HEIGHT, false ); // largeur=WIDTH, longueur=HEIGHT, plein-�cran?=non
        Debug.log( "WIDTH = " + WIDTH + ", HEIGHT = " + HEIGHT );
        app.setShowFPS( false ); // cacher l'FPS ( affich� par d�faut par slick2d )
        app.setTargetFrameRate( 60 ); // 60 FPS ( fixation de l'FPS : Frames Per Second )		
        app.start(); // afficher la fen�tre
    }

    @Override
    /**
     * initialiser la liste des �tats du jeu
     */
    public void initStatesList( GameContainer gc ) throws SlickException {
        //this.addState(new MenuState(0));	// le premier �tat ( State ) est le premier � �tre affich�
        this.addState( new GameState( 1 ) );
        this.addState( new GameOverState( 2 ) );
    }

}
