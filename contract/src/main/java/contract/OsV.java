package contract;

import contract.Permeability;
import contract.Sprite;

public class OsV extends MotionlessElement{
	
		public OsV() {
			super(new Sprite("I", "vertical_bone.png"), Permeability.BLOCKING, 'I');
		}

	}
