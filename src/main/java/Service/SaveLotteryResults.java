package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveLotteryResults {

    private File lotteryResults = new File("LotteryStatistics.txt");
    private StringBuilder lotteryLog;


    private String getDateTime(){
        LocalDateTime dateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateAndTime.format(formatter);
    }

    public void addMessageToLog(String message){
        if (lotteryLog==null) {
            lotteryLog = new StringBuilder();
            lotteryLog.append("_____program was started: "+getDateTime()+"_____\n\n");
        }
        lotteryLog.append(message+"\n");
    }

    public void saveResult(){
        lotteryLog.append("_____program was ended: "+getDateTime()+"_____\n\n");
        try (FileWriter fileWriter = new FileWriter(lotteryResults, true)){
            fileWriter.append(lotteryLog.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
