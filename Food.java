/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import com.game.common.Configure;

/**
 * This class is responsible for setting the elements of the Food object.
 */
public class Food extends Element {


    public Food() {
        this.setColor(Configure.Food.color);
        this.setScore(Configure.Food.score);
        this.setEatable(true);
        this.setImagePath(Configure.Food.image);
        // Food can be eat
    }
}
