package model;

import model.Permeability;
import model.Sprite;

public class OsBall extends MotionlessElement{
	
		public OsBall() {
			super(new Sprite("O", "bone.png"), Permeability.BLOCKING, 'O');
		}

	}
	


