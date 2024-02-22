import Data.StoreElement;
import Service.SaveLotteryResults;
import View.ConsoleView;


public class ToyShopController {
    private final ModelToyShop model = new ModelToyShop();
    private final ConsoleView view = new ConsoleView();
    private final SaveLotteryResults saveToFile = new SaveLotteryResults();

    public void addToyToLottery(String toyData){
            String mess = model.putToyToStore(toyData);
            view.sendMessageToConsole(mess);
            saveToFile.addMessageToLog(mess);
        }

    public void doToysLottery(int numberOfToys){
            String mess = model.getPrize(numberOfToys);
            view.sendMessageToConsole(mess);
            saveToFile.addMessageToLog(mess);

            mess = "Остаток в хранилище на конец игры: \n";
            for (StoreElement elem: model.getAllToysQuantity()){
                mess+=elem.toString()+"\n";
            }
            view.sendMessageToConsole(mess);
            saveToFile.addMessageToLog(mess);

            saveToFile.saveResult();
         }

}
