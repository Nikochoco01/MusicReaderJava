package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class View{

    private WebView webView;
    private WebEngine webEngine;
    private BorderPane root;

    public BorderPane getRoot() {
        return root;
    }

    public WebEngine getWebEngine() {
        return webEngine;
    }

    public View(String url){
        webView = new WebView();
        webEngine =  webView.getEngine();
        webEngine.load(url);
        root = new BorderPane(webView);
    }

    public void displayPlaylist(){

    }
}
