import Controller.ToyShopController;
import Model.ModelToyShop;
import View.ConsoleView;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) {


        ToyShopController controller = new Controller.ToyShopController(new ModelToyShop(), new ConsoleView());

        try {
            controller.addToyToLottery("1 Конструктор 2 50"); // на вход должна идет строка типа: "id_игрушки имя_игрушки вес_игрушки количество_в_хранилище"
            controller.addToyToLottery("2 Робот 2 50");
            controller.addToyToLottery("3 Кукла 6 80");
            controller.doToysLottery(20);
            controller.addToyToLottery("4 Корабль 4 80");
            controller.setToyWeight(2, 3);
            controller.setToyWeight(3, 5);
            controller.setToyQuantity(1, 65);
            controller.printToysBalanceInStore();
            controller.doToysLottery(20);
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String stackTraceString = sw.toString(); // Stack trace в формате строки!
            controller.putMessageToLog(stackTraceString);
        }finally {
            controller.endProgramWork();
        }


    }
}
