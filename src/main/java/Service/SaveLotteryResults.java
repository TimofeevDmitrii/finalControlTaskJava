package Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveLotteryResults extends SaveLottery{

    public SaveLotteryResults(String fileName) {
        super(fileName);
    }

    @Override
    public void addMessageToLog(String message) {
        if (lotteryLog==null) {
            lotteryLog = new StringBuilder();
            lotteryLog.append("_____program was started: "+getDateTime()+"_____\n\n");
        }
        lotteryLog.append(message+"\n");
    }

    @Override
    public void saveResult() {
        if(lotteryLog!=null) {
            lotteryLog.append("_____program was ended: " + getDateTime() + "_____\n\n");
            try (FileWriter fileWriter = new FileWriter(lotteryResults, true)) {
                fileWriter.append(lotteryLog.toString());
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private String getDateTime(){
        LocalDateTime dateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateAndTime.format(formatter);
    }

}
