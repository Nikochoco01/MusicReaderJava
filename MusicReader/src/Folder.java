import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private String path;
    private int counter;
    private List<Music> content = new ArrayList<Music>();

   public Folder(String name , String path)throws IOException{
        this.name = name;
        this.path = path;
        this.counter = 0;

        getFile();
   }

   /* Allow to get file in folder 
    * 
    * IOException
    */
   public void getFile()throws IOException{
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
        return "Folder [name= " + name + ", path= " + path + ", content= " + content + "]";
    }
}
