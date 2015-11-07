import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Pane to provide a GUI for the FileSplitter class.
 *
 * @author Joey Davis
 */
public class FileSplitterPane extends GridPane {

  private FileSplitter fileSplitter = new FileSplitter();
  /**
   * JavaFX UI members
   */
  private TextField filenameField = new TextField("");
  private TextField piecesField = new TextField("");
  private Button splitBtn = new Button("Split");
  private Button chooseFileBtn = new Button("Choose File");

  /**
   * Listener for when the filenameField text has changed. Use of the listener provides a common action
   * whether the user types in a filename or selects one via the FileChooser.
   */
  final ChangeListener<String> filenameListener = new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
      fileSplitter.setSourceFile(new File(filenameField.getText()));
    }
  };

  /**
   * Event handler for when the user hits the "Choose File" (chooseFileBtn) button.
   */
  final EventHandler<ActionEvent> chooseFileHandler = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
      FileChooser fileChooser = new FileChooser();
      File file = fileChooser.showOpenDialog(null);
      if (file != null) {
        filenameField.setText(file.getAbsolutePath());
      }
    }
  };

  /**
   * Event handler for when the user hits the "Split" (via splitBtn) button.
   */
  final EventHandler<ActionEvent> splitFileHandler = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
      try {
        int pieces = Integer.parseInt(piecesField.getText());
        if (pieces < 1) throw new NumberFormatException();
        fileSplitter.setPieces(pieces);
        // signify to the user that something is happening. A large file (>1GB) takes a few seconds.
        splitBtn.setText("Processing...");
        fileSplitter.writePieces();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("File successfully split.");
        alert.show();
      } catch (NumberFormatException e) {
        // parsing piecesField failed
        new Alert(Alert.AlertType.ERROR, "Invalid number of pieces.").show();
      } catch (FileNotFoundException e) {
        // selected file does not exist
        new Alert(Alert.AlertType.ERROR, "File does not exist.").show();
      } catch (IOException e) {
        // other I/O problem; i.e. writing to the filesystem, no space, etc.
        new Alert(Alert.AlertType.ERROR, "An I/O error occurred and the file splitter could not continue.").show();
      } finally {
        splitBtn.setText("Split");
      }
    }
  };

  /**
   * Constructor
   */
  public FileSplitterPane() {
    setPadding(new Insets(5.0));
    setHgap(5.0);
    setVgap(5.0);
    initializeElements();
    registerEvents();
  }

  /**
   * initialize the FileSplitterPane child elements
   */
  public void initializeElements() {
    add(new Label("Enter a file:"), 0, 0);
    add(filenameField, 1, 0);
    add(chooseFileBtn, 2, 0);
    add(new Label("Specify the number of smaller files:"), 0, 1);
    add(piecesField, 1, 1);
    add(splitBtn, 1, 2);
  }

  /**
   * Register the events for the FileSplitterPane
   */
  public void registerEvents() {
    filenameField.textProperty().addListener(filenameListener);
    chooseFileBtn.setOnAction(chooseFileHandler);
    splitBtn.setOnAction(splitFileHandler);
  }

}
