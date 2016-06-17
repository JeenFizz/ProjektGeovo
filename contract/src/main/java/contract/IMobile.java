package contract;

import java.awt.*;


public interface IMobile extends IElement {

    void setLocation(Point loc);

    Point getPos();

    void move(MobileOrder order);
    MobileOrder getDirection();

}
