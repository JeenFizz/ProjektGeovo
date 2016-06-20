package model.mobile;

import contract.IElement;

import contract.IMonster;
import contract.MobileOrder;
import contract.*;

import java.awt.*;

import java.awt.*;

/**
 * @author Alex GUILBAUD on 13/06/2016
 */
public class Monster2 extends Mobile implements IMonster {
    public Monster2(Point pos)
    {
        super("monster_2.png", true, pos);
    }

    
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
    		Point Monsterpos = this.getPos().getLocation();
    	

        if(Monsterpos.x - heroPos.x > 3 || Monsterpos.y - heroPos.y > 3 || Monsterpos.x - heroPos.x < -3 || Monsterpos.y - heroPos.y < -3) {
        		direction = MobileOrder.random();
        	}else if(Monsterpos.x == heroPos.x) {
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
        }else{
        		direction = MobileOrder.random();
        	}
		return direction;
}
}