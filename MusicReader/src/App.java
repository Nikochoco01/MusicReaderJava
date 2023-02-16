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

         Playlist playlist = new Playlist();

         playlist.addMusic("MusicReader/src/music");
         playlist.addMusic("MusicReader/src/music2");
         System.out.println(playlist.toString());
         System.out.println(playlist.readIdPlaylist(2));

        //  Folder testFolder = new Folder("music2", "MusicReader/src/music2");
        //  testFolder.addMusic();
        //  System.out.println(testFolder.toString());
        //  System.out.println(testFolder.readIdPlaylist(0));

    }
}
