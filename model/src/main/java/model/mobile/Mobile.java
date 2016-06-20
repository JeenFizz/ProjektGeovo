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
	/**
	 * methods return actual position
	 */
    public Point getPos() {
    	 return pos.getLocation();
    }

    protected Point pos = new Point();

    protected MobileOrder direction = MobileOrder.Down; //Begin with Lorann Down sprite

    /**
     * 
     * @param imagePath
     * @param permeability
     * @param pos
     */
    public Mobile(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability);
        this.pos.setLocation(pos);
    }
//set the location
    public void setLocation(Point loc) {
        this.pos.setLocation(loc);
    }
//return the direction of the mobile order
    public MobileOrder getDirection() {
        return direction;
    }

    /**
     * move in eight direction 
     */
    public void move(MobileOrder order)
    {
        switch (order) {
            case Left:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() - 1);
                break;
            case Right:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() + 1);
                break;
            case Up:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY());
                break;
            case Down:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY());
                break;
            case LeftUp:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY() - 1);
                break;
            case LeftDown:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY() - 1);
                break;
            case RightUp:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY() + 1);
                break;
            case RightDown:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY() + 1);
                break;
            
        }
        this.direction = order;
        System.out.println("POS : " + pos);
    }
}
