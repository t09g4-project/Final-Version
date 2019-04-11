/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.listener;

import com.game.view.ChooseLevelPanel;
import com.game.view.GetNamePanel;
import com.game.view.PlayerPanel;
import com.game.view.TwoPlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for listening to the player 1 and player 2 buttons.
 */
public class MenuListener implements ActionListener {
    private JFrame jFrame;

    // not sure if correct.
    /**
     * constructor that accepts a JFrame object.
     * @param jFrame (Type JFrame)
     */
    public MenuListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    /**
     * Method that will preform an action depending on which button was pressed.
     * If 1 Player was pressed, it will change the view to PlayerPanel.
     * Otherwise it will change the view to TwoPlayerPanel
     * @param e (Type ActionEvent, this is the event - what was pressed)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        removeButton(e);
        if (e.getActionCommand().equals("1 Player")) {
            PlayerPanel jPanel = new PlayerPanel();
            changePanel(jPanel);
            jPanel.go();
        } else if (e.getActionCommand().equals("2 Players")){
            JPanel jPanel = new GetNamePanel();
            changePanel(jPanel);
        } else {
            changePanel(new ChooseLevelPanel());
        }
    }

    /**
     *
     * @param e
     */
    private void removeButton(ActionEvent e) {
        JButton clickButton = (JButton)e.getSource();
        Container parent = clickButton.getParent();
        parent.removeAll();
        parent.revalidate();
        parent.repaint();
    }

    /**
     * This method changes the Jpanel.
     * @param jPanel (Object JPanel - It is the new JPanel you want to switch to)
     */
    private void changePanel(JPanel jPanel) {
        jFrame.setContentPane(jPanel);
        jFrame.revalidate();
        jFrame.repaint();
    }
}
