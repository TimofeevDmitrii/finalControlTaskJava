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

    public void setToyWeight(int toyWeight) {
        this.toyWeight = toyWeight;
    }

    @Override
    public String toString() {
        return "{"+"id="+toyId+", name="+toyName+", weight="+ toyWeight +"}";
    }

    @Override
    public int compareTo(Toy toy) {
        if (this.toyWeight < toy.toyWeight)
            return -1;
        else if (this.toyWeight == toy.toyWeight)
            return 0;
        else
            return 1;
    }
}
