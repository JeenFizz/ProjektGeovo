package contract;

import java.util.Observable;
import java.awt.*;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet and modify by Alex GUILBAUD
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();


	/**
	 * Gets the map content.
	 *
	 * @return the content
	 */
	String getMap();

	/**
	 * Load  Map.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);

	/**
	 * 
	 * @param c
	 * @param pos
	 * @return
	 */
	IElement element(char c, Point pos);
}
