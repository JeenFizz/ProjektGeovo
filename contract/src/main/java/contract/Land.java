package contract;

import contract.Permeability;

import contract.Sprite;

class Land extends MotionlessElement {

	public Land() {
		super(new Sprite("░░", "land.png"), Permeability.PENETRABLE, 'L');
	}

}
