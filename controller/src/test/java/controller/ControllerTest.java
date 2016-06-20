package controller;


import static org.junit.Assert.*;

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
	public void testController() {
		assertNotNull(view);
		assertNotNull(model);
		
	}

	@Test
	public void testStart() {
		fail("Not yet implemented");
		//tester si mon level est entre 1 et 5
		//tester si l'on passe au niveau suivant
		//testet si l'appui sur une touche 
		// tester si le joueur s'est bien deplacé
		//tester si le joueur est sur la map
		//pour les getteurs faire des assertsNotnUll
	}

	
	
	
	@Test
	public void testParser() {
		fail("Not yet implemented");
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
	        this.controller.orderPerform(ControllerOrder.WORKSHOP);
	        Point nextPos = this.controller.computeNextPos(
	                MobileOrder.Up,
	                new Point(5, 5)
	        );
	        assertEquals(
	                new Point(4, 5),
	                nextPos
	        );
	}

	@Test
	public void testOrderPerform() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
