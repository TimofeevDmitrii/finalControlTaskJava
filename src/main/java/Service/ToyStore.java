package Service;

import Data.Toy;
import Data.ToyStoreElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ToyStore {

    private List<ToyStoreElement> allToysElements;

    public ToyStore() {
        this.allToysElements = new ArrayList<>();
    }

    public String addToyToStore(ToyStoreElement newToyElement){
        int newToyId = newToyElement.getToy().getToyId();
        for (ToyStoreElement toyStoreElement: allToysElements){
            int currToyId = toyStoreElement.getToy().getToyId();
            if (currToyId==newToyId)
                return "Внимание: в хранилище уже существует игрушка с id="+currToyId+";\n"+
                        "Добавление элемента не выполнено:"+newToyElement;
        }

        HashSet<Toy> toySet = new HashSet<>();
        for (ToyStoreElement toyStoreElement: allToysElements){
            toySet.add(toyStoreElement.getToy());
        }
        if (toySet.contains(newToyElement.getToy()))
            return "Внимание: игрушка с названием \""+newToyElement.getToy().getToyName()+"\" уже есть в хранилище;\n"+
                    "Добавление элемента не выполнено:"+newToyElement;

        allToysElements.add(newToyElement);
        return "В хранилище добавлена новая игрушка: "+newToyElement.getToy()+
                ", количество="+newToyElement.getQuantity();
    }


    public int getToyQuantity(int id){
        for (ToyStoreElement toyStoreElement : allToysElements) {
            if (toyStoreElement.getToy().getToyId() == id) {
                return toyStoreElement.getQuantity();
            }
        }
//        System.out.printf("Игрушки с id=%s нет в хранилище%n", id);
        return -1;
    }


    public String setToyQuantity(int id, int toyQuantity){
        for (ToyStoreElement toyStoreElement : allToysElements) {
            if (toyStoreElement.getToy().getToyId() == id) {
                toyStoreElement.setQuantity(toyQuantity);
                return String.format("Количество игрушки изменено: %s", toyStoreElement);
            }
        }
        return String.format("Игрушки с id=%s нет в хранилище", id);
    }


    public String setToyWeight(int id, double toyWeight){
        for (ToyStoreElement toyStoreElement : allToysElements) {
            if (toyStoreElement.getToy().getToyId() == id) {
                toyStoreElement.getToy().setToyWeight(toyWeight);
                return String.format("Вес игрушки изменен: %s", toyStoreElement);
            }
        }
        return String.format("Игрушки с id=%s нет в хранилище", id);
    }


    public List<ToyStoreElement> getAllToysInStore(){
        return allToysElements;
    }


}
