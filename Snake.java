/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import com.game.common.Direction;

import java.awt.*;
import java.util.LinkedList;

/**
 * This class is responsible for the Snake, such as keep track of all the past position of where the snake moved,
 * the actions of the snake, the current score, next direction, snake's body color, the life status of the snake, the
 * image of the snake's body, the color of the snake.
 */
public class Snake {
    private LinkedList<SnakeBody> bodies;
    private Direction direction;
    private int score = 0;
    private boolean isAlive;
    private Color bodyColor;
    private String bodyImage;
    private String code;
    private String name;

    /**
     * This constructor sets the direction of the snake to move up at when the game starts, it sets the X & Y coordinate,
     * sets the boolean isAlive to true, and set up the body image.
     * @param x (x coordinate of the snake - type int)
     * @param y (y coordinate of the snake - type int)
     * @param bodyImage (the body image path of the snake - type String)
     */
    public Snake(int x, int y, String bodyImage) {
        this.direction = Direction.RIGHT;
        this.isAlive = true;
        this.bodyImage = bodyImage;
        initBody(x, y);
    }

    /**
     * THis method will keep track of the snake's past positions by adding the coordinates to the linked list.
     * @param x (x coordinate of the snake position - type int)
     * @param y (y coordinate of the snake position - type int)
     */
    private void initBody(int x, int y) {
        LinkedList<SnakeBody> bodies = new LinkedList<>();
        bodies.add(new SnakeBody(x, y, getBodyImage()));
        this.bodies = bodies;
    }

    /**
     * This is a getter method that gets the direction of the snake.
     * @return direction (Type Direction - the current direction of the snake)
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * This method is a setter method that sets the direction of the snake
     * @param direction (type Direction - the direction you want the snake to move)
     */
    public void setDirection(Direction direction) {
        if(this.direction != null) {
            if (this.direction == Direction.UP && direction == Direction.DOWN ||
                this.direction == Direction.DOWN && direction == Direction.UP ||
                this.direction == Direction.LEFT && direction == Direction.RIGHT ||
                this.direction == Direction.RIGHT && direction == Direction.LEFT) {
                return;
            }
        }
        this.direction = direction;
    }

    /**
     * This method gets the life status of the snake
     * @return isAlive (boolean - true if snake is alive, false if snake is dead)
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * This method is a setter method to set life status of the snake.
     * @param alive (type boolean - true if snake is alive, false if snake dead.)
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Getter method that gets the linked list of the snake's bodies
     * @return (the body parts of the snake. type linked list)
     */
    public LinkedList<SnakeBody> getBodies() {
        return bodies;
    }

    /**
     * Getter method that gets the current score.
     * @return (score. The current score in the game)
     */
    public int getScore() {
        return score;
    }

    /**
     * This method is responsible for action of eating.
     * @param element (The objects such as Food, Posion, etc)
     */
    public void eatElement(Element element) {
        if (getBodies().size() == 0){
            setAlive(false);
            return;
        }
        if (element == null || element.isEatable()){
            SnakeBody nextHead = new SnakeBody( nextX(), nextY(), getBodyImage());
            if (element == null) {
                this.bodies.addFirst(nextHead);
                this.bodies.removeLast();
            } else {
                if (element.getScore() >= 1) {
                    for (int i = 0; i < element.getScore(); i++){
                        this.bodies.addFirst(nextHead);
                        nextHead = new SnakeBody( nextX(), nextY(), getBodyImage());
                    }
                } else {
                    if (this.bodies.size() == 1 && element.getScore() < 0) {
                        this.setAlive(false);
                    } else {
                        this.bodies.removeLast();
                    }
                }
                int score = this.score + element.getScore();
                this.score = score < 0 ? 0 : score;
            }
        } else {
            setAlive(false);
        }
    }

    /**
     * This method determines the next x position of the snake.
     * @return (The x coordinate of next position) - Type int
     */
    public int nextX() {
        int x = this.bodies.getFirst().getX();
        switch (this.direction) {
            case LEFT: x = x -1; break;
            case RIGHT: x = x + 1; break;
        }
        return x;
    }

    /**
     * This method determines the next y position of the snake.
     * @return (The y coordinate of the next position)- Type int
     */
    public int nextY() {
        int y = this.bodies.getFirst().getY();
        switch (this.direction) {
            case UP: y = y -1; break;
            case DOWN: y = y + 1; break;
        }
        return y;
    }

    /**
     * Getter method that gets the body color of the snake.
     * @return bodycolor (the body color of the snake) - Type Color
     */
    public Color getBodyColor() {
        return bodyColor;
    }

    /**
     * Method sets the body color of the snake.
     * @param bodyColor (The color you want the snake's body to be) - Type color
     */
    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    /**
     * Getter method that gets the snake's body image path.
     * @return bodyimage (the String of the image's path)
     */
    public String getBodyImage() {
        return bodyImage;
    }

    /**
     * Setter method that sets the path of the image for the body.
     * @param bodyImage (String of the path of the image)
     */
    public void setBodyImage(String bodyImage) {
        this.bodyImage = bodyImage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
