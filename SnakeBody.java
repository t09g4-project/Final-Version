/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

/**
 * This class is responsible for the elements of the Snake's body.
 */
public class SnakeBody extends Element {

    /**
     * Constructor that will set up the coordinates, the image path and the Eatable boolean.
     * @param x (Type int - the x coordinate of the snake)
     * @param y (Type int - the y coordinate of the snake)
     * @param imagePath (type String) Sets up the image path of the snake.
     */
    public SnakeBody(int x, int y, String imagePath) {
        super(x, y);
        this.setImagePath(imagePath);
        this.setEatable(false);
    }

    /**
     * Constructor that only sets up the image path and sets up the Eatable boolean to false.
     * @param imagePath (type String) The image path of the snake.
     */
    public SnakeBody(String imagePath) {
        this.setImagePath(imagePath);
        this.setEatable(false);
    }
}
