package Model;

import Data.Toy;
import Service.ToyElementDataParser;
import Data.ToyStoreElement;

import java.io.IOException;
import java.util.*;

public class ModelToyShop extends ToyShopWithStore{

    private final ToyElementDataParser toyDataParser = new ToyElementDataParser();

    @Override
    public String getPrize(int numberOfPlays) {
        List<Toy> toysListForLottery = getToysForLottery();
        if (toysListForLottery.isEmpty())
            return "Розыгрыша не будет: в хранилище совсем нет игрушек =(\n";
        else {
            StringBuilder sb = new StringBuilder("Розыгрыш стартовал!!!\n");
            HashMap<Toy, Integer> resultPrizesMap = new HashMap<>();
            int count = 0;
            while (count < numberOfPlays && !toysListForLottery.isEmpty()) {
                Toy resultPrize;
                resultPrize = toyLottery(toysListForLottery);
                sb.append(String.format("Вызов %d: выпала игрушка %s\n", count+1, resultPrize));
                int currPrizeId = resultPrize.getToyId();
                int currPrizeQuantity = toyStore.getToyQuantity(currPrizeId);
                toyStore.setToyQuantity(currPrizeId, --currPrizeQuantity);

                if (resultPrizesMap.containsKey(resultPrize))
                    resultPrizesMap.put(resultPrize, resultPrizesMap.get(resultPrize) + 1);
                else
                    resultPrizesMap.put(resultPrize, 1);

                count++;
                toysListForLottery = getToysForLottery();
                if (toysListForLottery.isEmpty() && count < numberOfPlays)
                    sb.append(String.format("Игрушек не хватило для требуемого количества розыгрышей(%d)!\n",numberOfPlays) );
            }
            double totalWeight = 0;
            for (Map.Entry<Toy, Integer> entry : resultPrizesMap.entrySet()) {
                totalWeight += entry.getKey().getToyWeight();
            }
            sb.append(String.format("Было произведено %d розыгрышей\n", count));
            sb.append("Статистика розыгрыша игрушек в текущем сете:\n");
            for (Map.Entry<Toy, Integer> entry : resultPrizesMap.entrySet()) {
                sb.append(entry.toString() + " выпадений");
                sb.append("(" + String.format("%.2f", (double) 100 * entry.getValue() / count) + "%)");
                sb.append("/ожидалось " + String.format("%.2f", 100 * entry.getKey().getToyWeight() / totalWeight) + "%\n");
            }
            return sb.toString();
        }
    }



    @Override
    public String putToyToStore(String toyData) throws IOException {  // на вход должна прийти строка типа: "id_игрушки имя_игрушки вес_игрушки количество_в_хранилище"
        return toyStore.addToyToStore(toyDataParser.createToyElement(toyData));
    }

    @Override
    public List<ToyStoreElement> getAllToysQuantity() {
        return toyStore.getAllToysInStore();
    }

    @Override
    public String changeToyWeight(int id, double weight) {
        return toyStore.setToyWeight(id, weight);
    }

    @Override
    public String changeToyQuantity(int id, int quantity) {
        return toyStore.setToyQuantity(id, quantity);
    }


    private List<Toy> getToysForLottery() {
        List<Toy> toysForLottery = new ArrayList<>();
        for (ToyStoreElement toyStoreElement : toyStore.getAllToysInStore()) {
            if (toyStoreElement.getQuantity() != 0) {
                toysForLottery.add(toyStoreElement.getToy());
            }
        }
        return toysForLottery;
    }

    private Toy toyLottery(List<Toy> toysList) {

        PriorityQueue<Toy> toyPriorityQueue = new PriorityQueue<>(toysList);
        double totalWeight = 0;
        for (Toy toy : toyPriorityQueue) {
            totalWeight += toy.getToyWeight();
        }

        Random rnd = new Random();
        double rndWeight = rnd.nextDouble() * totalWeight;

        Toy prize = null;
            while (!toyPriorityQueue.isEmpty()) {
                Toy currToy = toyPriorityQueue.poll();
                if (rndWeight <= currToy.getToyWeight()) {
                    prize = currToy;
                    break;
                }
                rndWeight -= currToy.getToyWeight();
            }
        return prize;
    }

}
