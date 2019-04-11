/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import com.game.common.Configure;

/**
 * This sets up the Element values of Bonus object.
 */
public class Bonus extends Element {

    /**
     * Constructor that will set the values of Bonus object.
     * It will set the Color, the score value, the image path, and set the boolean of Eatable to true.
     */
    public Bonus() {
        this.setColor(Configure.Bonus.color);
        this.setScore(Configure.Bonus.score);
        this.setEatable(true);
        this.setImagePath(Configure.Bonus.image);
        // Bouns Food can be eat
    }
}
