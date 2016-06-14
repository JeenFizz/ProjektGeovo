package model;

import model.Permeability;
import model.Sprite;

class Land extends MotionlessElement {

	public Land() {
		super(new Sprite("░░", "land.png"), Permeability.PENETRABLE, 'L');
	}

}
