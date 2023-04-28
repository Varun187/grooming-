package designpatterns.behavioral.templatemethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("***********Preparing coffee*************");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println("***********Preparing tea*************");
        Beverage tea = new Tea();
        tea.prepareRecipe();
    }
}
