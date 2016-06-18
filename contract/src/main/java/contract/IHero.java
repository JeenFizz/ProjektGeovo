package contract;

public interface IHero extends IMobile {
    void move(MobileOrder order, IElement[][] tileMap, IView view);
   
}
