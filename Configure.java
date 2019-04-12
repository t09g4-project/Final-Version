/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.common;

import java.awt.*;

/**
 * This class contains the configurations for this game.
 * It will contain the configurations for Food, Bonus, SnakeBody, Poison, Wall, Element, Board.
 * These configurations are responsible for the colors, images, scores, etc.
 */
public class Configure {
    public static String ImageRootPath = "MySnake/src/resources/";
    public static String IconPath = ImageRootPath + "icon.jpg";

    
    

    /**
     * Configure the Food class object.
     * Color will be Green and score value is 1.
     * Sets up the image of Food object as well.
     */
    public static class Food {
        public static Color color = Color.GREEN;
        public static final int score = 1;
        public static String image = Configure.ImageRootPath + "1score.png";
    }
    
    
    
    
     /**
     * Configure the Bonus object.
     * Color will be Blue and score value is 2.
     * Sets up the image of the Bonus object as well.
     */
    public static class Bonus {
    	public static Color color = Color.BLUE;
    	public static final int score = 2;
        public static String image = Configure.ImageRootPath + "2score.png";
    }

    
    
    /**
     * Configure the snake.
     * Depending on the snake (player one or two) it will have a color of Orange or Cyan.
     * It will set up the image of the head and body part of the snake. Player one and player two
     * will have different snake head and body images.
     */
    public static class SnakeBody {
        public static Color color = Color.ORANGE;
        public static Color color2 = Color.CYAN;
        public static String head = Configure.ImageRootPath + "head.png";
        public static String head2 = Configure.ImageRootPath + "head2.png";
        public static String image1 = Configure.ImageRootPath + "p1body.png";
        public static String image2 = Configure.ImageRootPath + "p2body.png";
    }

    
    
     /**
     * Configure the Poison object. 
     * Color set to Red and score value is -1.
     * Sets up the image of posion. 
     */
    public static class Poison {
        public static Color color = Color.RED;
        public static final int score = -1;
        public static String image = Configure.ImageRootPath + "posion.png";
    }

    
    
     /**
     * Configure the wall object.
     * Color is Black and set the image of the wall to rocks.
     */
    public static class Wall {
        public static Color color = Color.BLACK;
        public static final int num = 20;
        public static String image = Configure.ImageRootPath + "rock.png";
    }

    
    
    /**
     * Configure the size of all elements.
     */
    public static class Element {
        public static final int ElementWidth = 20;
    }

    
    
    /**
     * Configures the Board of the game. Number of rows and columns within the board. 
     * Also sets up the interval (speed) of how fast the game will be. 
     */
    public static class Board {
        public static final int XNum = 40; // number of rows in the game
        public static final int YNum = 20; // number of columns in the game
        public static final int INTERVAL = 500;
    }

    
    
    /**
     * Default Configuration for the names in two player mode.
     */
    public static class Snake {
        public static final String CODE_A = "a";
        public static final String CODE_B = "b";
    }

    
    
    /**
     * Configure the theme of the game 
     */
    public static class Theme {
        public static final Color BACKGROUND_COLOR = Color.ORANGE;
        public static final Color BTN_COLOR = Color.magenta;
    }
}
