import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Playlist{
    private int counter; // count the number of element in playlist this is equally the id of music in playlist
    private List<Music> content = new ArrayList<Music>();

    public List<Music> getContent() {
        return content;
    }

    public Playlist() {
        this.counter = 0;
    }

    public String readIdPlaylist(int id){
        for(Music music : this.getContent()){
            if(music.getId() == id){
                return music.getId() + "~" + music.getTitle() + "~" + music.getAuthor() + "~" + music.getPicture() + "~" + music.getPath();
            }
        }
        return null;
    }

    public void removeFromPlaylist(int id){
        for(Music music : content){
            if(music.getId() == id){
               content.remove(music);
            }
        }
    }

    public void addMusic(String path) throws IOException{
        Path folderPath = Paths.get(path);
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
        return "Playlist [content=" + content + "]";
    }
}
