package Controller;

import Model.ModelToyShop;
import Model.ToyShopWithStore;
import View.SendToConsole;

import java.io.IOException;

public abstract class LotteryToysController {
    protected ToyShopWithStore model;
    protected SendToConsole view;

    public LotteryToysController(ToyShopWithStore model, SendToConsole view) {
        this.model = model;
        this.view = view;
    }


    public abstract void doToysLottery(int numberOfToys); // количество игрушек, которое нужно разыграть

    public abstract void addToyToLottery(String toyData) throws IOException;

    public abstract void setToyWeight(int id, double weight);
}
