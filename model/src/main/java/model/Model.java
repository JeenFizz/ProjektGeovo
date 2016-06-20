package model;

import java.awt.*
;

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
			case 'O'://0 B
				return new Bone();
			case 'Q'://Q K
				return new CrystalBall();
			case '-'://- H
				return new HorizontalBone();
			case 'I'://I V
				return new VerticalBone();
			case 'Y'://Y C
				return new ClosedDoor();
			case 'X'://X O
				return new OpenDoor();
			case '1'://1 P
				return new Purse();
			case '@'://@ L
				return new Hero(pos);
            case 'F':
                return new Spell(pos); 
             
			case 'A'://A 1
				return new Monster1(pos);
			case 'B'://B
				return new Monster2(pos);
			case 'C':
				return new Monster3(pos);
			case 'D':
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

/**
 * 
 * @param map
 */
	private void setMap(final String map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

/*
 * load the map
 */
	public void loadMap(String key) {
		try {
			final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
			this.setMap(daoLoadMap.find(key).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
