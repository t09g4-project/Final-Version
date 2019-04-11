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

    public static class Food {
        public static Color color = Color.GREEN;
        public static final int score = 1;
        public static String image = Configure.ImageRootPath + "1score.png";
    }

    public static class Bonus {
    	public static Color color = Color.BLUE;
    	public static final int score = 2;
        public static String image = Configure.ImageRootPath + "2score.png";
    }

    public static class SnakeBody {
        public static Color color = Color.ORANGE;
        public static Color color2 = Color.CYAN;
        public static String head = Configure.ImageRootPath + "head.png";
        public static String head2 = Configure.ImageRootPath + "head2.png";
        public static String image1 = Configure.ImageRootPath + "p1body.png";
        public static String image2 = Configure.ImageRootPath + "p2body.png";
    }

    public static class Poison {
        public static Color color = Color.RED;
        public static final int score = -1;
        public static String image = Configure.ImageRootPath + "posion.png";
    }

    public static class Wall {
        public static Color color = Color.BLACK;
        public static final int num = 20;
        public static String image = Configure.ImageRootPath + "rock.png";
    }

    public static class Element {
        public static final int ElementWidth = 20;
    }

    public static class Board {
        public static final int XNum = 40; // number of rows in the game
        public static final int YNum = 20; // number of columns in the game
        public static final int INTERVAL = 500;
    }

    public static class Snake {
        public static final String CODE_A = "a";
        public static final String CODE_B = "b";
    }

    public static class Theme {
        public static final Color BACKGROUND_COLOR = Color.ORANGE;
        public static final Color BTN_COLOR = Color.magenta;
    }
}
