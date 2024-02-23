package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class SaveLottery {

    protected File lotteryResults;
    protected StringBuilder lotteryLog;

    public SaveLottery(String fileName) {
        this.lotteryResults = new File(fileName);
    }

    public abstract void addMessageToLog(String message);

    public abstract void saveResult();

}
