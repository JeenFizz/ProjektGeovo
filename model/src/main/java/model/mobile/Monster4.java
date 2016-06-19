package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;
import contract.*;

import java.awt.*;



/**
 * @author Alex GUILBAUD on 13/06/2016
 */
public class Monster4 extends Mobile implements IMonster {
    public Monster4(Point pos)
    {
        super("monster_4.png", true, pos);
    }

   
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
    		Point Monsterpos = this.getPos().getLocation();
    	

        if( Monsterpos.y > heroPos.y ) {
        		direction = MobileOrder.Left;
        	}else if(Monsterpos.y < heroPos.y){
        		direction = MobileOrder.Right;
        	}else{
        		direction = MobileOrder.random();
        	}
		return direction;
}
}
