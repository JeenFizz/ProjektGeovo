package contract;

public interface ISpell extends IMobile {
    void setDirection(MobileOrder direction);
    int getStep();
    void animate();
}
