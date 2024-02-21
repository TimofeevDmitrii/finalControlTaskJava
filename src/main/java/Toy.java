public class Toy implements Comparable<Toy>{

    protected int toyNumber;
    protected String toyName;
    protected int toyWeight;

    public Toy(int toyNumber, String toyName, int toyWeight){
        this.toyNumber=toyNumber;
        this.toyName=toyName;
        this.toyWeight = toyWeight;
    }

    @Override
    public String toString() {
        return "{"+ toyNumber+" "+toyName+" "+ toyWeight +"}";
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
