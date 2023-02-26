import Model.*;
import Controller.*;
import View.*;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

//import java.io.File;

public class App extends Application{


    public void start(Stage stage) throws Exception{
        View view = new View("file:///D:/DEV/MusicReaderJava/MusicReader/src/View/webView.html");
        Playlist playlist = new Playlist();
        Controller controller = new Controller(view, playlist);

        Scene scene = new Scene(view.getRoot() , 800 , 800);
        stage.setScene(scene);
        stage.show();
        controller.getWindow();
        // playlist.addMusic("E:/Music/2023");
        playlist.addMusic("C:/Users/Nikochoco01/Desktop");
    }
    public static void main(String[] args){
        launch(args);
    }
}