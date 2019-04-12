/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;

import javax.swing.*;

/**
 * Levelpanel is a panel for setting up the level/mode.
 */
public class ChooseLevelPanel extends JPanel {
    
    
    /**
     * Constructor that sets up the panel of the levelPanel. It adds the labels for player to choose challenge level,
     * a combox box of options the levels the player can pick, and a begin button.
     */
    public ChooseLevelPanel() {
        this.setBackground(Configure.Theme.BACKGROUND_COLOR);
        JLabel label = new JLabel("Challenge Level: ");
        add(label);
        String[] levels = new String[] {"twice fast", "triple fast"};
        JComboBox<String> comboBox = new JComboBox<>(levels);
        add(comboBox);
        JButton button = new Button("Begin");
        JPanel thisPanel = this;
        
        
        /**
         * Lamda expression to handle when the "Begin" button is pressed.
         */
        button.addActionListener(e -> {
            JFrame jFrame = (JFrame) thisPanel.getParent().getParent().getParent();
            thisPanel.removeAll();
            PlayerPanel playerPanel = new PlayerPanel(Configure.Board.INTERVAL - (comboBox.getSelectedIndex() + 1) * 120);
            jFrame.setContentPane(playerPanel);
            jFrame.requestFocus();
            jFrame.revalidate();
            jFrame.repaint();
            playerPanel.go();
        });
        
        add(button);
    }
}
