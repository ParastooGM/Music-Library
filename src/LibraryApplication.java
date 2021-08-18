import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


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
        button1.setOnAction(actionEvent -> {
            assert textfield1.getText() != null;
            Optional<Artist> foundArtist = MusicLibrary.getArtist(textfield1.getText());

            Stage response = new Stage();
            VBox vbox1 = new VBox();
            vbox1.setPadding( new Insets(40) );

            // set title for the stage
            response.setTitle("Music Library");

            if (foundArtist.isPresent()){
                Label name = new Label(foundArtist.get().getName());
                name.setTextFill(Color.web("F4EEFF"));

                ListView<Album> list = new ListView<>();
                ObservableList<Album> items =FXCollections.observableArrayList (foundArtist.get().getAlbumsList());
                list.setItems(items);
                list.setPrefWidth(100);
                list.setPrefHeight(70);
                list.setPadding(new Insets(30));

                HBox hbx = new HBox();
                hbx.getChildren().add(name);
                hbx.setAlignment(Pos.CENTER);
                hbx.setPadding(new Insets(30));

                HBox imageBox = new HBox();
                ImageView imageView = new ImageView(foundArtist.get().getProfilePicture());
                imageView.setFitHeight(150);
                imageView.setFitWidth(150);
                imageBox.getChildren().add(imageView);
                imageBox.setAlignment(Pos.CENTER);
                imageBox.setPadding(new Insets(30));
                vbox1.getChildren().addAll( hbx, imageBox ,list );



            }else{
                Label error = new Label("No Artists with the name '" + textfield1.getText() +"' exists in the Music Library!" );
                error.setTextFill(Color.web("F4EEFF"));
                HBox hbox = new HBox();
                hbox.getChildren().add(error);
                hbox.setAlignment(Pos.CENTER);
                vbox1.getChildren().add(hbox);
            }

            // create a scene
            Scene scene1 = new Scene(vbox1);

            // create a background fill
            BackgroundFill background_fill1 = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background1 = new Background(background_fill1);

            // set background
            vbox1.setBackground(background1);

            // set the scene
            response.setScene(scene1);

            response.show();
        });

        //add an artist
        button4.setOnAction(actionEvent -> {
            assert textfield4.getText() != null;

            Stage response = new Stage();
            VBox vbox14 = new VBox();
            vbox14.setPadding(new Insets(40));

            // set title for the stage
            response.setTitle("Add Artist");
            HBox imageCover = new HBox();
            Label ProfileImageLabel = new Label("Profile Image: ");
            ProfileImageLabel.setTextFill(Color.web("F4EEFF"));
            Button imageButton = new Button("Choose Image");
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            imageCover.getChildren().addAll(ProfileImageLabel, imageButton);
            imageCover.setSpacing(10);
            imageCover.setAlignment(Pos.CENTER);

            Artist newArtist = new Artist(textfield4.getText());
            MusicLibrary.addArtist(newArtist);
            vbox14.getChildren().addAll(imageCover);

            // create a scene
            Scene scene14 = new Scene(vbox14);

            // create a background fill
            BackgroundFill background_fill14 = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background14 = new Background(background_fill14);

            // set background
            vbox14.setBackground(background14);

            // set the scene
            response.setScene(scene14);

            response.show();

            imageButton.setOnAction(actionEvent1 -> {
                Stage imageFiles = new Stage();
                imageFiles.setTitle("View Images");

                File file = fileChooser.showOpenDialog(imageFiles);
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );

                if (file != null) {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                        newArtist.changeProfilePicture(image);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                    });
                });

        //search an album
        button2.setOnAction(actionEvent -> {

            assert textfield2.getText() != null;
            Optional<HashSet<Album>> foundAlbum = MusicLibrary.getAlbum(textfield2.getText());

            Stage response = new Stage();
            VBox vbox12 = new VBox();
            vbox12.setPadding( new Insets(40) );

            // set title for the stage
            response.setTitle("Music Library");

            if (foundAlbum.isPresent()){

                ListView<Album> list = new ListView<>();
                ObservableList<Album> items =FXCollections.observableArrayList (foundAlbum.get());
                list.setItems(items);
                list.setPrefWidth(100);
                list.setPrefHeight(70);

                vbox12.getChildren().addAll(  list );


            }else{
                Label error = new Label("No Albums with the name '" + textfield2.getText() +"' exists in the Music Library!" );
                error.setTextFill(Color.web("F4EEFF"));
                HBox hbox = new HBox();
                hbox.getChildren().add(error);
                hbox.setAlignment(Pos.CENTER);
                vbox12.getChildren().add(hbox);
            }

            // create a scene
            Scene scene12 = new Scene(vbox12);

            // create a background fill
            BackgroundFill background_fill12 = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background12 = new Background(background_fill12);

            // set background
            vbox12.setBackground(background12);

            // set the scene
            response.setScene(scene12);

            response.show();

        });

        //add an album
        button5.setOnAction(actionEvent -> {
            assert textfield5.getText() != null;
            String albumName = textfield5.getText();

            Stage response = new Stage();
            VBox vbox14 = new VBox();
            vbox14.setPadding( new Insets(40) );

            // set title for the stage
            response.setTitle(albumName);

            HBox artst = new HBox();
            Label albumArtistLabel = new Label("Artist: ");
            albumArtistLabel.setTextFill(Color.web("F4EEFF"));
            TextField albumArtist = new TextField();
            artst.getChildren().addAll(albumArtistLabel, albumArtist);
            artst.setSpacing(10);
            artst.setPadding(new Insets(30));
             artst.setAlignment(Pos.CENTER);

            HBox year = new HBox();
            Label albumYearLabel = new Label("Year: ");
            albumYearLabel.setTextFill(Color.web("F4EEFF"));
            TextField albumYear = new TextField();
            year.getChildren().addAll(albumYearLabel, albumYear);
            year.setSpacing(10);
            year.setPadding(new Insets(30));
            year.setAlignment(Pos.CENTER);

            HBox lang = new HBox();
            Label albumLangLabel = new Label("Language: ");
            albumLangLabel.setTextFill(Color.web("F4EEFF"));
            TextField albumLang = new TextField();
            lang.getChildren().addAll(albumLangLabel, albumLang);
            lang.setSpacing(10);
            lang.setPadding(new Insets(30));
            lang.setAlignment(Pos.CENTER);

            HBox studio = new HBox();
            Label albumStudioLabel = new Label("Studio: ");
            albumStudioLabel.setTextFill(Color.web("F4EEFF"));
            TextField albumStudio = new TextField();
            studio.getChildren().addAll(albumStudioLabel, albumStudio);
            studio.setSpacing(10);
            studio.setPadding(new Insets(30));
            studio.setAlignment(Pos.CENTER);

            HBox imageCover = new HBox();
            Label albumCoverLabel = new Label("Cover Image: ");
            albumCoverLabel.setTextFill(Color.web("F4EEFF"));
            Button imageButton = new Button("Choose Image");
            FileChooser fileChooser = new FileChooser();
            List<Image> albumCoverImage = new ArrayList<>();
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(
                    new File(System.getProperty("user.home"))
                    );
            imageCover.getChildren().addAll(albumCoverLabel, imageButton);
            imageCover.setSpacing(10);
            imageCover.setPadding(new Insets(30));
            imageCover.setAlignment(Pos.CENTER);

            HBox submit = new HBox();
            Button submitButton = new Button("Add");
            submit.getChildren().add(submitButton);
            submit.setSpacing(10);
            submit.setPadding(new Insets(30));
            submit.setAlignment(Pos.CENTER);

            vbox14.getChildren().addAll(artst, year, lang, studio, imageCover, submit);

            // create a scene
            Scene scene14 = new Scene(vbox14);

            // create a background fill
            BackgroundFill background_fill14 = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background14 = new Background(background_fill14);

            // set background
            vbox14.setBackground(background14);

            // set the scene
            response.setScene(scene14);

            response.show();

            imageButton.setOnAction(actionEvent1 -> {
                Stage imageFiles = new Stage();
                imageFiles.setTitle("View Images");

                File file = fileChooser.showOpenDialog(imageFiles);
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );

                if (file != null) {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                        albumCoverImage.add(image);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
            }

            });

            submitButton.setOnAction(actionEvent1 -> {
                assert albumArtist.getText() != null && albumLang.getText() != null && albumYear.getText() != null
                                && albumStudio.getText() != null;

                Optional<Artist> a = MusicLibrary.getArtist(albumArtist.getText());
                        Artist newArtist;
                        if (a.isEmpty()){
                            newArtist = new Artist (albumArtist.getText());
                            MusicLibrary.addArtist(newArtist);
                        }else{
                            newArtist = a.get();
                        }
                        Album newAlbum = new Album(newArtist , albumName, parseInt(albumYear.getText()), albumLang.getText(), albumStudio.getText(),albumCoverImage.get(0));
                        newArtist.addAlbum(newAlbum);

                    });
        }
        );


        //search a song
        button3.setOnAction(actionEvent -> {
            assert textfield3.getText() != null;
            Optional<HashSet<Song>> foundSong = MusicLibrary.getSong(textfield3.getText());

            Stage response = new Stage();
            VBox vbox13 = new VBox();
            vbox13.setPadding( new Insets(40) );

            // set title for the stage
            response.setTitle("Music Library");

            if (foundSong.isPresent()){

                ListView<Song> list = new ListView<>();
                ObservableList<Song> items =FXCollections.observableArrayList (foundSong.get());
                list.setItems(items);
                list.setPrefWidth(100);
                list.setPrefHeight(70);

                vbox13.getChildren().addAll(  list );


            }else{
                Label error = new Label("No Albums with the name '" + textfield3.getText() +"' exists in the Music Library!" );
                error.setTextFill(Color.web("F4EEFF"));
                HBox hbox = new HBox();
                hbox.getChildren().add(error);
                hbox.setAlignment(Pos.CENTER);
                vbox13.getChildren().add(hbox);
            }

            // create a scene
            Scene scene13 = new Scene(vbox13);

            // create a background fill
            BackgroundFill background_fill13 = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background13 = new Background(background_fill13);

            // set background
            vbox13.setBackground(background13);

            // set the scene
            response.setScene(scene13);

            response.show();
        });

        //add a song
        button6.setOnAction(actionEvent -> {
            assert textfield6.getText() != null;
            String songName = textfield6.getText();

            Stage response = new Stage();
            VBox vbox14 = new VBox();
            vbox14.setPadding( new Insets(40) );

            // set title for the stage
            response.setTitle(songName);

            HBox path = new HBox();
            Label songPathLabel = new Label("Path: ");
            songPathLabel.setTextFill(Color.web("F4EEFF"));
            TextField songPath = new TextField();
            path.getChildren().addAll(songPathLabel, songPath);
            path.setSpacing(10);
            path.setPadding(new Insets(30));
            path.setAlignment(Pos.CENTER);

            HBox artst = new HBox();
            Label songArtistLabel = new Label("Artist: ");
            songArtistLabel.setTextFill(Color.web("F4EEFF"));
            TextField songArtist = new TextField();
            artst.getChildren().addAll(songArtistLabel, songArtist);
            artst.setSpacing(10);
            artst.setPadding(new Insets(30));
            artst.setAlignment(Pos.CENTER);

            HBox year = new HBox();
            Label songYearLabel = new Label("Year: ");
            songYearLabel.setTextFill(Color.web("F4EEFF"));
            TextField songYear = new TextField();
            year.getChildren().addAll(songYearLabel, songYear);
            year.setSpacing(10);
            year.setPadding(new Insets(30));
            year.setAlignment(Pos.CENTER);

            HBox lang = new HBox();
            Label songLangLabel = new Label("Language: ");
            songLangLabel.setTextFill(Color.web("F4EEFF"));
            TextField songLang = new TextField();
            lang.getChildren().addAll(songLangLabel, songLang);
            lang.setSpacing(10);
            lang.setPadding(new Insets(30));
            lang.setAlignment(Pos.CENTER);

            HBox studio = new HBox();
            Label songStudioLabel = new Label("Studio: ");
            songStudioLabel.setTextFill(Color.web("F4EEFF"));
            TextField songStudio = new TextField();
            studio.getChildren().addAll(songStudioLabel, songStudio);
            studio.setSpacing(10);
            studio.setPadding(new Insets(30));
            studio.setAlignment(Pos.CENTER);

            HBox length = new HBox();
            Label songLengthLabel = new Label("Length: ");
            songLengthLabel.setTextFill(Color.web("F4EEFF"));
            TextField songLength = new TextField();
            length.getChildren().addAll(songLengthLabel, songLength);
            length.setSpacing(10);
            length.setPadding(new Insets(30));
            length.setAlignment(Pos.CENTER);

            HBox feat = new HBox();
            Label songCollabsLabel = new Label("Feat: ");
            songCollabsLabel.setTextFill(Color.web("F4EEFF"));
            TextField songCollabs = new TextField();
            songCollabs.setText("enter comma separated artists.");
            feat.getChildren().addAll(songCollabsLabel, songCollabs);
            feat.setSpacing(10);
            feat.setPadding(new Insets(30));
            feat.setAlignment(Pos.CENTER);

            HBox submit = new HBox();
            Button submitButton = new Button("Add");
            submit.getChildren().add(submitButton);
            submit.setSpacing(10);
            submit.setPadding(new Insets(30));
            submit.setAlignment(Pos.CENTER);

            vbox14.getChildren().addAll( path, artst, year, lang, studio, length, feat, submit);

            // create a scene
            Scene scene14 = new Scene(vbox14);

            // create a background fill
            BackgroundFill background_fill14 = new BackgroundFill(Color.web("27496D"),
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background14 = new Background(background_fill14);

            // set background
            vbox14.setBackground(background14);

            // set the scene
            response.setScene(scene14);

            response.show();

            submitButton.setOnAction(actionEvent1 -> {
                assert songArtist.getText() != null && songLang.getText() != null && songYear.getText() != null
                        && songStudio.getText() != null && songLength.getText() != null && songPath.getText() != null;
                Optional<Artist> a = MusicLibrary.getArtist(songArtist.getText());
                Artist newArtist;
                if (a.isEmpty()){
                    newArtist = new Artist (songArtist.getText());
                    MusicLibrary.addArtist(newArtist);
                }else{
                    newArtist = a.get();
                }
                Song newSong = new Song( new File(songPath.getText()), newArtist , songName, parseInt(songYear.getText()), songLang.getText(), songStudio.getText(), parseLong(songLength.getText()));
                newArtist.addSong(newSong);

                if (!songCollabs.getText().isEmpty()) {
                    String[] collabsList = songCollabs.getText().split(",", -1);
                    for (String s : collabsList){
                        newSong.addCollab(new Artist(s));
                    }
                }

            });
        });

    }
}
