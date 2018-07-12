package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat");

        Scene scene = new Scene(root, 350, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

        Media sound = new Media(getClass().getResource("/Resurses/OneKiss.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.pause();

        mediaPlayer.setOnEndOfMedia(new Runnable() { @Override
        public void run() {
            mediaPlayer.play();
        }});
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
        System.exit(0);
    }

    public static String Format(Duration d) {
        final int seconds = (int) (d.toMillis() / 1000) % 60;
        final int minutes = (int) (d.toMillis() / (1000 * 60));
        return String.format("%02d:%02d", minutes, seconds);
    }


    public static void main(String[] args) {

        launch(args);
    }
}



