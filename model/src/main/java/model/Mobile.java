package model;

import java.awt.Point;


import aedt.showboard.IPawn;
import model.INettleWorld;
import model.Element;
import model.ISprite;
import model.Permeability;

public abstract class Mobile extends Element implements IPawn {
	private final Point position;

	public Mobile(final ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
	}

	@Override
	public int getX() {
		return this.position.x;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getNettleWorld().getWidth())) {
			this.position.x = x;
			this.getNettleWorld().setMobileHasChanged();
		}
	}

	@Override
	public int getY() {
		return this.position.y;
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getNettleWorld().getHeight())) {
			this.position.y = y;
			this.getNettleWorld().setMobileHasChanged();
		}
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	public void setNettleWorld(final INettleWorld nettleWorld, final int x, final int y) {
		super.setNettleWorld(nettleWorld);
		this.setX(x);
		this.setY(y);
	}

	private boolean isMovePossible(final int x, final int y) {
		return (this.getNettleWorld().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}
	public void moveUPRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveUPLeft() {

		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);

		}
	}

	public void moveDownRight() {
		
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);

		}
	}

	public void moveDownLeft() {
	
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}
	
	
	
	
	
	
	
	
	
}
