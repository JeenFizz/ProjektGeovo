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

    
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}
