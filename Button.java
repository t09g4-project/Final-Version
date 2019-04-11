/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;

import javax.swing.*;

public class Button extends JButton {
    public Button(String text) {
        super(text);
        setBackground(Configure.Theme.BTN_COLOR);
        setOpaque(true);
        setBorderPainted(false);
    }
}
