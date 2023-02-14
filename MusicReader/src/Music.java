import java.io.File;

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

    public void setPath(String path) {
        this.path = path;
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
            
            this.title = title;
            this.author = artist;
            this.picture = coverArt;
            this.path = path;
            this.id = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\nMusic [title= " + title + ", author= " + author + ", picture= " + picture + ", path= " + path + ", id= " + id
                + "]";
    }
}
