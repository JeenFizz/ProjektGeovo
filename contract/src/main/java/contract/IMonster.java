package contract;

import java.awt.*;

public interface IMonster extends IMobile {
    MobileOrder getDirection(Point heroPos, IElement[][] tileMap);
}
