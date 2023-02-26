package Controller;

import Model.Music;
import Model.Playlist;
import View.View;
import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;
import javafx.concurrent.Worker;

public class Controller {

    private View view;
    private WebEngine webEngine;
    private Playlist playlist;
    private JSObject jsObject;
    private Boolean initReader;
    private Boolean repeat;
    
    public Controller(View view , Playlist playlist){
        this.view = view;
        this.playlist = playlist;
        this.initReader = false;
        this.repeat = false;
        webEngine = view.getWebEngine();
    }

    private String getElement(String element){
        return "document.getElementById('" + element + "')";
    }

    public void getWindow(){
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                this.jsObject = (JSObject) view.getWebEngine().executeScript("window");
                this.jsObject.setMember("javaObj", this);
            }
        });
    }

    public void importFile(){
        System.out.println(webEngine.executeScript(getElement("music-reader") + ".value"));
    }

    public void initVolume(){
        webEngine.executeScript(getElement("music-reader") + ".volume = 0.5");
        this.initReader = true;
    }

    public void play(){
        if(initReader == false){
            initVolume();
        }
        Boolean stateAudio = (Boolean)webEngine.executeScript(getElement("music-reader") + ".paused");
        if(stateAudio){
            webEngine.executeScript(getElement("music-reader") + ".play()");
            playlist.toString();
        }
        else{
            webEngine.executeScript(getElement("music-reader") + ".pause()");
        }
    }

    public void repeat(){
        if(repeat == false){
            // webEngine.executeScript(getElement("music-reader") + ".loop = true");
            System.out.println(webEngine.executeScript(getElement("music-reader") + ".loop"));
            repeat = true;
        }
        else{
            webEngine.executeScript(getElement("music-reader") + ".loop = false");
            repeat = false;
        }
    }

    public void goNext(){
        Music music = playlist.readNext();
        System.out.println(music);
        webEngine.executeScript(getElement("music-reader") + ".src=\"\"");
        webEngine.executeScript(getElement("music-reader") + ".src=\""+music.getPath()+"\"");
        webEngine.executeScript(getElement("music-title") + ".innerText=\""+music.getTitle()+"\"");
        webEngine.executeScript(getElement("music-author") + ".innerText=\""+music.getAuthor()+"\"");
        // System.out.println(getElement("player-picture") + ".src=\""+music.getPicture()+"\"");
        // webEngine.executeScript();
        // System.out.println(getElement("player-picture") + ".src=\""+playlist.readNext().getPicture()+"\"");
        play();
    }

    public void goPrevious(){
        Music music = playlist.readPrevious();
        webEngine.executeScript(getElement("music-reader") + ".src=\"\"");
        webEngine.executeScript(getElement("music-reader") + ".src=\""+music.getPath()+"\"");
        webEngine.executeScript(getElement("music-title") + ".innerText=\""+music.getTitle()+"\"");
        webEngine.executeScript(getElement("music-author") + ".innerText=\""+music.getAuthor()+"\"");
        play();
    }

    public void changeVolume(){
        Object volumeBar = webEngine.executeScript(getElement("player-volume-range") + ".value");
        webEngine.executeScript(getElement("music-reader") + ".volume = " + volumeBar);
    }

    public void muteVolume(){
        Object volumeBar = webEngine.executeScript(getElement("music-reader") + ".volume");
        Float volumeReader = Float.parseFloat(volumeBar.toString());
        if(volumeReader > 0){
            webEngine.executeScript(getElement("player-volume-range") + ".value=" + "0");
            webEngine.executeScript(getElement("music-reader") + ".volume = 0");
        }
        else{
            webEngine.executeScript(getElement("player-volume-range") + ".value=" + "0.5");
            webEngine.executeScript(getElement("music-reader") + ".volume = 0.5");
        }
    }

    public void updateTime(){
        Object timeBar = webEngine.executeScript(getElement("player-time-range") + ".value");
        webEngine.executeScript(getElement("music-reader") + ".currentTime = " + timeBar);
    }

    public void updateDuration(){
        Object totalTime = webEngine.executeScript(getElement("music-reader") + ".duration");
        Object currentTime = webEngine.executeScript(getElement("music-reader") + ".currentTime");
        webEngine.executeScript(getElement("player-time-range") + ".max = " + totalTime);
        webEngine.executeScript(getElement("player-time-range") + ".value = " + currentTime);
        updateTimer(currentTime, totalTime);
    }

    public void updateTimer(Object currentTime , Object totalTime){

        webEngine.executeScript(getElement("player-time-progress") + ".innerHTML = ");
        webEngine.executeScript(getElement("player-time-total") + ".innerText = " + totalTime);
    }

    // private int divTime(Object time , int value){
    //     return Math.round(Float.parseFloat(time.toString()))/value;
    // }

    // private int moduloTime(Object time , int value){
    //     return Math.round(Float.parseFloat(time.toString()))%value;
    // }


}
