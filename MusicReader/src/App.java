public class App {
    public static void main(String[] args) throws Exception {
        // Music test = new Music("MusicReader\\src\\music\\Tiësto - 10_35 (feat. Tate McRae).mp3");
        // test.setId(1);
        // System.out.println(test.toString());

        Folder testFolder = new Folder("music", "MusicReader\\src\\music");
        System.out.println(testFolder.toString());
    }
}
