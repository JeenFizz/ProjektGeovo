package model;

import model.Permeability;
import model.Sprite;

public class OsH extends MotionlessElement{
	
		public OsH() {
			super(new Sprite("-", "horizontal_bone.png"), Permeability.BLOCKING, '-');
		}

	}
