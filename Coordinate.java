/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

/**
 * This class is responsible for the X & Y coordinates for the various objects in the game,
 * such as the types of food, the snake, posion, etc.
 */
public class Coordinate {
    private int x;
    private int y;

    
    
    
    /**
     * Constructor that will set up the X and Y coordinates of an object.
     * @param x - type int (X coordinate of the object)
     * @param y - type int (Y coordinate of the object)
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    
    
    /**
     * Default constructor
     */
    public Coordinate() {
    }

    
    
    /**
     * Getter method that gets the X coordinate of the object
     * @return x (the x coordinate of an object - Type int)
     */
    public int getX() {
        return x;
    }

    
    
    /**
     * Setter method that sets the X coordinate of the object
     * @param x (the x coordinate you want the object to be set at - type int)
     */
    public void setX(int x) {
        this.x = x;
    }

    
    
    /**
     * Getter method that gets the Y coordinate of the object
     * @return y (the y coordinate of an object - Type int)
     */
    public int getY() {
        return y;
    }

    
    
    /**
     * Setter method that sets the Y coordinate of the object
     * @param y (the y coordinate you want the object to be set at - type int)
     */
    public void setY(int y) {
        this.y = y;
    }
}
