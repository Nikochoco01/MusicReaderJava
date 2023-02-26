package Model;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Music {
    private String title;
    private String author;
    private String picture;
    private String path;
    private int id;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPicture() {
        return picture;
    }

    public String getPath() {
        return path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Music(String path){
        try {
            File mp3File = new File(path);
            AudioFile audioFile = AudioFileIO.read(mp3File);
            Tag tag = audioFile.getTag();

            String title = tag.getFirst(FieldKey.TITLE);
            String artist = tag.getFirst(FieldKey.ARTIST);
            String coverArt = tag.getFirst(FieldKey.COVER_ART);

            this.title = title.replaceAll("\"", "");
            this.author = artist.replaceAll("\"", "");
            this.picture = "file:///"+convertCoverArt(coverArt);
            this.path = "file:///"+convertPath(path);
            this.id = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertPath(String path){
        path = path.replace('\\', '/');
        return path;
    }

    private String convertCoverArt(String coverArt){
        String extension = "";
        String name = "";
        String coverArtString = !coverArt.isEmpty() ? coverArt : "noPicture";

        Pattern  patternExtension = Pattern.compile("(?<=image\\/)([^:]+)");
        Matcher matcherExtension = patternExtension.matcher(coverArtString);

        Pattern patternName = Pattern.compile("\\d+");
        Matcher matcherName = patternName.matcher(coverArtString);

        if(matcherExtension.find()){
            extension = "."+matcherExtension.group(1);
        }

        if(matcherName.find()){
            name = matcherName.group(0);
        }

        String musicPicture = name + extension;

        return musicPicture;
    }

    @Override
    public String toString() {
        return "\nMusic [title= " + title + ", author= " + author + ", picture= " + picture + ", path= " + path + ", id= " + id
                + "]";
    }
}
