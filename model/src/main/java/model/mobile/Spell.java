package model.mobile;

import contract.ISpell;
import contract.MobileOrder;

import java.awt.*;

/**
 * @author Alex GUILBAUD
 */
public class Spell extends Mobile implements ISpell{

    private int step = 1;

    /**
     * 
     * @param pos
     */
    public Spell(Point pos) {
        super("fireball_1.png", true, pos);
    }

    //return the step for the fireball animation
    public int getStep() {
        return step;
    }

//set direction
    public void setDirection(MobileOrder direction) {
        this.direction = direction;
    }

    //change the sprite of fireball
    public void animate() {
        this.step++;
        if(this.step > 0 && this.step < 6) {
            this.loadSprite(String.format("../model/src/main/java/model/sprite/fireball_%d.png", this.step));
        }
    }
}
