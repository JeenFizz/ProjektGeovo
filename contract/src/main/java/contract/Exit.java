package contract;

import contract.Permeability;
import contract.Sprite;

class Exit extends MotionlessElement {

	public Exit() {
		super(new Sprite("┌┐", "gate_open.png"), Permeability.PENETRABLE, 'X');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.EXIT;
	}

}
