package model;

import java.awt.Image;

import aedt.showboard.ISquare;
import model.INettleWorld;

public abstract class Element implements ISquare {
	private ISprite				sprite;
	private Permeability	permeability;
	private INettleWorld	nettleWorld;

	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public ISprite getSprite() {
		return this.sprite;
	}

	private void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	protected INettleWorld getNettleWorld() {
		return this.nettleWorld;
	}

	public void setNettleWorld(final INettleWorld nettleWorld) {
		this.nettleWorld = nettleWorld;
	}

	
	public Image getImage() {
		return this.getSprite().getImage();
	}
}
