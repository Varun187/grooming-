package List.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java program to sort a given array list of custom objects
public class InPlaceSortingObjects {

    public static void main(String[] args) {
        List<Vegetables> vegetables = new ArrayList<>();
        vegetables.add(new Vegetables("Carrot", 40));
        vegetables.add(new Vegetables("Tomato", 25));
        vegetables.add(new Vegetables("Potato", 20));
        vegetables.add(new Vegetables("Cabbage", 30));

        Collections.sort(vegetables);

        System.out.println("Price of vegetables from low to high: ");

        for (Vegetables vegetable : vegetables) {
            System.out.println(vegetable.getName() + " " + vegetable.getPricePerKg());
        }
    }
}

class Vegetables implements Comparable<Vegetables> {
    private String name;
    private int pricePerKg;

    public Vegetables(String name, int pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public Vegetables(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public int compareTo(Vegetables other) {
        if (this.pricePerKg == other.pricePerKg)
            return 0;
        else if (this.pricePerKg > other.pricePerKg)
            return 1;
        else
            return -1;
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
