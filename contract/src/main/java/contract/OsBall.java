package contract;

import contract.Permeability;

import contract.Sprite;

public class OsBall extends MotionlessElement{
	
		public OsBall() {
			super(new Sprite("O", "bone.png"), Permeability.BLOCKING, 'O');
		}

	}
	


