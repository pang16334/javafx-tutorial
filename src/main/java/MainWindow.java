import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/** Controls the main FXML chat window. */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;

    private Duke duke;
    private final Image userImage = new Image(getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image dukeImage = new Image(getClass().getResourceAsStream("/images/DaDuke.png"));

    /** Keeps the newest dialog visible as the history grows. */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance used to generate replies. */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    /** Appends the user's input and Duke's response to the conversation. */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage));
        userInput.clear();
    }
}
