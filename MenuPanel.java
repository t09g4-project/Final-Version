/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;
import com.game.listener.MenuListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class creates a view that will contain two buttons, (1 player, 2 players).
 * This view will be used at the start of the program to determine if the user wants to play the game
 * with one player or two players.
 */
public class MenuPanel extends JPanel {
    public MenuPanel(JFrame jFrame) {
        this.setBackground(Configure.Theme.BACKGROUND_COLOR);
        JButton button1 = new Button("1 Player");
        JButton button2 = new Button("2 Players");
        JButton button3 = new Button("Challenge");
        this.setLayout(null);
        button1.addActionListener(new MenuListener(jFrame));
        button2.addActionListener(new MenuListener(jFrame));
        button3.addActionListener(new MenuListener(jFrame));
        button1.setBounds(Configure.Element.ElementWidth * (Configure.Board.XNum / 2), Configure.Element.ElementWidth * (Configure.Board.YNum / 2 + 5),100, 50);
        button2.setBounds(Configure.Element.ElementWidth * (Configure.Board.XNum / 2) + 150, Configure.Element.ElementWidth * (Configure.Board.YNum / 2 + 5),100, 50);
        button3.setBounds(Configure.Element.ElementWidth * (Configure.Board.XNum / 2) + 300, Configure.Element.ElementWidth * (Configure.Board.YNum / 2 + 5),120, 50);
        this.add(button1);
        this.add(button2);
        this.add(button3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage img = ImageIO.read(new File(Configure.IconPath));
            g.drawImage(img, Configure.Element.ElementWidth * (Configure.Board.XNum / 2), 0,Configure.Element.ElementWidth * (Configure.Board.XNum / 2) + 20,
                    Configure.Element.ElementWidth * (Configure.Board.YNum / 2 + 5), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
