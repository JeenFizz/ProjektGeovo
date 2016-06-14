package model;

import model.Permeability;
import model.Sprite;

class ExitClose extends MotionlessElement {

	public ExitClose() {
		super(new Sprite("┌┐", "gate_closed.png"), Permeability.PENETRABLE, 'Y');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.HURT ;
	}

}
