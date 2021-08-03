import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class LibraryApplication extends Application {

    /**
     * Launches the application.
     * @param args This program takes no argument.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // set title for the stage
        stage.setTitle("Music Library");

        VBox vbox = new VBox();
        vbox.setPadding( new Insets(40) );

        HBox artist = new HBox();
        HBox album = new HBox();
        HBox song = new HBox();

        HBox artistLabel = new HBox();
        HBox albumLabel = new HBox();
        HBox songLabel = new HBox();

        List<Label> lables = new ArrayList<>();
        List<TextField> textFields = new ArrayList<>();
        List<Button> buttons = new ArrayList<>();

        // create a label
        Label labelArtist = new Label("Artist ");
        lables.add(labelArtist);

        // create a label
        Label labelSong = new Label("Song ");
        lables.add(labelSong);

        // create a label
        Label labelAlbum = new Label("Album ");
        lables.add(labelAlbum);

        for (Label l : lables){
            l.setScaleX(1.7);
            l.setScaleY(1.7);
            l.setPadding(new Insets(8));
            l.setTextFill(Color.web("F4EEFF"));
        }


        // create a background fill
        BackgroundFill background_fill_text = new BackgroundFill(Color.web("F4EEFF"),
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background_text = new Background(background_fill_text);


        // create a text field
        TextField textfield1 = new TextField();
        textFields.add(textfield1);

        // create a text field
        TextField textfield2 = new TextField();
        textFields.add(textfield2);

        // create a text field
        TextField textfield3 = new TextField();
        textFields.add(textfield3);

        // create a text field
        TextField textfield4 = new TextField();
        textFields.add(textfield4);

        // create a text field
        TextField textfield5 = new TextField();
        textFields.add(textfield5);

        // create a text field
        TextField textfield6 = new TextField();
        textFields.add(textfield6);

        for (TextField tf : textFields){
            tf.setScaleY(1.1);
            tf.setBackground(background_text);
        }

        // create a button
        Button button1 = new Button("Search");
        buttons.add(button1);

        // create a button
        Button button2 = new Button("Search");
        buttons.add(button2);

        // create a button
        Button button3 = new Button("Search");
        buttons.add(button3);

        // create a button
        Button button4 = new Button("Add");
        buttons.add(button4);

        // create a button
        Button button5 = new Button("Add");
        buttons.add(button5);

        // create a button
        Button button6 = new Button("Add");
        buttons.add(button6);

        for (Button b : buttons){
            b.setStyle("-fx-font-size: 12px; -fx-background-color: #A6B1E1");
        }


        artist.getChildren().addAll(textfield1 , button1 , textfield4, button4);
        album.getChildren().addAll(textfield2 , button2 , textfield5, button5);
        song.getChildren().addAll(textfield3 , button3 , textfield6, button6);

        artistLabel.getChildren().add(labelArtist);
        albumLabel.getChildren().add(labelAlbum);
        songLabel.getChildren().add(labelSong);

        album.setSpacing(10);
        album.setAlignment(Pos.CENTER);
        albumLabel.setAlignment(Pos.CENTER);
        artist.setSpacing(10);
        artist.setAlignment(Pos.CENTER);
        artistLabel.setAlignment(Pos.CENTER);
        song.setSpacing(10);
        song.setAlignment(Pos.CENTER);
        songLabel.setAlignment(Pos.CENTER);

        VBox.setMargin(artistLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setMargin(artist, new Insets(0.0d, 10.0d, 50.0d, 10.0d));
        VBox.setMargin(albumLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setMargin(album, new Insets(0.0d, 10.0d, 50.0d, 10.0d));
        VBox.setMargin(song, new Insets(0.0d, 10.0d, 50.0d, 10.0d));
        VBox.setMargin(songLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));


        vbox.getChildren().addAll(artistLabel , artist , albumLabel , album,  songLabel , song);


        // create a scene
        Scene scene = new Scene(vbox);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.web("27496D"),
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        vbox.setBackground(background);

        // set the scene
        stage.setScene(scene);

        stage.show();



    }
}
