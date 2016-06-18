package model;

import java.awt.*;

import contract.IMobile;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Observable;

import contract.IElement;
import contract.IModel;
import model.mobile.*;
import model.motionless.*;

/**
 * The Class Model.
 */
public class Model extends Observable implements IModel {

	/** The map */
	private String map = "";

	/**
	 * Instantiates a new model.
	 */
	public Model() {
	}

	/**
	 * Associate all sprite with a letter representing it in tileMap
	 */
	public IElement element(char c, Point pos) {
		switch (c){
			case 'B'://0
				return new Bone();
			case 'K'://Q
				return new CrystalBall();
			case 'H'://-
				return new HorizontalBone();
			case 'V'://I
				return new VerticalBone();
			case 'C'://Y
				return new ClosedDoor();
			case 'O'://X
				return new OpenDoor();
			case 'p'://1
				return new Purse();
			case 'L'://@
				return new Hero(pos);
           /* case 'F':
                return new FireBall(pos); 
             NOT IMPLEMENTED YET
             */
			case '1'://A
				return new Monster1(pos);
			case '2'://B
				return new Monster2(pos);
			case '3':
				return new Monster3(pos);
			case '4':
				return new Monster4(pos);
			default:
				return new Empty();
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


	/** i added the map functions in general here*/

	public String getMap() {
		return this.map;
	}


	private void setMap(final String map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}


	public void loadMap(String key) {
		try {
			final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
			this.setMap(daoLoadMap.find(key).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
