package designpatterns.behavioral.templatemethod;

// abstract class that contains template method
public abstract class Beverage {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected final void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    protected  final void pourInCup() {
        System.out.println("Pouring in Cup");
    }

    protected abstract void addCondiments();
}
