package contract;

/**
 * 
 * @author Alex GUILBAUD
 *
 */
public interface IHero extends IMobile {
    void move(MobileOrder order, IElement[][] tileMap, IView view);
   
}
