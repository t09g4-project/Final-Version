/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import java.awt.*;

/**
 * This class will be responble for the various elements of an object. Such as the score of a certain object, the color,
 * the boolean to determine if it is eatable, and the image path of image file.
 */
public class Element extends Coordinate {
    private int score;
    private Color color;
    private boolean isEatable;
    private String imagePath;

    
    
    /**
     * Constructor that will set the X and Y coordinates of the object
     * @param x (type int - The X coordinate of the object)
     * @param y (type int - The Y coordinate of the object)
     */
    public Element(int x, int y) {
        super(x, y);
    }

    
    
    /**
     * Default constructor
     */
    public Element(){}

    
    
    /**
     * This is a getter method that gets the score of the object.
     * @return score (type int - the score of the object)
     */
    public int getScore() {
        return score;
    }

    
    
    /**
     * This method gets the color of the object.
     * @return color (type Color - the color of the object)
     */
    public Color getColor() {
        return color;
    }

    
    
    /**
     * Method that sets the score of the object
     * @param score (type int - the score of the object)
     */
    public void setScore(int score) {
        this.score = score;
    }

    
    
    /**
     * Method sets the color of the object
     * @param color (Type Color - color you want the object to be)
     */
    public void setColor(Color color) {
        this.color = color;
    }

    
    
    /**
     * This method gets the status if the object is eatable.
     * @return isEatable (type boolean)
     */
    public boolean isEatable() {
        return isEatable;
    }

    
    
    /**
     * This method is a setter method that sets the object's eatable status.
     * @param eatable (type boolean) True if eatable, false if not eatable.
     */
    public void setEatable(boolean eatable) {
        isEatable = eatable;
    }

    
    
    /**
     * This getter method that gets the imagepath of the object.
     * @return imagePath (type String) - This is going to be the path of where the image file is located
     */
    public String getImagePath() {
        return imagePath;
    }

    
    
    /**
     * This setter method that will set the image path.
     * @param imagePath (type String - Where the image path file will be located)
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
