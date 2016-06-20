package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * 
	 * @param controller
	 */
	void setController(IController controller);
	

	void repaint();

	/**
	 * 
	 * @return
	 */
	int getHeight();
	
	/**
	 * 
	 * @return
	 */
	int getWidth();
	
	/**
	 * 
	 * @param message
	 */
	void showdiemessage(final String message);
	
	/**
	 * 
	 * @param message
	 */
	void Winmessage(final String message);
}
