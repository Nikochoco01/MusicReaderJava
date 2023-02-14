import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Music> content = new ArrayList<Music>();

   public Folder(String name , String path) throws IOException{
        this.name = name;
        Path folderPath = Paths.get(path);
        try(DirectoryStream<Path> folderStream = Files.newDirectoryStream(folderPath , "*.{mp3}")){
            for(Path file : folderStream){
                content.add(new Music(file.toString()));
               // System.out.println(file);
            }
        }
   }

    @Override
    public String toString() {
        return "Folder [name=" + name + ", content=" + content + "]";
    }
}
