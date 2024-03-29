package Model;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Folder extends Playlist{
    private String name;
    private String path;
    private int counter; // count the number of element in playlist this is equally the id of music in playlist
    private List<Music> content = new ArrayList<Music>();
    private int musicLoaded;

    public int getMusicLoaded() {
        return musicLoaded;
    }

    public Folder(String name , String path){
            this.name = name;
            this.path = path;
            this.counter = 1;
            this.musicLoaded = 1;
    }

    public List<Music> getContent() {
        return content;
    }

    public void addMusic() throws IOException{
        Path folderPath = Paths.get(this.path);
        try(DirectoryStream<Path> folderStream = Files.newDirectoryStream(folderPath , "*.{mp3}")){
            for(Path file : folderStream){
                Music music = new Music(file.toString());
                music.setId(counter);
                content.add(music);
                counter++;
            }
        }
    }

    @Override
    public String toString() {
        return "Folder [name=" + name + ", path=" + path + ", content=" + content + "]";
    }

    @Override
    public Music readIdPlaylist(int id) {
        return super.readIdPlaylist(id);
    }

    @Override
    public void removeFromPlaylist(int id) {
        super.removeFromPlaylist(id);
    }

    @Override
    public Music readNext() {
       return super.readNext();
    }

    @Override
    public Music readPrevious() {
       return super.readPrevious();
    }

    @Override
    public void setMusicLoaded(int musicLoaded) {
        super.setMusicLoaded(musicLoaded);
    }
}
