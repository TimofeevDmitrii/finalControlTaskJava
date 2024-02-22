package View;

import java.util.Scanner;

public class ConsoleView implements SendToConsole{
    @Override
    public void sendMessageToConsole(String message) {
        Scanner sc = new Scanner(message);
        while(sc.hasNextLine()){
            System.out.println("-->"+sc.nextLine());
        }
    }
}
