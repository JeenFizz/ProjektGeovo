package model;

import model.Permeability;
import model.Sprite;

public class OsV extends MotionlessElement{
	
		public OsV() {
			super(new Sprite("I", "vertical_bone.png"), Permeability.BLOCKING, 'I');
		}

	}
