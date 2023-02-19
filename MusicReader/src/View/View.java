package View;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class View{

    private Stage stage;
    private Scene scene;
    private WebView webView;

    public View(){
        stage = new Stage();
        webView = new WebView();
        BorderPane root = new BorderPane(webView);
        scene = new Scene(root , 800 , 800);
        stage.setScene(scene);
    }

    public void showView(){
        stage.show();
    }

    public void loadView(String url){
        webView.getEngine().load(url);
    }
}
