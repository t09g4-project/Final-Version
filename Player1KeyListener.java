/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.listener;

import com.game.common.Direction;
import com.game.model.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is responsible for listening to what player 1 is pressing. Depending on what
 * player 1 is pressing, it will move the player's snake in the given direction.
 */
public class Player1KeyListener implements KeyListener {
    private Snake snake;

    /**
     * Constructor that sets the field of snake.
     * @param snake (The object that is passed in is the snake - Type Snake)
     */
    public Player1KeyListener(Snake snake) {
        this.snake = snake;
    }

    
    
    /**
     * Handles the key typed event.
     * @param e (Type KeyEvent - What KeyStroke occured)
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    

    /**
     * Method is responsible for listen to what the player 1 has pressed. Then it will move the snake depending on what
     * was pressed. It will listen to the arrow keys.
     * @param e (Type KeyEvent - what key the player pressed)
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
        }
    }
    
    

    /**
     * Handles the key released event.
     * @param e (Type KeyEvent - What KeyStroke occured)
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
