package model;

import model.Permeability;
import model.Sprite;

public class EnergyBall extends MotionlessElement {

		public EnergyBall() {
			super(new Sprite("┌┐", "crystal_ball.png"), Permeability.PENETRABLE, 'Q');
		}

		@Override
		public ActionOnHeroes getActionOnHeroes() {
			return ActionOnHeroes.OPEN_DOOR;
		}
	
	
	
	
	
	
	
}
