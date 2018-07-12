package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import java.util.Timer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller {

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Slider volumeSlider;

    @FXML
    Label currentTime;

    @FXML
    public void initialize() {
        Updater updater = new Updater(this);
        Timer timer = new Timer();
        timer.schedule(updater,0,1000);
    }

    public void sendMsg() {
        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }


    public void stopMusic() {
        Main.mediaPlayer.stop();
    }

    public void pauseMusic() {
        Main.mediaPlayer.pause();
    }

    public void playMusic() {

        System.out.println(Main.mediaPlayer.getStatus());
        if (Main.mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED || Main.mediaPlayer.getStatus() == MediaPlayer.Status.READY ) {
            Main.mediaPlayer.play();
        }
        if (Main.mediaPlayer.getStatus() == MediaPlayer.Status.STOPPED) {
            Main.mediaPlayer.stop();
            Main.mediaPlayer.setStartTime(Duration.ZERO);
            Main.mediaPlayer.play();
        }
    }

    public void sendVolume() {
        Main.mediaPlayer.setVolume(volumeSlider.getValue());
    }

    public void updateTime() {
        currentTime.setText(Main.Format(Main.mediaPlayer.getCurrentTime()));
    }
}