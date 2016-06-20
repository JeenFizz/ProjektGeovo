package view;

import java.awt.event.KeyEvent
;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import contract.*;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	
	public int getHeight()
	{
		return this.viewFrame.getHeight();
	}

	public int getWidth()
	{
		return this.viewFrame.getWidth();
	}
	
	
	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_1:
				return ControllerOrder.MAP1;
			
			case KeyEvent.VK_2:
				return ControllerOrder.MAP2;
			
			case KeyEvent.VK_3:
				return ControllerOrder.MAP3;
			
			case KeyEvent.VK_4:
				return ControllerOrder.MAP4;
			
			case KeyEvent.VK_5:
				return ControllerOrder.MAP5;
			
			case KeyEvent.VK_M:
				return ControllerOrder.MENU;
			
		//diagonals
			case KeyEvent.VK_NUMPAD7:
            	return ControllerOrder.MOVELEFTUP;
			
             case KeyEvent.VK_NUMPAD9:
            	return ControllerOrder.MOVERIGHTUP; 
           
			case KeyEvent.VK_NUMPAD3:
            	return ControllerOrder.MOVERIGHTDOWN;
            
            case KeyEvent.VK_NUMPAD1:
            	return ControllerOrder.MOVELEFTDOWN; 
            
            
         //simple movements   
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.MOVELEFT;			
			case KeyEvent.VK_NUMPAD6:
				return ControllerOrder.MOVERIGHT;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.MOVEDOWN;
			case KeyEvent.VK_NUMPAD5:
				return ControllerOrder.MOVEDOWN;
			case KeyEvent.VK_NUMPAD8:
				return ControllerOrder.MOVEUP;
				
			 case KeyEvent.VK_SPACE:
	                return ControllerOrder.SPELL;
            
			default:
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void showdiemessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void Winmessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void repaint(){
		this.viewFrame.update();
	}
	
	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
