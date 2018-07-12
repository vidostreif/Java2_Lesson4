package sample;

import javafx.application.Platform;

import java.util.Date;
import java.util.TimerTask;

public class Updater extends TimerTask {
//    Date now = new Date();
    Controller contr;

    Updater(Controller contr){
        this.contr = contr;
    }

    @Override
    public void run(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                contr.updateTime();
            }
        });
    }

}
