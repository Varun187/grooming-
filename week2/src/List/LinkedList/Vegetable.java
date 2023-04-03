package List.LinkedList;

public class Vegetable implements Comparable<Vegetable>{
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

    @Override
    public int compareTo(Vegetable other) {
        if (this.pricePerKg == other.pricePerKg)
            return 0;
        else if (this.pricePerKg > other.pricePerKg)
            return 1;
        else
            return -1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + pricePerKg;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vegetable other = (Vegetable) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pricePerKg != other.pricePerKg)
            return false;
        return true;
    }

    
}
