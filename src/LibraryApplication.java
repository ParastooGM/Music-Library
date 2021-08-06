import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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


        // create a text field to add an artist
        TextField textfield1 = new TextField();
        textFields.add(textfield1);

        // create a text field to add an album
        TextField textfield2 = new TextField();
        textFields.add(textfield2);

        // create a text field to add a song
        TextField textfield3 = new TextField();
        textFields.add(textfield3);

        // create a text field to search an artist
        TextField textfield4 = new TextField();
        textFields.add(textfield4);

        // create a text field to search an album
        TextField textfield5 = new TextField();
        textFields.add(textfield5);

        // create a text field to search a song
        TextField textfield6 = new TextField();
        textFields.add(textfield6);

        for (TextField tf : textFields){
            tf.setScaleY(1.1);
            tf.setBackground(background_text);
        }

        // create a button to add artist
        Button button1 = new Button("Search");
        buttons.add(button1);

        // create a button to add an album
        Button button2 = new Button("Search");
        buttons.add(button2);

        // create a button to add a song
        Button button3 = new Button("Search");
        buttons.add(button3);

        // create a button to search artist
        Button button4 = new Button("Add");
        buttons.add(button4);

        // create a button to search an album
        Button button5 = new Button("Add");
        buttons.add(button5);

        // create a button to search a song
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


        //event handling

        Library MusicLibrary = Library.Instance();

        //search an artist
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                assert textfield1.getText() != null;
                Optional<Artist> foundArtist = MusicLibrary.getArtist(textfield1.getText());

                Stage response = new Stage();
                VBox vbox = new VBox();
                vbox.setPadding( new Insets(40) );

                // set title for the stage
                response.setTitle("Music Library");

                if (foundArtist.isPresent()){
                    Image profileImg = foundArtist.get().getProfilePicture();
                    Label name = new Label(foundArtist.get().getName());

                    ListView<Album> list = new ListView<Album>();
                    ObservableList<Album> items =FXCollections.observableArrayList (foundArtist.get().getAlbumsList());
                    list.setItems(items);
                    list.setPrefWidth(100);
                    list.setPrefHeight(70);

                    HBox hbx = new HBox();
                    hbx.getChildren().add(name);
                    hbx.setAlignment(Pos.CENTER);

                    //ToDo
                    //Add profile image to the window
                    vbox.getChildren().addAll( hbx,  list );


                }else{
                    Label error = new Label("No Artists with the name '" + textfield1.getText() +"' exists in the Music Library!" );
                    HBox hbox = new HBox();
                    hbox.getChildren().add(error);
                    hbox.setAlignment(Pos.CENTER);
                    vbox.getChildren().add(hbox);
                }

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
                response.setScene(scene);

                response.show();
            }
        });

        //add an artist
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                assert textfield2.getText() != null;
                MusicLibrary.addArtist(new Artist(textfield2.getText()));
            }
        });


    }
}
