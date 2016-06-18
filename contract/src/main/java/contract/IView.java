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

	int getHeight();

	int getWidth();
	
	void showdiemessage(final String message);
	
	void Winmessage(final String message);
}
