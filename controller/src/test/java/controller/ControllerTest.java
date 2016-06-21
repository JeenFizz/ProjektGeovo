package controller;


import static org.junit.Assert.*;

import java.awt.Point;

import javax.swing.text.View;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import contract.*;




public class ControllerTest {
	
	private IModel model;
    private IView view;
    private IController controller;
    private IElement[][] expectedMap;
	
	 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
        this.view = new View(this.model);
        this.controller = new Controller(this.view, this.model);
        this.view.setController(controller);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
    public void TestOrderPerformMAP1() throws Exception {
        this.controller.orderPerform(ControllerOrder.MAP1);
        assertEquals(1, this.controller.getLevel());
        assertEquals("O---O--------------O\n" + "I   I              I\n" + "I I I     -O--O-O  I\n" +
        "Y I   O--- I  I I  I\n" + "O-O-O I111O-O-O O- I\n" + "I   I O---I@I   I  I\n" + "I I I I I I I --O -O\n" +
        		"I I I I     I   I  I\n" + "I IQI I I1I O-- I  I\n" + "I O-O-O O-O      --O\n" +"I         I        I",
                this.model.getMap());
}

	

	@Test
	public void testController() {
		assertNotNull(view);
		assertNotNull(model);
		
	}

	@Test
	public void testStart() {
		fail("Not yet implemented");
		
	}

	
	
	
	@Test
	public void testParser() throws Exception {
        IElement[][] map = this.controller.parser("BVHPL\n" +
                "1234 \n" +
                "CO   ");

        assertEquals(this.expectedMap.length, map.length);
        for (int i = 0; i < map.length; i++){
            assertEquals(this.expectedMap[i].length, map[i].length);
            for (int j = 0; j < map[i].length; j++){
                assertEquals(this.expectedMap[i][j].getClass().getCanonicalName(),
                        map[i][j].getClass().getCanonicalName());
            }
        }
}
	
	 @Test
	    public void TestParserLoadMap() throws Exception {
	        this.model.loadMap("TEST");
	        IElement[][] map = this.controller.parser(
	                this.model.getMap()
	        );

	        assertEquals(this.expectedMap.length, map.length);
	        for (int i = 0; i < map.length; i++){
	            assertEquals(this.expectedMap[i].length, map[i].length);
	            for (int j = 0; j < map[i].length; j++){
	                assertEquals(this.expectedMap[i][j].getClass().getCanonicalName(),
	                        map[i][j].getClass().getCanonicalName());
	            }
	        }
	    }

	    @Test
	    public void TestComputeNextPosUp() throws Exception {
	        this.controller.orderPerform(ControllerOrder.MAP1);
	        Point nextPos = this.controller.computeNextPos(
	                MobileOrder.Up,
	                new Point(5, 5)
	        );
	        assertEquals(
	                new Point(4, 5),
	                nextPos
	        );
	}

	  

	

}
