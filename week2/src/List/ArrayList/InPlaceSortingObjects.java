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

        Vegetables beetRoot = new Vegetables("Beet root", 40);
        vegetables.add(beetRoot);
        vegetables.remove(new Vegetables("Beet root", 40));
        
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vegetables other = (Vegetables) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pricePerKg != other.pricePerKg)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + pricePerKg;
        return result;
    }
}
