/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;
import com.game.listener.Player1KeyListener;
import com.game.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class PlayerPanel extends JPanel {
    private ArrayList<Wall> wallList;
    private ArrayList<Wall> rampart;
    private Food food;
    private Poison poison;
    private Bonus bonus;
    private Integer interval;
    private volatile Snake snake;

    /**
     * Constructor that sets up the game, snake, Food, Bonus, Posion, Wall and Interval. This will use the default interval given
     */
    public PlayerPanel() {
        initGame();
        initSnake();
        initFood();
        initBonus();
        initPoison();
        initWall();
        this.interval = Configure.Board.INTERVAL;
    }

    
    
    /**
     * Constructor that sets up the game, snake, Food, Bonus, Posion, Wall, and interval.
     * @param interval (Type Int) - The interval you want the game to be set. ( How fast you want the game to be)
     */
    public PlayerPanel(Integer interval) {
        initGame();
        initSnake();
        initFood();
        initBonus();
        initPoison();
        initWall();
        this.interval = interval;
    }
    public void go() {
        run(countDownThread(), interval);
    }

    
    
    /**
     * Method that countdowns before the game starts.
     * @return countDOwnThread (Type Thread) 
     */
    private Thread countDownThread() {
        Thread countDownThread = new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                try {
                    JLabel jLabel = new JLabel();
                    jLabel.setText("Count Down: " + i);
                    jLabel.setBounds(Configure.Element.ElementWidth * (Configure.Board.XNum + 10),
                            Configure.Element.ElementWidth * 5, 150,30);
                    add(jLabel);
                    repaint();
                    sleep(1000);
                    remove(jLabel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        countDownThread.start();
        return countDownThread;
    }

    /**
     * This method initalizes the Board of the game. It will set up the walls.
     */
    public void initGame() {
        this.setBackground(Configure.Theme.BACKGROUND_COLOR);
        this.rampart = new ArrayList<>();
        for (int y = 0; y < Configure.Board.YNum; y++ ) {
            rampart.add(new Wall(0, y));
            rampart.add(new Wall(Configure.Board.XNum, y));
        }

        for (int x = 0; x <= Configure.Board.XNum; x++ ) {
            rampart.add(new Wall(x, 0));
            rampart.add(new Wall(x, Configure.Board.YNum));
        }
    }

    /**
     * Method is initalizing Food and responsible for randomly generating the Food's X & Y position.
     */
    private void initFood() {
        Food food = new Food();
        do {
            setRandomPosition(food);
        } while (isExistElement(food));
        setFood(food);
    }

    /**
     * Method initalizes Bonus and randonly generates the Bonus' X & Y position.
     */
    private void initBonus() {
        Bonus bonus = new Bonus();
        do {
            setRandomPosition(bonus);
        } while (isExistElement(bonus));
        setBonus(bonus);
    }

    /**
     * Method initalizes Posion and randomly generates the Poison object's X & Y position.
     */
    private void initPoison() {
        Poison poison = new Poison();
        do {
            setRandomPosition(poison);
        } while (isExistElement(poison));
        setPoison(poison);
    }

    /**
     * Method initializes the walls for the game.
     */
    private void initWall() {
        for (int i = 0; i < Configure.Wall.num; i++) {
            Wall wall = new Wall();
            do {
                setRandomPosition(wall);
            } while (isExistElement(wall));
            ArrayList<Wall> wallList = getWallList();
            if (wallList == null) {
                wallList = new ArrayList<>();
            }
            wallList.add(wall);
            setWallList(wallList);
        }
    }

    /**
     * Method initalizes the sanke.
     */
    public void initSnake() {
        SnakeBody tempSnakeBody = new SnakeBody(Configure.SnakeBody.image1);
        do {
            setRandomPosition(tempSnakeBody);
        } while (isExistElement(tempSnakeBody));
        this.snake = new Snake(tempSnakeBody.getX(), tempSnakeBody.getY(), Configure.SnakeBody.image1);
        this.snake.setCode(Configure.Snake.CODE_A);
    }

    /**
     *
     */
    public void run(Thread countDownThread, Integer interval) {
        JPanel jPanel = this;
        new Thread(() -> {
            jPanel.addKeyListener(new Player1KeyListener(snake));
            jPanel.setFocusable(true);
            jPanel.requestFocusInWindow();
            runSnake(snake, countDownThread, interval);
        }).start();
    }

    /**
     *
     * @param snake
     */
    public void runSnake(Snake snake, Thread countDownThread, Integer interval) {
        while (snake.isAlive()) {
            if (countDownThread.isAlive())
                continue;
            ArrayList<Element> elements = getAllElement();
            Element nextElement = null;
            for (Element e : elements) {
                if (e.getX() == snake.nextX() && e.getY() == snake.nextY()){
                    nextElement = e;
                    break;
                }
            }
            snake.eatElement(nextElement);
            handleEatenElement(nextElement);
            repaint();
            try {
                Thread.currentThread().sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (isGameOver())
            addBackMenuBtn();
    }

    /**
     * This method is responsible for randomly generating the X & Y coordinate position of the various objects such as
     * Food, Bonus, Posion, etc.
     * @param element (What object we want to pass in - Type Element)
     */
    public void setRandomPosition(Element element) {
        int y = (int) (Math.random() * Configure.Board.YNum);
        if (element instanceof SnakeBody)
            element.setX(1);
        else {
            int x = (int) (Math.random() * Configure.Board.XNum);
            element.setX(x);
        }
        element.setY(y);
    }

     /**
     * This method sets the Snake picture size to make the picture in the path have the same size in the game.
     * @param g (Type Graphics) - Object that is responsible for drawing
     * @param e (Type Element) - The element object that you want to pass in
     */
    void fillRect(Graphics g, Element e) {
        int width = Configure.Element.ElementWidth;
        try {
            BufferedImage img;
            Element head = snake.getBodies().getFirst();
            if (e.getX() == head.getX() && e.getY() == head.getY()){
                img = ImageIO.read(new File(Configure.SnakeBody.head));
            } else {
                img = ImageIO.read(new File(e.getImagePath()));
            }
            g.drawImage(img, e.getX() * width, e.getY() * width, width, width,  null);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    /**
     * Get elements of the wall/rock
     * @return
     */
    public ArrayList<Element> getBlockElement() {
        ArrayList<Element> elements = getDynamicElement();
        if (getWallList() != null)
            elements.addAll(getWallList());
        if (getRampart() != null)
            elements.addAll(getRampart());
        return elements;
    }

    /**
     *
     * @return
     */
    public ArrayList<Element> getDynamicElement(){
        ArrayList<Element> elements = new ArrayList<Element>();
        if (getPoison() != null)
            elements.add(getPoison());
        if (getFood() != null)
            elements.add(getFood());
        if (getBonus() != null)
            elements.add(getBonus());
        return elements;
    }

    /**
     *
     * @param element (if it is exisiting,
     * @return
     */
    public boolean isExistElement(Element element) {
        ArrayList<Element> blockElements = getBlockElement();
        for (Element e : blockElements) {
            if (e.getX() == element.getX() && e.getY() == element.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage img = ImageIO.read(new File("MySnake/src/resources/bg.jpg"));
            g.drawImage(img, 0, 0,Configure.Element.ElementWidth * (Configure.Board.XNum + 1),
                    Configure.Element.ElementWidth * (Configure.Board.YNum + 1), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        renderElement(g);
        renderScore(g);
        if (isGameOver()){
            dead(g);
            gameover(g);
        }


    }

    /**
     * This method renders the current score.
     * @param g
     */
    public void renderScore(Graphics g) {
        g.setColor(snake.getBodyColor());
        String name = snake.getName() == null ? "Your" : snake.getName() + "'s";
        g.drawString(name + " Score: " + snake.getScore(), Configure.Element.ElementWidth * (Configure.Board.XNum + 10),
                Configure.Element.ElementWidth * 2);
    }

    public boolean isGameOver() {
        return !this.snake.isAlive();
    }

    /**
     *
     * @param g
     */
    public void dead(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Dead!", Configure.Element.ElementWidth * (Configure.Board.XNum + 17),
                Configure.Element.ElementWidth * 2);
    }

    /**
     *
     * @return
     */
    public ArrayList<Element> getAllElement() {
        ArrayList<Element> elements = getBlockElement();
        elements.addAll(snake.getBodies());
        return elements;
    }

    /**
     *
     * @param g
     */
    private void renderElement(Graphics g) {
        ArrayList<Element> elements = getAllElement();
        elements.forEach((e) -> {
            fillRect(g, e);
        });
    }

    /**
     *
     * @param nextElement
     */
    public void handleEatenElement(Element nextElement) {
        if (nextElement != null && nextElement.isEatable()) {
            if (nextElement instanceof Food ) {
                initFood();

            }
            else if(nextElement instanceof Bonus ) {
            	initBonus();
            }
            else {
                initPoison();
            }
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Wall> getWallList() {
        return wallList;
    }

    /**
     *
     * @param wallList
     */
    public void setWallList(ArrayList<Wall> wallList) {
        this.wallList = wallList;
    }

    /**
     *
     * @return
     */
    public ArrayList<Wall> getRampart() {
        return rampart;
    }

    /**
     *
     * @param rampart
     */
    public void setRampart(ArrayList<Wall> rampart) {
        this.rampart = rampart;
    }

    /**
     * Getter method for food.
     * @return food (Type Food, the food object)
     */
    public Food getFood() {
        return food;
    }

    /**
     * Setter method that sets the food.
     * @param food (type Food - the food object you want to pass in)
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Getter method that gets the Bonus object.
     * @return bonus (The Bonus object)
     */
    public Bonus getBonus() {
    	return bonus;
    }

    /**
     * Setter method that sets the Bonus object for the bonus field.
     * @param bonus (The Bonus object you want to pass in)
     */
    public void setBonus(Bonus bonus) {
    	this.bonus = bonus;
    }

    /**
     * Getter method that gets the poison object.
     * @return poison (The poison object)
     */
    public Poison getPoison() {
        return poison;
    }

    /**
     * setter method that sets the poison.
     * @param poison (Type Posion, the poison object)
     */
    public void setPoison(Poison poison) {
        this.poison = poison;
    }

    /**
     * Getter method that gets the snake.
     * @return snake (Type Snake)
     */
    public Snake getSnake() {
        return snake;
    }

   /**
     * Method that will draw game over. 
     * @param g (Type Graphics) - Object that will used to draw Game Over 
     */
    public void gameover(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Game Over!", Configure.Element.ElementWidth * (Configure.Board.XNum + 13),
                Configure.Element.ElementWidth * 8);
    }

    
    
    /**
     * Method that adds a back menu button. When clicked it will return the user to the menu panel.
     */
    public void addBackMenuBtn() {
        JButton backMenuBtn = new Button("Back to Menu");
        JPanel thisjPanel = this;
        
       
        backMenuBtn.addActionListener(e -> {
            JFrame jFrame = (JFrame) this.getParent().getParent().getParent();
            thisjPanel.removeAll();
            jFrame.setContentPane(new MenuPanel(jFrame));
            jFrame.revalidate();
            jFrame.repaint();
        });
        
        backMenuBtn.setLayout(null);
        backMenuBtn.setBounds(Configure.Element.ElementWidth * (Configure.Board.XNum + 10),
                Configure.Element.ElementWidth * 5, 150,30);
        this.add(backMenuBtn);
        this.validate();
        this.repaint();
    }
}
