import Model.*;
// import Controller.*;
import View.*;




import javafx.application.Application;
import javafx.stage.Stage;


//import java.io.File;

public class App extends Application{
    public static void main(String[] args) throws Exception {

        // fonction to start the web view
        launch(args);

        // File MeloReader = new File("C:\\Users\\Nikochoco01\\Documents\\MeloReader-Playlist");

        // boolean res = MeloReader.mkdir();

        // if(res) {
        //   System.out.println("Le dossier a été créé.");
        // }
        // else {
        //   System.out.println("Le dossier existe déjà.");
        // }

        //  Playlist playlist = new Playlist();

        //  playlist.addMusic("MusicReader/src/music");
        //  playlist.addMusic("MusicReader/src/music2");
        //  System.out.println(playlist.toString());


        //  System.out.println(playlist.readIdPlaylist(3));

        //  System.out.println(playlist.readNext());
        //  System.out.println(playlist.readPrevious());


         Folder testFolder = new Folder("2022", "E:/Music/2022");
         testFolder.addMusic();
         System.out.println(testFolder.toString());
        //  System.out.println(testFolder.readIdPlaylist(1));

        // System.out.println(testFolder.readNext());
        // System.out.println(testFolder.readPrevious());

        // Folder testFolder3 = new Folder("music3", "MusicReader/src/music3");
        // testFolder3.addMusic();
        // System.out.println(testFolder3.toString());
    }

    @Override
    public void start(Stage stage) throws Exception {
        View view = new View();
        view.loadView("file:///D:/DEV/MusicReaderJava/MusicReader/src/View/webView.html");
        view.showView();
    }
}
