package model.mobile;

import contract.IElement;

import contract.IHero;
import contract.IView;
import contract.MobileOrder;

import java.awt.*;

/**
 * 
 * @author Alex GUILBAUD
 *
 */
public class Hero extends Mobile implements IHero {
	
	
	
    public Hero(Point pos) {
                super("lorann_b.png", true, pos);
        }
    
    
    
    
/*
 * (non-Javadoc)
 * @see contract.IHero#move(contract.MobileOrder, contract.IElement[][], contract.IView)
 * move the hero in height position test the penetrability and change his sprite
 */
    public void move(MobileOrder order, IElement[][] tileMap, IView view)
    {
    	
        switch (order) {
            case Left:
                if(this.direction == MobileOrder.Left &&
                        this.pos.y > 0 &&
                        tileMap[this.pos.x][this.pos.y - 1].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX(),
                            this.pos.getY() - 1);
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_l.png");
                }
                break;
            case Right:
                if(this.direction == MobileOrder.Right &&
                        this.pos.y < view.getWidth() / 32 - 1 &&
                        tileMap[this.pos.x][this.pos.y + 1].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX(),
                            this.pos.getY() + 1);
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_r.png");
                }
                break;
            case Up:
                if(this.direction == MobileOrder.Up &&
                        this.pos.x > 0 &&
                        tileMap[this.pos.x - 1][this.pos.y].getPermeability()) {
                    this.pos.setLocation(
                            this.pos.getX() - 1,
                            this.pos.getY());
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_u.png");
                }
                break;
            case Down:
                if(this.direction == MobileOrder.Down &&
                        this.pos.x < view.getHeight() / 32 - 1 &&
                        tileMap[this.pos.x + 1][this.pos.y].getPermeability()) {
                    this.pos.setLocation(
                            this.pos.getX() + 1,
                            this.pos.getY());
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_b.png");
                }
                break;
            case LeftUp:
                if(this.direction == MobileOrder.LeftUp &&
                        this.pos.y > 0 && this.pos.x > 0 &&
                        tileMap[this.pos.x - 1][this.pos.y - 1].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX() - 1,
                            this.pos.getY() - 1);
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_ul.png");
                }
                break;
            case RightUp:
                if(this.direction == MobileOrder.RightUp &&
                		this.pos.y < view.getWidth() / 32 - 1 && this.pos.x > 0 &&
                        tileMap[this.pos.x - 1][this.pos.y + 1 ].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX() - 1,
                            this.pos.getY() + 1);
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_ur.png");
                }
                break;
                
            case RightDown:
                if(this.direction == MobileOrder.RightDown &&
                		this.pos.y < view.getWidth() / 32 - 1 && this.pos.x < view.getHeight() / 32 - 1 &&
                        tileMap[this.pos.x + 1][this.pos.y + 1 ].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX() + 1,
                            this.pos.getY() + 1);
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_br.png");
                }
                break;
            case LeftDown:
                if(this.direction == MobileOrder.LeftDown && 
                		this.pos.y > 0 && this.pos.x < view.getHeight() / 32 - 1 &&
                        tileMap[this.pos.x + 1][this.pos.y - 1 ].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX() + 1,
                            this.pos.getY() - 1);
                } else {
                    this.loadSprite("../model/src/main/java/model/sprite/lorann_bl.png");
                }
                break;
        }
        
        this.direction = order;
    }
}
