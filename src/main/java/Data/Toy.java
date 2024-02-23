package Data;

import java.util.Objects;

public class Toy implements Comparable<Toy>{

    private int toyId;
    private String toyName;
    private double toyWeight;


    public Toy(int toyId, String toyName, double toyWeight){
        this.toyId = toyId;
        this.toyName=toyName;
        this.toyWeight = toyWeight;
    }

    public int getToyId() {
        return toyId;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public double getToyWeight() {
        return toyWeight;
    }

    public void setToyWeight(double toyWeight) {
        this.toyWeight = toyWeight;
    }

    @Override
    public String toString() {
        return "{"+"id="+toyId+", name="+toyName+", weight="+ toyWeight +"}";
    }

    @Override
    public int compareTo(Toy toy) {
        if (this.toyWeight < toy.toyWeight)  // если в этом случае возвращается -1, то будет восходящая очередь
            return -1;
        else if (this.toyWeight == toy.toyWeight)
            return 0;
        else
            return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy that = (Toy) o;
        return this.toyName.equals(that.toyName);
    }

    @Override
    public int hashCode() {
        int result = this.toyName == null ? 0 : this.toyName.hashCode();
        return result;
    }
}
