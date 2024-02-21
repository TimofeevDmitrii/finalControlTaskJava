import java.util.ArrayList;
import java.util.List;

public class ToyStore {

    private List<StoreElement> allToys;

    public ToyStore() {
        this.allToys = new ArrayList<>();
    }

    public void addToyToStore(Toy toy, int quantity){
        if (toy!=null) {
            allToys.add(new StoreElement(toy, quantity));
            System.out.println("В хранилище добавлена новая игрушка: "+toy+", количество="+quantity);
        }
        else{
            throw new RuntimeException("Попытка добавить null в хранилище игрушек");
        }
    }


    public void setToyQuantity(int id, Integer toyQuantity){
        boolean findToyId=false;
        for (StoreElement storeElement: allToys){
            if (storeElement.getToy().getToyId()==id) {
                storeElement.setToyQuantity(toyQuantity);
                findToyId=true;
                break;
            }
        }
        if (!findToyId){
            System.out.println(String.format("Игрушки с id=%s нет в хранилище", id));
        }
    }


    public List<StoreElement> getAllToys(){
        return allToys;
    }


}
