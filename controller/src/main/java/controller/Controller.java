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
	
	private ISpell Spell;
	
	private Point posDoor = null;
	
	private int level = 0;

    private int score = 0;
	
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
        this.hero = (IHero) model.element('@', new Point());
        model.getObservable().addObserver(this);
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
           

    /*  test if the hero is dead if it true show a die message and change the level to the first level and reset the score*/    	
            if(this.dead) {
                this.model.loadMap("MAP1");
                this.view.showdiemessage(String.format("YOU DIED! You made a score of : %d\nPress OK to restart the game", this.score));
                this.level = 1;
                this.score = 0;
            }

           
            for (Object o : this.monsters.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                IMonster monster = (IMonster) pair.getValue();
                this.moveMonster(monster);
            }

            /* repaint the map */
            this.view.repaint();

            try {
                Thread.sleep(300);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            if(this.Spell != null) {
                this.movespell();
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
        this.posDoor = null;

        for(IElement[] row: map)
            Arrays.fill(row, this.model.element(' ', null));


        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                char c = lines[i].charAt(j);
				Point pos = new Point(i, j);

                IElement element = this.model.element(c, pos);
                if(c == '@') { //Lorann
                    this.dead = false;
                    this.hero = (IHero) element;
                }
                if(c == 'A' || c == 'B' || c == 'C' || c == 'D') { // Monster A , B ,C ,D
                    IMonster monster = (IMonster) element;
                    this.monsters.put(monster.getClass().getSimpleName(), monster);
                }if(c == 'Y') {//Closed door
                    this.posDoor = pos.getLocation();
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
      //USER'S CALL OF LORANN'S SPELL 
            
        case SPELL:
            this.spell();
            break;
            
		default:
            this.model.loadMap("TEST");
			break;
		}
		
	}
	
		/* Checks if the hero is trying to move out of the
		 *  map then checks if it encounters an object which permeability is blocking 
		 *  then applies the position change if the hero can move*/
	/**
	 * 
	 * @param order
	 */
		private void moveHero(MobileOrder order) {
	        Point pos = this.hero.getPos();
	        this.hero.move(order, tileMap, this.view);
	        this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

	        pos = this.hero.getPos();
	        
	        String elementName = this.tileMap[pos.x][pos.y].getClass().getSimpleName();
	        /* test the next element for kill the hero if he meet the monster" , 
	         * open the door if he pick the crystal ball , 
	         * kill the hero if he attempts to go in the closed door
	         * if the hero go in the open door change level
	         * test if the level is superior than five and when is true show a Win message and restart the game 
	         * give point when you walk on a purse*/
	        if(elementName.contains("Monster")) {
	            this.dead = true;
	        } else if (elementName.contains("Crystal") && this.posDoor != null) {
	            this.tileMap[this.posDoor.x][this.posDoor.y] = model.element('X', this.posDoor);//X O
	        }else if(elementName.contains("ClosedDoor")) {
	            this.dead = true;
	        } else if (elementName.contains("OpenDoor")) {
	            this.level++;
	            if(this.level > 5) {
                    
                     this.view.Winmessage(String.format("CONGRATULATION ( ͡° ͜ʖ ͡°) ! You Win with : %d points \n But you can do better retry with OK button",  this.score));
                    this.score = 0;
                    this.level = 1;
                }
	            this.view.Winmessage(String.format("Now you Have %d points but go to the Next level",this.score));
	            this.model.loadMap(String.format("MAP%d", this.level));
	            return;
	        } else if (elementName.contains("Purse")) {
	            this.score += 650;
	        }
	        this.tileMap[pos.x][pos.y] = this.hero;
	        this.view.repaint();
	    }
		
		/**
		 * 
		 * @param monster
		 */
		/* */
		private void moveMonster(IMonster monster) {
	        Point pos = monster.getPos().getLocation();
	        Point nextPos = this.computeNextPos(
	                monster.getDirection(
	                        this.hero.getPos().getLocation(),
	                        this.tileMap),
	                pos);
	        if(nextPos != pos) {
	            String element = tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
	            /* Kill the hero if the monster go to on the hero*/
	            if(element.contains("Hero")) {
	                this.dead = true;
	               /* if the monster doesn't go to an another monster , a purse , a door or a crystal do the deplacement of the monster */
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
		 
		 /* the fireball spell
		  * set a F in the square */
		 
		 private void spell() {
		        if(this.Spell != null)
		            return;
		        this.endspell();
		        MobileOrder direction = this.hero.getDirection();
		        Point currentPos = this.hero.getPos().getLocation();
		        Point nextPos = this.computeNextPos(direction, currentPos);
		        if(!currentPos.equals(nextPos)) {
		            this.Spell = (ISpell) this.model.element('F', nextPos);
		            this.Spell.setDirection(direction);
		            this.checkspell(nextPos);
		            this.view.repaint();
		        }
		    }
		        
		    
		 /* move the fireball*/
		    private void movespell() {
		        Point currentPos = this.Spell.getPos().getLocation();
		        this.Spell.animate();//fireball animation go to spell class in model/mobile to see it*/
		        Point nextPos = this.computeNextPos(this.Spell.getDirection(), currentPos);

		        this.checkspell(nextPos);

		        this.tileMap[currentPos.x][currentPos.y] = model.element(' ', currentPos.getLocation());

		        if(this.Spell != null && this.Spell.getStep() > 5) { // range of 5 squares
		            this.endspell();
		        }
		    }
		    
		    /**
		     * 
		     *  
		     * @param nextPos
		     */
		    
		    /*
		     * check the next square of the fireball :
		     *  	if he meet an monster destroy it and add 500 points
		     */
		    
		    private void checkspell(Point nextPos) {
		        String nextElement = this.tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
		        if(nextElement.contains("Monster")) {
		            this.Spell.setLocation(nextPos);
		            this.tileMap[nextPos.x][nextPos.y] = this.Spell;
		            this.score += 500;
		            this.endspell();
		            System.out.println("Monster : " + this.monsters.remove(nextElement));
		        } else if(nextElement.contains("Door") ||
		                nextElement.contains("Purse") ||
		                nextElement.contains("Crystal")) {
		            this.Spell = null;
		        }
		        else {
		            this.Spell.setLocation(nextPos);
		            this.tileMap[nextPos.x][nextPos.y] = this.Spell;
		        }
		    }

		    /* destroy spell
		     * 
		     */
		    private void endspell() {
		        if(this.Spell != null) {
		            Point pos = this.Spell.getPos().getLocation();
		            this.tileMap[pos.x][pos.y] = this.model.element(' ', pos);
		            this.Spell = null;
		        }
		    }

			

}
