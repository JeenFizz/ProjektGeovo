package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	String getMap();

	/**
	 * Load the message.
	 *
	 * @param id
	 *          the id
	 */
	void loadMap(int id);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
