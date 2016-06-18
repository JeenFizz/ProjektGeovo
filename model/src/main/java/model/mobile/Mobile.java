package model.mobile;

import contract.IMobile;
import contract.IModel;
import contract.MobileOrder;
import model.Element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author Alex GUILBAUD 
 * inspired of jpu2016sequence5
 */
public abstract class Mobile extends Element implements IMobile{
    public Point getPos() {
        // methods return actual position
    }

    public void setLocation(/* int */) {
        //modify position
    }

    public MobileOrder getDirection() {
        return direction;
    }

    public void move(MobileOrder order)
    {
        switch (order) {
            case Left:
                
                break;
            case Right:
                
                break;
            case Up:
                
                break;
            case Down:
                
                break;
            case LeftUp:
                
                break;
            case LeftDown:
                
                break;
            case RightUp:
                
                break;
            case RightDown:
                
                break;
            
        }
        this.direction = order;
        System.out.println("POS : " + pos);
    }
}
