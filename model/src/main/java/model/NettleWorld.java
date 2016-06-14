package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;

import model.Element;
import model.Hero;
import model.Mobile;
import model.MotionlessElement;
import model.MotionlessElements;

public class NettleWorld extends Observable implements INettleWorld {
	public MotionlessElement				elements[][];
	public final ArrayList<Mobile>	mobiles;
	private int											width;
	private int											height;
	private Hero										hero;

	private NettleWorld() {
		this.mobiles = new ArrayList<Mobile>();
	}

	public NettleWorld(final String fileName) throws IOException {
		this();
		this.loadFile(fileName);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public MotionlessElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}

	@Override
	public Hero getHero() {
		return this.hero;
	}

	private void addElement(final MotionlessElement element, final int x, final int y) {
		this.elements[x][y] = element;
		if (element != null) {
			element.setNettleWorld(this);
		}
		this.setChanged();
	}

	@Override
	public void addMobile(final Mobile mobile, final int x, final int y) {
		this.mobiles.add(mobile);
		mobile.setNettleWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void addMobile(final Hero hero, final int x, final int y) {
		this.setHero(hero);
		this.addMobile((Mobile) hero, x, y);
	}

	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int numLine = 0;
		line = buffer.readLine();
		this.width = Integer.parseInt(line);
		line = buffer.readLine();
		this.height = Integer.parseInt(line);
		this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];
		while ((line = buffer.readLine()) != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
			}
			numLine++;
		}
		buffer.close();
		this.setChanged();
	}

	private void setHero(final Hero hero) {
		this.hero = hero;
		this.setChanged();
	}

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	@Override
	public Element[][] getElements() {
		return this.elements;
	}

	@Override
	public ArrayList<Mobile> getMobiles() {
		return this.mobiles;
	}
}
