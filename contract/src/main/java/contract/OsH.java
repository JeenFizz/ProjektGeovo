package contract;

import contract.Permeability;
import contract.Sprite;

public class OsH extends MotionlessElement{
	
		public OsH() {
			super(new Sprite("-", "horizontal_bone.png"), Permeability.BLOCKING, '-');
		}

	}
