package contract;

import java.awt.*;


/**
 * 
 * @author Alex GUILBAUD
 *
 */

public interface IMobile extends IElement {
	
	/**
	 * 
	 * @param loc
	 */
    void setLocation(Point loc);
    
    /**
     * 
     * @return
     */
    Point getPos();
   
/**
 * 
 * @param order
 */
    void move(MobileOrder order);
    
    /**
     * 
     * @return
     */
    MobileOrder getDirection();

}
