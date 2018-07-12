package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Timer;

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

    public void pauseMusic() {
        Main.mediaPlayer.pause();
    }

    public void playMusic() {

        Main.mediaPlayer.play();
    }

    public void sendVolume() {
        Main.mediaPlayer.setVolume(volumeSlider.getValue());
    }

    public void updateTime() {
        currentTime.setText(Main.Format(Main.mediaPlayer.getCurrentTime()));
    }
}