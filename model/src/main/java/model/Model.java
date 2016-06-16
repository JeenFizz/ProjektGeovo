package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The map. */
	private String Map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.Map = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMap() {
		return this.Map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *          the new map
	 */
	private void setMap(final String Map) {
		this.Map = Map;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final int id) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMap(daoHelloWorld.find(id).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
