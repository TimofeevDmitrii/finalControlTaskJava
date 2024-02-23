package Controller;

import Data.ToyStoreElement;
import Model.ModelToyShop;
import Service.SaveLotteryResults;
import View.SendToConsole;

import java.io.IOException;


public class ToyShopController extends LotteryToysController {
    private final SaveLotteryResults saver = new SaveLotteryResults("ToysLotteryResult.txt");

    public ToyShopController(ModelToyShop model, SendToConsole view) {
        super(model, view);
    }

    private void sendToConsoleAndLog(String message){
        view.sendMessageToConsole(message);
        saver.addMessageToLog(message);
    }

    public void putMessageToLog(String message){
        saver.addMessageToLog(message);
        view.sendMessageToConsole(String.format("Сообщение будет сохранено в файл: \"%s\"",message));
    }

    private String getToysBalanceInStore(){
        String toysBalance = "";
        for (ToyStoreElement elem: model.getAllToysQuantity()){
            toysBalance+=elem.toString()+"\n";
        }
        return toysBalance;
    }

    public void printToysBalanceInStore(){
        String mess = getToysBalanceInStore();
        view.sendMessageToConsole(mess);
    }

    public void endProgramWork(){
        saver.saveResult();
    }


    @Override
    public void addToyToLottery(String toyData) throws IOException {
        sendToConsoleAndLog(model.putToyToStore(toyData));
    }


    @Override
    public void setToyWeight(int id, double weight) {
        sendToConsoleAndLog(model.changeToyWeight(id, weight));
    }

    @Override
    public void doToysLottery(int numberOfToys) {
        sendToConsoleAndLog(model.getPrize(numberOfToys));
        String mess="Баланс игрушек в хранилище после розыгрыша: \n";
        mess+= getToysBalanceInStore();
        sendToConsoleAndLog(mess);
    }

}
