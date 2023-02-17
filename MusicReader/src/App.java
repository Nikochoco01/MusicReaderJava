import Model.*;
import Controller.*;
import View.*;

//import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {

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
}
