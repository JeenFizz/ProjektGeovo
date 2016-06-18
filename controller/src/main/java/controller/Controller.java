package controller;

import java.awt.*;

import java.util.*;
import contract.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController , Observer {

	/** The view. */
	private IView		view;
	
	/** THe array where is stocked maps */
	private IElement[][] tileMap;


	/** The model. */
	private IModel	model;
	
	private IHero hero;
	
	private HashMap<String, IMonster> monsters = new HashMap<String, IMonster>();
	
	 private boolean dead = false;

	 public IElement[][] getTileMap() {
	        return tileMap;
	    }

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.tileMap = this.parser(this.model.getMap());
        this.hero = (IHero) model.element('L', new Point());
        model.getObservable().addObserver(this);
	}

	private void printTileMap(IElement[][] tileMap) {
        System.out.println("[");
        for(int i =0; i < tileMap.length; i++) {
            System.out.print("    [");
            for(int j = 0; j < tileMap[0].length; j++) {
                System.out.print(tileMap[i][j].getClass().getSimpleName()
                        + ", ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#start()
	 */
	public void start() {
        this.orderPerform(ControllerOrder.MENU);

        // Game Loop
        while (true) {
           

            if(this.dead) {
                System.out.println("DEAD");
                this.hero = null;
            }

            for (Object o : this.monsters.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                IMonster monster = (IMonster) pair.getValue();
                this.moveMonster(monster);
            }

            this.view.repaint();

            try {
                Thread.sleep(300);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	/**
     * Parse tileMap to associate a Letter to a sprite
     *
     * @param tilemap TileMap in text format (with letter)
     * @see contract.IController#parser(String)
     */
    public IElement[][] parser(String tilemap) {
        String[] lines = tilemap.split("\n");
        int x = lines.length;
        int y = lines[0].length();
        IElement[][] map = new IElement[x][y];

        this.monsters.clear();

        for(IElement[] row: map)
            Arrays.fill(row, this.model.element(' ', null));


        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                char c = lines[i].charAt(j);
				Point pos = new Point(i, j);

                IElement element = this.model.element(c, pos);
                if(c == 'L') { //L @
                    this.dead = false;
                    this.hero = (IHero) element;
                }
                if(c == '1' || c == '2' || c == '3' || c == '4') { // 1 2 3 4 ABCD
                    IMonster monster = (IMonster) element;
                    this.monsters.put(monster.getClass().getSimpleName(), monster);
                }

                if (element != null) {
                    map[i][j] = element;
                }
            }
        }

        return map;
	}
	

	/**
	 * @param controllerOrder Load map from model
	 * 
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		if (controllerOrder == null)
            return;
		
		switch (controllerOrder) {
        case MAP1:
			this.model.loadMap("MAP1");
			break;
        case MAP2:
			this.model.loadMap("MAP2");
			break;
        case MAP3:
			this.model.loadMap("MAP3");
			break;
        case MAP4:
			this.model.loadMap("MAP4");
			break;
        case MAP5:
            this.model.loadMap("MAP5");
            break;
        case MENU:
            this.model.loadMap("MENU");
            break;

      // USER ACTIONS      
        case MOVEDOWN:
            this.moveHero(MobileOrder.Down);
            break;
        case MOVEUP:
            this.moveHero(MobileOrder.Up);
            break;
        case MOVERIGHT:
            this.moveHero(MobileOrder.Right);
            break;
        case MOVELEFT:
            this.moveHero(MobileOrder.Left);
            break; 
            
        case MOVELEFTUP:
            this.moveHero(MobileOrder.LeftUp);
            break;
        case MOVERIGHTUP:
            this.moveHero(MobileOrder.RightUp);
            break;
        case MOVERIGHTDOWN:
            this.moveHero(MobileOrder.RightDown);
            break;
        case MOVELEFTDOWN:
            this.moveHero(MobileOrder.LeftDown);
            break;
        
		default:
            this.model.loadMap("TEST");
			break;
		}
		
	}
	
		/** Checks if the hero is trying to move out of the
		 *  map then checks if it encounters an object which permeability is blocking 
		 *  then applies the position change if the hero can move*/
		private void moveHero(MobileOrder order) {
	        Point pos = this.hero.getPos();
	        this.hero.move(order, tileMap, this.view);
	        this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

	        pos = this.hero.getPos();
	        if(this.tileMap[pos.x][pos.y].getClass()
	                .getSimpleName().contains("Monster")) {
	            this.dead = true;
	        }
	        this.tileMap[pos.x][pos.y] = this.hero;
	        this.view.repaint();
	    }
		
		
		private void moveMonster(IMonster monster) {
	        Point pos = monster.getPos().getLocation();
	        Point nextPos = this.computeNextPos(
	                monster.getDirection(
	                        this.hero.getPos().getLocation(),
	                        this.tileMap),
	                pos);
	        if(nextPos != pos) {
	            String element = tileMap[nextPos.x][nextPos.y].getClass()
	                    .getSimpleName();
	            if(element.contains("Hero")) {
	                this.dead = true;
	            } else if(!element.contains("Monster") &&
	                    !element.contains("Purse") &&
	                    !element.contains("Door") &&
	                    !element.contains("Crystal")) {
	                tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());
	                monster.setLocation(nextPos);
	                tileMap[nextPos.x][nextPos.y] = monster;
	            }
	        }
	    }
		
		
		/**
		 * test if the next position is possible or no
		 * @param direction
		 * @param currentPos
		 * @return
		 */
		
		
		private Point computeNextPos(MobileOrder direction, Point currentPos) {
	        Point nextPos = currentPos.getLocation();

	        if(direction == null)
	            return nextPos;

	        switch (direction) {
	            case Left:
	                if(currentPos.y > 0 &&
	                        tileMap[currentPos.x][currentPos.y - 1].getPermeability())
	                {
	                    nextPos = new Point(
	                            currentPos.x,
	                            currentPos.y - 1);
	                }
	                break;
	            case Right:
	                if(currentPos.y < (view.getWidth() / 32) - 1 &&
	                        tileMap[currentPos.x][currentPos.y + 1].getPermeability())
	                {
	                    nextPos = new Point(
	                            currentPos.x,
	                            currentPos.y + 1);
	                }
	                break;
	            case Up:
	                if(currentPos.x > 0 &&
	                        tileMap[currentPos.x - 1][currentPos.y].getPermeability()) {
	                    nextPos = new Point(
	                            currentPos.x - 1,
	                            currentPos.y);
	                }
	                break;
	            case Down:
	                if(currentPos.x < (view.getHeight() / 32) - 1 &&
	                        tileMap[currentPos.x + 1][currentPos.y].getPermeability()) {
	                    nextPos = new Point(
	                            currentPos.x + 1,
	                            currentPos.y);
	                }
	                break;
	            case LeftUp:
	                if(currentPos.y > 0 && currentPos.x > 0 &&
	                        tileMap[currentPos.x - 1][currentPos.y - 1].getPermeability())
	                {
	                    nextPos = new Point(
	                            currentPos.x - 1,
	                            currentPos.y - 1);
	                }
	                break;
	            case RightUp:
	                if(currentPos.y < (view.getWidth() / 32) - 1 && currentPos.x > 0 &&
	                        tileMap[currentPos.x - 1][currentPos.y + 1].getPermeability())
	                {
	                    nextPos = new Point(
	                            currentPos.x - 1,
	                            currentPos.y + 1);
	                }
	                break;
	            case RightDown:
	                if(currentPos.y < (view.getWidth() / 32) - 1 && currentPos.x < (view.getHeight() / 32) - 1 &&
	                        tileMap[currentPos.x + 1][currentPos.y + 1].getPermeability())
	                {
	                    nextPos = new Point(
	                            currentPos.x + 1,
	                            currentPos.y + 1);
	                }
	                break;
	            case LeftDown:
	                if(currentPos.y > 0 && currentPos.x < (view.getHeight() / 32) - 1 &&
	                        tileMap[currentPos.x + 1][currentPos.y - 1].getPermeability())
	                {
	                    nextPos = new Point(
	                            currentPos.x + 1,
	                            currentPos.y - 1);
	                }
	                break;
	        }
	        return nextPos;
	    }
		
		/**
		 * update map with an Observer
		 * @param o
		 * @param arg
		 */
		 public void update(Observable o, Object arg) {
		        this.tileMap = parser(model.getMap());
		        this.view.repaint();
		    }

			

}
