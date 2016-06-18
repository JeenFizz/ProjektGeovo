package model.mobile;

import contract.IElement;

import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;




/**
 * @author Alex GUILBAUD on 13/06/2016 , modify by maxence 
 */
public class Monster1 extends Mobile implements IMonster {
    public Monster1(Point pos)
    {
        super("monster_1.png", true, pos);
    }

  
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}
