/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import com.game.common.Configure;
import com.game.view.MenuPanel;

import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for the model frame of the game.
 */
public class GameFrame extends JFrame {

    /**
     * Constructor that will set up the title of the window. It will also set the panels up and the panel size.
     */
    public GameFrame() {
        this.setTitle("Snake Game");
        JPanel panel = new MenuPanel(this);
        this.setContentPane(panel);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(Configure.Element.ElementWidth * (Configure.Board.XNum + 20),
                Configure.Element.ElementWidth * (Configure.Board.YNum + 3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
