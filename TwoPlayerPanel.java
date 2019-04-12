/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;
import com.game.listener.Player2KeyListener;
import com.game.model.Element;
import com.game.model.Snake;
import com.game.model.SnakeBody;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
     * Constructor that will call the the super constructor in PlayerPanel.
     * It will also set the names of the snakes belonging to each player
     * @param aName (Type String)(Name for the snake for player one)
     * @param bName (Type String)(Name for the snake for player two)
     */
public class TwoPlayerPanel extends PlayerPanel {
    private volatile Snake snake2;

    public TwoPlayerPanel(String aName, String bName) {
        super();
        this.getSnake().setName(aName);
        this.snake2.setName(bName);
    }

    
    
   /**
     * Method that will call to super paintComponent, which gives all the objects on the board pictures. 
     * It will also call methods in this class dead2 (if snake is dead) and gameover (if game is over)
     * @param g (Type Graphics) - Object needed to draw all these componenets/pictures. 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!snake2.isAlive())
            dead2(g);
        if (isGameOver()){
            gameover(g);
        }
    }

    
    
    /**
     * Method that overrides isGameOver() in parent class.
     * @return isGamerOver() from parent class and the boolean state of snake2 to check if alive or not.
     */
    @Override
    public boolean isGameOver() {
        return super.isGameOver() && !snake2.isAlive();
    }

    
    
    /**
     * Method that will call the parent method initSnake() which initalizes the snake one. 
     * ALso will initalize snake two.
     */
    @Override
    public void initSnake(){
        super.initSnake();
        initSnake2();
    }

    
    
    /**
     * Method that will initalize snake two. 
     */
    private void initSnake2() {
        SnakeBody tempSnakeBody = new SnakeBody(Configure.SnakeBody.image2);
        do {
            setRandomPosition(tempSnakeBody);
        } while (isExistElement(tempSnakeBody));
        this.snake2 = new Snake(tempSnakeBody.getX(), tempSnakeBody.getY(), Configure.SnakeBody.image2);
        this.snake2.setCode(Configure.Snake.CODE_B);
    }

    
    
    /**
     *
     * @return
     */
    @Override
    public ArrayList<Element> getAllElement() {
        ArrayList<Element> elements = super.getAllElement();
        elements.addAll(snake2.getBodies());
        return elements;
    }

    
    
    /**
     *
     * @param g
     */
    @Override
    public void renderScore(Graphics g) {
        super.renderScore(g);
        g.setColor(snake2.getBodyColor());
        g.drawString(snake2.getName() + "'s Score: " + snake2.getScore(), Configure.Element.ElementWidth * (Configure.Board.XNum + 10),
                Configure.Element.ElementWidth * 3);
    }

    
    
    /**
     *
     */
    @Override
    public void run(Thread countDownThread, Integer interval) {
        super.run(countDownThread, interval);
        JPanel jPanel = this;
        new Thread(() -> {
            jPanel.addKeyListener(new Player2KeyListener(snake2));
            jPanel.setFocusable(true);
            jPanel.requestFocusInWindow();
            runSnake(snake2, countDownThread, interval);
        }).start();
    }

    
    
    /**
     *
     * @param g
     * @param e
     */
    @Override
    void fillRect(Graphics g, Element e) {
        int width = Configure.Element.ElementWidth;
        try {
            BufferedImage img;
            Element head = getSnake().getBodies().getFirst();
            Element head2 = snake2.getBodies().getFirst();
            if (e.getX() == head.getX() && e.getY() == head.getY()){
                img = ImageIO.read(new File(Configure.SnakeBody.head));
            } else if (e.getX() == head2.getX() && e.getY() == head2.getY()) {
                img = ImageIO.read(new File(Configure.SnakeBody.head2));
            } else {
                img = ImageIO.read(new File(e.getImagePath()));
            }
            g.drawImage(img, e.getX() * width, e.getY() * width, width, width, null);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    
    
    /**
     *
     * @param g
     */
    public void dead2(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Dead!", Configure.Element.ElementWidth * (Configure.Board.XNum + 17),
                Configure.Element.ElementWidth * 3);
    }
}
