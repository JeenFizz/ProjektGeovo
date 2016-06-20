package contract;

/**
 * 
 * @author Alex GUILBAUD
 *
 */
public interface ISpell extends IMobile {
	/**
	 * 
	 * @param direction
	 */
    void setDirection(MobileOrder direction);
    
    /**
     * 
     * @return
     */
    int getStep();
    
    void animate();
}
