import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LibraryApplication extends Application {

    /**
     * Launches the application.
     * @param args This program takes no argument.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

            // set title for the stage
            stage.setTitle("Music Library");

            GridPane root = new GridPane();
            root.setPadding( new Insets(10) );
            root.setHgap( 4 );
            root.setVgap( 10 );
//            root.setGridLinesVisible(true);

            VBox vbox = new VBox();

            // create a label
            Label label = new Label("Artist ");
            label.setScaleX(1.4);
            label.setScaleY(1.4);
            label.setPadding(new Insets(8));
            label.setTextFill(Color.WHITE);

            // create a text field
            TextField textfield = new TextField();
            textfield.setScaleY(1.1);

            // create a button
            Button button = new Button("Search");
            button.setStyle("-fx-font-size: 12px");

            VBox.setVgrow(root, Priority.ALWAYS );

            root.add(textfield, 2,1);
            root.add(button, 4,1);
            root.add(label,1,1);


            // create a scene
            Scene scene = new Scene(root, 500, 400);

            // create a background fill
            BackgroundFill background_fill = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background = new Background(background_fill);

            // set background
            root.setBackground(background);

            // set the scene
            stage.setScene(scene);

            stage.show();



    }
}
