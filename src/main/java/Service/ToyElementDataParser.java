package Service;

import Data.Toy;
import Data.ToyStoreElement;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToyElementDataParser implements CreateToyElement {

    private boolean checkToyData(String toyData){
        Pattern pattern = Pattern.compile("^\\d+\\s[а-яА-Я]{1,20}\\s\\d*\\.?\\d+\\s\\d+$");
        Matcher matcher = pattern.matcher(toyData);
        return matcher.find();
    }


    @Override
    public ToyStoreElement createToyElement(String toyData) throws IOException{ // на вход должна прийти строка типа: "id_игрушки имя_игрушки вес_игрушки количество_в_хранилище"
        if (!checkToyData(toyData)){
            throw new IOException(String.format("Введены неверные данные для добавления игрушки в хранилище: %s", toyData));
        }
        else {
            String[] splitToyData = toyData.split(" ");
            Toy newToy = new Toy(Integer.parseInt(splitToyData[0]), splitToyData[1], Double.parseDouble(splitToyData[2]));
            return new ToyStoreElement(newToy, Integer.parseInt(splitToyData[3]));
        }
    }
}
