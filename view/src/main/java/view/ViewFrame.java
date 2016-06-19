package view;

import java.awt.GraphicsConfiguration;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import contract.*;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel	model;

	/** The controller. */
	private IController	controller;
	/** The Constant serialVersionUID. */
	
	private ViewPanel viewPanel;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	/* private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(1020 + this.getInsets().left + this.getInsets().right, 720 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	} TEST */
	
	private void buildViewFrame(final IModel model) {
		  this.viewPanel = new ViewPanel(this);
		  this.setModel(model);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setResizable(false);
		  this.addKeyListener(this);
		  this.setContentPane(this.viewPanel);
		  this.setSize(1920, 1080);
		  this.setLocationRelativeTo(null);
		 }
	
	public void update() {
		this.viewPanel.update(
                this.controller.getTileMap()
        );
	}

    /**
     * Modified windows size taking border in count
     *
     * @param width
     * @param height
     */
    public void setSize(int width, int height) {
        super.setSize(width + this.getInsets().left + this.getInsets().right,
                height + this.getInsets().top + this.getInsets().bottom);
    }

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
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
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}
	
	
}
