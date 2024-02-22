package Data;

public class ToyStoreElement extends StoreElement {
    private Toy toy;

    public ToyStoreElement(Toy toy, int toyQuantity) {
        super(toyQuantity);
        super.setElementType("ToyStoreElement");
        this.toy = toy;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    @Override
    public String toString() {
        return super.getElementType()+"{" +
                "toy=" + toy +
                ", toyQuantity=" + super.getQuantity() +
                '}';
    }
}
