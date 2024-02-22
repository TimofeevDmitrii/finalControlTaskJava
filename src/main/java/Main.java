import Data.Toy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


//        ToyShopController controller = new ToyShopController();
//
//        controller.addToyToLottery("Конструктор 2 300");
//        controller.addToyToLottery("Робот 2 300");
//        controller.addToyToLottery("Кукла 6 700");
//
//        controller.doToysLottery(1000);

        ToyShopController controller = new ToyShopController();


//        controller.addToyToLottery("Танк 3 400");
//        controller.addToyToLottery("Самолет 2.3 300");
//        controller.addToyToLottery("Робот 1.7 200");
//        controller.addToyToLottery("Корабль 3 400");

        controller.doToysLottery(346);



    }
}
