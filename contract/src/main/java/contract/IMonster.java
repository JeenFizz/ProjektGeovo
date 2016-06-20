package contract;

import java.awt.*;

/**
 * 
 * @author Alex GUILBAUD
 *
 */
public interface IMonster extends IMobile {
    MobileOrder getDirection(Point heroPos, IElement[][] tileMap);
}
