package View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class View extends Application{

    public static void initView(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        WebView webView = new WebView();
        webView.getEngine().load("file:///");
  
        StackPane root = new StackPane();
        root.getChildren().add(webView);
  
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
}
