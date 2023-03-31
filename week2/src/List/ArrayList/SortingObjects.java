package List.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Java program to sort a given array list of custom objects
class Vegetable {
    private String name;
    private int pricePerKg;

    public Vegetable(String name, int pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public Vegetable(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PriceComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        if (o1.getPricePerKg() == o2.getPricePerKg())
            return 0;
        else if (o1.getPricePerKg() > o2.getPricePerKg())
            return 1;
        else
            return -1;
    }
}

public class SortingObjects {
    public static void main(String[] args) {
        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(new Vegetable("Carrot", 40));
        vegetables.add(new Vegetable("Tomato", 25));
        vegetables.add(new Vegetable("Potato", 20));
        vegetables.add(new Vegetable("Cabbage", 30));

        Collections.sort(vegetables, new PriceComparator());

        System.out.println("Price of vegetables from low to high: ");

        for (Vegetable vegetable : vegetables) {
            System.out.println(vegetable.getName() + " " + vegetable.getPricePerKg());
        }
    }
}
