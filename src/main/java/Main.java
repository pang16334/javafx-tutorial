import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/** Displays Duke's FXML-based JavaFX interface. */
public class Main extends Application {
    private final Duke duke = new Duke();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane mainLayout = loader.load();
            Scene scene = new Scene(mainLayout);
            stage.setScene(scene);
            stage.setTitle("Duke");
            stage.setMinHeight(220.0);
            stage.setMinWidth(417.0);
            loader.<MainWindow>getController().setDuke(duke);
            stage.show();
        } catch (IOException exception) {
            throw new RuntimeException("Unable to load the main window", exception);
        }
    }
}
