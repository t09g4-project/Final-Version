/**
* @author T-09 G04
* @version Final Version
* @since 2019-04-10
*/
package com.game.model;

import com.game.common.Configure;

/**
 * This class is responsible for setting up the Elements of the Wall.
 */
public class Wall extends Element {

    /**
     * Constructor that sets up the X & Y coordinates of the wall, the color of the wall, and the Eatable boolean,
     * and the wall image.
     * @param x (x coordinate of the wall - type int)
     * @param y (y coordinate of the wall - type int)
     */
    public Wall(int x, int y) {
        super(x, y);
        this.setColor(Configure.Wall.color);
        this.setEatable(false);
        this.setImagePath(Configure.Wall.image);
    }

    /**
     * Constructor that sets up the wall color, the image path, and sets Eatable boolean to false
     */
    public Wall() {
        this.setColor(Configure.Wall.color);
        this.setImagePath(Configure.Wall.image);
        this.setEatable(false);
    }
}
