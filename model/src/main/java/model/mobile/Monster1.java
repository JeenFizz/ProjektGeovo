package model.mobile;

import contract.IElement;

import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;




/**
 * @author Alex GUILBAUD on 13/06/2016 , modified by maxence on 20/06/2016.
 */
public class Monster1 extends Mobile implements IMonster {
    public Monster1(Point pos)
    {
        super("monster_1.png", true, pos);
    }

    /**
     * @param heroPos, tileMap
     * gets the position of Lorann and directs the monster to him.
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
        } else if (Monsterpos.x < heroPos.x) {
            if(Monsterpos.y > heroPos.y) {
                direction = MobileOrder.LeftDown;
            } else if (Monsterpos.y < heroPos.y) {
                direction = MobileOrder.RightDown;
            }
        } else if (Monsterpos.y < heroPos.y) {
            if(Monsterpos.x > heroPos.x) {
                direction = MobileOrder.RightUp;
            } else if (Monsterpos.x < heroPos.x) {
                direction = MobileOrder.LeftUp; 
            }
        } else if (Monsterpos.y != heroPos.y){
        	direction = MobileOrder.random();
        }else if (Monsterpos.x != heroPos.x){
        	direction = MobileOrder.random();
        }

       

        return direction;
    }
}
