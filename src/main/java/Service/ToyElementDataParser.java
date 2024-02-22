package Service;

import Data.Toy;
import Data.ToyStoreElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToyElementDataParser implements CreateToyElement {
    private int nextToyId=1;

    private boolean checkToyData(String toyData){
        Pattern pattern = Pattern.compile("^[а-яА-Я]{1,20}\\s\\d*\\.?\\d+\\s\\d+$");
        Matcher matcher = pattern.matcher(toyData);
        return matcher.find();
    }


    @Override
    public ToyStoreElement createToyElement(String toyData) {
        if (!checkToyData(toyData)){
            throw new IllegalArgumentException("Введены неверные данные для добавления игрушки в хранилище");
        }
        else {
            String[] splitToyData = toyData.split(" ");
            Toy newToy = new Toy(nextToyId++, splitToyData[0], Double.parseDouble(splitToyData[1]));
            return new ToyStoreElement(newToy, Integer.parseInt(splitToyData[2]));
        }
    }
}
