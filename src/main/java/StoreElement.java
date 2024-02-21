public class StoreElement {
    private Toy toy;
    private int toyQuantity;

    public StoreElement(Toy toy, int toyQuantity) {
        this.toy = toy;
        this.toyQuantity = toyQuantity;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public int getToyQuantity() {
        return toyQuantity;
    }

    public void setToyQuantity(int toyQuantity) {
        if (toyQuantity>=0)
            this.toyQuantity = toyQuantity;
        else
            throw new RuntimeException("Количество игрушек не может быть отрицательным");
    }

    @Override
    public String toString() {
        return "StoreElement{" +
                "toy=" + toy +
                ", toyQuantity=" + toyQuantity +
                '}';
    }
}
