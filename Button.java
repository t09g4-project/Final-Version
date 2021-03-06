/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.view;

import com.game.common.Configure;

import javax.swing.*;

/**
 * Class used to set up buttons. Set up the text of a button, color of the button and interface. 
 */
public class Button extends JButton {
    
    
    /**
     * Constructor that is used to set up the buttons.
     * @param text (Type String) - What you want to the text of the button to be.
     */
    public Button(String text) {
        super(text);
        setBackground(Configure.Theme.BTN_COLOR);
        setOpaque(true);
        setBorderPainted(false);
    }
}
