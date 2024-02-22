package Data;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {

    private List<ToyStoreElement> allToys;

    public ToyStore() {
        this.allToys = new ArrayList<>();
    }

    public void addToyToStore(ToyStoreElement newToyElement){
        allToys.add(newToyElement);
        System.out.println("В хранилище добавлена новая игрушка: "+newToyElement.getToy()+
                ", количество="+newToyElement.getQuantity());
    }


    public void setToyQuantity(int id, int toyQuantity){
        boolean findToyId=false;
        for (ToyStoreElement toyStoreElement : allToys) {
            if (toyStoreElement.getToy().getToyId() == id) {
                toyStoreElement.setQuantity(toyQuantity);
                findToyId = true;
                break;
            }
        }
        if (!findToyId){
            System.out.printf("Игрушки с id=%s нет в хранилище%n", id);
        }
    }


    public void setToyWeight(int id, double toyWeight){
        boolean findToyId=false;
        for (ToyStoreElement allToy : allToys) {
            if (allToy.getToy().getToyId() == id) {
                allToy.getToy().setToyWeight(toyWeight);
                findToyId = true;
                break;
            }
        }
        if (!findToyId){
            System.out.printf("Игрушки с id=%s нет в хранилище", id);
        }
    }


    public List<ToyStoreElement> getAllToysInStore(){
        return allToys;
    }


}
