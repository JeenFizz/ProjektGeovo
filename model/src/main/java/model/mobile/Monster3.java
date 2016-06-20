package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;
import contract.*;

import java.awt.*;
/**
 * @author Alex GUILBAUD on 13/06/2016
 */
public class Monster3 extends Mobile implements IMonster {
    public Monster3(Point pos)
    {
        super("monster_3.png", true, pos);
    }

    /**
     * @param heroPos, tileMap
     * gets the position of Lorann and move the monster to him.
     */
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
    	
    	Point Monsterpos = this.getPos().getLocation();
    	
    	if(Monsterpos.x == heroPos.x) {
            if(Monsterpos.y > heroPos.y) {
                direction = MobileOrder.Left;
            } else if (Monsterpos.y < heroPos.y) {
                direction = MobileOrder.Right;
            }
        } else if(Monsterpos.y == heroPos.y) {
            if(Monsterpos.x > heroPos.x) {
                direction = MobileOrder.Up;
            } else if (Monsterpos.x < heroPos.x) {
                direction = MobileOrder.Down;
            }
        } else if (Monsterpos.x != heroPos.x) {
            if(Monsterpos.y > heroPos.y) {
                direction = MobileOrder.Left;
            } else if (Monsterpos.y < heroPos.y) {
                direction = MobileOrder.Right;
            }
        } else if (Monsterpos.y != heroPos.y) {
            if(Monsterpos.x > heroPos.x) {
                direction = MobileOrder.Right;
            } else if (Monsterpos.x < heroPos.x) {
                direction = MobileOrder.Left; 
            }
		
    }
    	return direction;
    }
}
