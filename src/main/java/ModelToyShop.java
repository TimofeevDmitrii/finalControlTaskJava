import Data.Toy;
import Data.ToyElementDataParser;
import Data.ToyStore;
import Data.ToyStoreElement;

import java.util.*;

public class ModelToyShop {

    private final ToyStore toyStore= new ToyStore();
    private final ToyElementDataParser toyDataParser = new ToyElementDataParser();

    public void getPrize(int numberOfPlays){
        HashMap<Toy,Integer> resultPrizesMap = new HashMap<>();
        int count=0;
        while (count!=numberOfPlays){
            Toy resultPrize=null;
            while(resultPrize==null) {
                resultPrize=toyLottery();
            }
            if (resultPrizesMap.containsKey(resultPrize))
                resultPrizesMap.put(resultPrize, resultPrizesMap.get(resultPrize)+1);
            else
                resultPrizesMap.put(resultPrize, 1);
//            System.out.println(count+"-->"+resultPrize);
            count++;
        }
        double totalWeight=0;
        for (Map.Entry<Toy,Integer> entry: resultPrizesMap.entrySet()){
            totalWeight+=entry.getKey().getToyWeight();
        }
        StringBuilder sb = new StringBuilder(String.format("Было произведено %s розыгрышей",numberOfPlays));
        sb.append("Результат розыгрыша игрушек:\n");
        for (Map.Entry<Toy,Integer> entry: resultPrizesMap.entrySet()){
            sb.append(entry.toString()+" выпадений");
            sb.append("("+String.format("%.2f",(double)100*entry.getValue()/numberOfPlays)+"%)");
            sb.append("/ожидалось "+String.format("%.2f",100*entry.getKey().getToyWeight()/totalWeight)+"%\n");
        }
        System.out.println(sb.toString());
    }

    // строка типа: "имя_игрушки вес_игрушки количество_в_хранилище"
    public void putToyToStore(String toyData){
        toyStore.addToyToStore(toyDataParser.createToyElement(toyData));
    }

    private List<Toy> getToysForLottery(){
        List<Toy> toysForLottery = new ArrayList<>();
        for (ToyStoreElement toyStoreElement: toyStore.getAllToysInStore()){
            if (toyStoreElement.getQuantity()!=0){
                toysForLottery.add(toyStoreElement.getToy());
            }
        }
        return toysForLottery;
    }

    private Toy toyLottery(){

        PriorityQueue<Toy> toyPriorityQueue = new PriorityQueue<>(getToysForLottery());
//        System.out.println(toyPriorityQueue);
        double totalWeight=0;
        for (Toy toy: toyPriorityQueue){
            totalWeight+=toy.getToyWeight();
        }

        Random rnd = new Random();
        double rndWeight = rnd.nextDouble()*totalWeight;
//        System.out.println("--> rndWeight="+rndWeight);

//        Toy prize = null;
//        double weightSum=0;
//        while (!toyPriorityQueue.isEmpty()){
//            Toy currToy = toyPriorityQueue.poll();
//            weightSum+= currToy.getToyWeight();
//            if (rndWeight<=weightSum) {
//                prize = currToy;
//                break;
//            }
//        }
//        return prize;

        Toy prize = null;
        while (!toyPriorityQueue.isEmpty()){
            Toy currToy = toyPriorityQueue.poll();
//            System.out.println(currToy);
            if (rndWeight<=currToy.getToyWeight()) {
                prize = currToy;
                break;
            }
            rndWeight-=currToy.getToyWeight();
        }
        return prize;
    }


}
