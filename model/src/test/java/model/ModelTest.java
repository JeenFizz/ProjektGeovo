/**
 *
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ModelTest {
	private Model model;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Model#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		Assert.assertEquals("", this.model.getMap());
	}

	/**
	 * Test method for {@link model.Model#loadMessage(java.lang.String)}.
	 */
	@Test
	public void testGetMessageString() {
		this.model.loadMap("MAP1");
		Assert.assertEquals("      O-O---------O \n   O--O1I         OO\n   I 1  I          I\nO--O    I   1\n      I\nI 1 O---O-----O    O\nI1  1D        Q  @ Y\nI 1 O---O-----O    O\nO--O    I   1      I\n   I 1  I          I\n   O--O1I         OO\n      O-O---------O \n                    ",
				this.model.getMap());
		this.model.loadMap("MAP1");
		Assert.assertEquals("  OO---------------O\n OO                I\nOO          ###  @ I\nO Y O-------O1O O--O\nI   I    A    I    I\nI   I O-------O--O I\nI   I    B   1I    I\nI   O-------O I O--O\nI   I    C   1I    I\nO++ I O------OO--O I\nIQ  I    D  1I1 W  I\nO---O--------O-----O",
				this.model.getMap());
		this.model.loadMap("MAP1");
		Assert.assertEquals("O-----O--------O--O \nI     O 3 3 3 OO  IO\nI @   OO     OO   IO\nI      OO  D O    IO\nI   OO  OO  OO    IO\nI OOO    + OO     IO\nOOO   A +Q+ C  OOWIO\nI  3   O +      OOIO\nI 3  OOO  B  OO  OOO\nI3  OO        OO   O\nO---O----------OO YO\n OOOOOOOOOOOOOOOOOOO",
				this.model.getMap());
		this.model.loadMap("MAP1");
		Assert.assertEquals("  O--O-----------O  \n OO  O           OO \nOO     O4O1O1O4O WOO\nI  OOO O-O-O-O-OO  I\nI  OII         I   I\nI   IO-O O---O IO  I\nI  OII   O-O   I   I\nI   OO   O-O  YIO  I\nI  O---#O------OO  I\nOO  O2O2O3O2O2OOCQOO\n OO      B  D  A OO \n  O--------------O ",
				this.model.getMap());
		this.model.loadMap("MAP1");
		Assert.assertEquals(" O-----OO\nO+     QO--O\nI O---O   1O--O\nID       O   1O--O\nI O--O O   O    1O-O\nIA       O I   @  1I\nI O--O O   O    1O-O\nIC       O   1O--O\nI O---O   1O--O\nOY     WO--O\n O-----OO", 
				this.model.getMap());
	}

}
