import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToyCreator implements CreateNewToy{
    private int nextToyId=1;

    private boolean checkToyData(String toyData){
        Pattern pattern = Pattern.compile("^[а-яА-Я]{1,20}\\s\\d{1,2}$");
        Matcher matcher = pattern.matcher(toyData);
        return matcher.find();
    }


    @Override
    public Toy createToy(String toyData) {
        if (!checkToyData(toyData)){
            throw new RuntimeException("Введены неверные данные для добавления игрушки");
        }
        else {
            String[] splitToyData = toyData.split(" ");
            System.out.println();
            return new Toy(nextToyId++, splitToyData[0], Double.parseDouble(splitToyData[1]));
        }
    }
}
