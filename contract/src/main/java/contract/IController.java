package contract;

import java.awt.Point;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * start
	 */
	public void start();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
	
	IElement[][] getTileMap();

	IElement[][] parser(String tilemap);


	
}
