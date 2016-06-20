package controller;

import static org.junit.Assert.*;

import javax.swing.text.View;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import contract.IView;



public class ControllerTest {
	
	private Controller controller ;
	
	 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.controller = new Controller(new View(),new Model());
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
	public void testOrderPerform() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
