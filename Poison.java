/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import com.game.common.Configure;

/**
 * This class sets up the Element values for the Poison object.
 */
public class Poison extends Element {

    /**
     * Constructor that will set the poison color, score vaue, Eatable boolean, and the image path
     */
    public Poison() {
        this.setColor(Configure.Poison.color);
        this.setScore(Configure.Poison.score);
        this.setImagePath(Configure.Poison.image);
        this.setEatable(true);
    }
}
