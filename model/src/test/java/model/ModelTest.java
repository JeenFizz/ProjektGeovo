package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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


	@Test
	public void testGetObservable() throws Exception {

	}

	@Test
	public void testGetMap() throws Exception {
		this.model.loadMap("MAP1");
		Assert.assertEquals("O---O--------------O\n" + 
							"I   I              I\n" + 
							"I I I     -O--O-O  I\n" +
							"Y I   O--- I  I I  I\n" + 
							"O-O-O I111O-O-O O- I\n" + 
							"I   I O---I@I   I  I\n" + 
							"I I I I I I I --O -O\n" +
							"I I I I     I   I  I\n" +
							"I IQI I I1I O-- I  I\n" +
							"I O-O-O O-O      --O\n" +
							"I         I        I\n" +
							"O---------O--------O", this.model.getMap());
	}

	@Test
	public void testLoadMap() throws Exception {

	}
}
