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
 * Class responsible for listening to what player 2 is pressing. Depending on what player 2
 * is pressing, it will move player 2's snake in the given direction.
 * Player 2 uses WASD keys to move.
 */
public class Player2KeyListener implements KeyListener {
    private Snake snake;

    /**
     * Constructor that sets teh field of the snake.
     * @param snake (The object that is passed in is the snake for player 2 - Type Snake)
     */
    public Player2KeyListener(Snake snake) {
        this.snake = snake;
    }
    
    

    /**
     * Handles the key typed event
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    
    
    /**
     * Handles key pressed event. Responsible for listening to what player 2 has pressed. It will move the snake
     * depending on what was pressed. It will listen to the WASD keys.
     * @param e (Type KeyEvent - what key the player pressed)
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_S:
                snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
                snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                snake.setDirection(Direction.RIGHT);
                break;
        }
    }

    
    
    /**
     * Handles the key release event.
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
