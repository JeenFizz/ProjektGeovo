package contract;

import contract.Permeability;
import contract.Sprite;

public class Purse extends MotionlessElement {

		public Purse() {
			super(new Sprite("b", "Purse.png"), Permeability.PENETRABLE, '1');
		}

		@Override
		public ActionOnHeroes getActionOnHeroes() {
			return ActionOnHeroes.TAKE_MONEY;
		}
	
	
	
	
	
	
	
}
