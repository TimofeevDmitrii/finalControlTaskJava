import Data.Toy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static File gettingToys = new File("Toys.txt");


    public static void saveResult(String message){
            try (FileWriter fileWriter = new FileWriter(gettingToys)){
                fileWriter.append(message);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        ModelToyShop model = new ModelToyShop();


//        model.putToyToStore("Вертолет 3 10");
//        model.putToyToStore("Танк 4.5 10");
//        model.putToyToStore("Самолет 2 10");
//        model.putToyToStore("Робот 6 10");

        model.putToyToStore("Конструктор 3 10");
        model.putToyToStore("Робот 4 10");
        model.putToyToStore("Робот 2 10");
        model.putToyToStore("Кукла 6 10");


        model.getPrize(553);




//        Toy doll = new Toy(1, "Кукла", 2);
//        Toy robot = new Toy(2, "Робот", 6);
//        Toy constructor = new Toy(3, "Конструктор", 2);
//        Toy helicopter = new Toy(4, "Вертолет", 3);
//
//        int totalWeight = doll.toyWeight + robot.toyWeight + constructor.toyWeight + helicopter.toyWeight;
//
//        HashMap<Toy, ArrayList<Integer>> weightNumbers = new HashMap<>();
//        weightNumbers.put(doll, new ArrayList<>());
//        weightNumbers.put(robot, new ArrayList<>());
//        weightNumbers.put(constructor, new ArrayList<>());
//        weightNumbers.put(helicopter, new ArrayList<>());
//
//        int count = 1;
//        for (Toy toy : weightNumbers.keySet()) {
//            for (int i = 0; i < toy.toyWeight; i++) {
//                weightNumbers.get(toy).add(count++);
//            }
//        }
//        System.out.println(weightNumbers);
//
//
//        HashMap<Toy, Integer> results = new HashMap<>();
//        results.put(doll, 0);
//        results.put(robot, 0);
//        results.put(constructor, 0);
//        results.put(helicopter, 0);
//
//
//        int rndNumber;
//
//        int k=0;
//        while(k!=1000){
//            rndNumber = 1 + (int) (Math.random() * totalWeight); // генерируем числа от 1 до 10:
//            for (Toy toy: weightNumbers.keySet()){
//                if (weightNumbers.get(toy).contains(rndNumber)) {
//                    results.put(toy,results.get(toy)+1);
//                    break;
//                }
//            }
//            k++;
//        }
//
//        System.out.println(results);
//

    }
}
