/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;

import javax.swing.*;

public class GetNamePanel extends JPanel {

    public GetNamePanel() {
        this.setBackground(Configure.Theme.BACKGROUND_COLOR);
        JLabel aLabel = new JLabel("Player 1 Name :");
        JLabel bLabel = new JLabel("Player 2 Name :");
        JTextField aNameField = new JTextField(15);
        JTextField bNameField = new JTextField(15);
        JButton jButton = new Button("Begin!");
        JPanel thisPanel = this;
        jButton.addActionListener(e -> {
            String aName = aNameField.getText();
            String bName = bNameField.getText();
            if (!aName.equals("") && !bName.equals("")) {
                JFrame jFrame = (JFrame) thisPanel.getParent().getParent().getParent();
                thisPanel.removeAll();
                TwoPlayerPanel twoPlayerPanel = new TwoPlayerPanel(aName, bName);
                jFrame.setContentPane(twoPlayerPanel);
                jFrame.requestFocus();
                jFrame.revalidate();
                jFrame.repaint();
                twoPlayerPanel.go();
            }
        });
        add(aLabel);
        add(aNameField);
        add(bLabel);
        add(bNameField);
        add(jButton);
    }
}
