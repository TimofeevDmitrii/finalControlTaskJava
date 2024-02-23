package Model;

import Data.ToyStoreElement;
import Service.ToyStore;

import java.io.IOException;
import java.util.List;

public abstract class ToyShopWithStore {

    protected ToyStore toyStore = new ToyStore();

    public abstract String getPrize(int numberOfPlays);

    public abstract String putToyToStore(String toyData) throws IOException;

    public abstract List<ToyStoreElement> getAllToysQuantity();

    public abstract String changeToyWeight(int id, double weight);

    public abstract String changeToyQuantity(int id, int quantity);

}
