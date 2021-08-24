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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

        //HashMap to store the users.
        Map<String ,User> usersDB = new HashMap<>();

        VBox vbox = new VBox();
        vbox.setPadding( new Insets(40) );

        HBox artist = new HBox();
        HBox album = new HBox();
        HBox song = new HBox();
        HBox user = new HBox();

        HBox artistLabel = new HBox();
        HBox albumLabel = new HBox();
        HBox songLabel = new HBox();
        HBox userLabel = new HBox();

        List<Label> labels = new ArrayList<>();
        List<TextField> textFields = new ArrayList<>();
        List<Button> buttons = new ArrayList<>();

        // create labels
        Label labelArtist = new Label("Artist");
        labels.add(labelArtist);

        Label labelSong = new Label("Song");
        labels.add(labelSong);

        Label labelAlbum = new Label("Album");
        labels.add(labelAlbum);

        Label labelUser = new Label("User");
        labels.add(labelUser);

        for (Label l : labels){
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


        //text field to add an artist
        TextField textfield1 = new TextField();
        textFields.add(textfield1);

        //text field to add an album
        TextField textfield2 = new TextField();
        textFields.add(textfield2);

        //text field to add a song
        TextField textfield3 = new TextField();
        textFields.add(textfield3);

        //text field to search an artist
        TextField textfield4 = new TextField();
        textFields.add(textfield4);

        //text field to search an album
        TextField textfield5 = new TextField();
        textFields.add(textfield5);

        //text field to search a song
        TextField textfield6 = new TextField();
        textFields.add(textfield6);

        //text field to create a user
        TextField textField7 = new TextField();
        textFields.add(textField7);

        //text field to access user account
        TextField textField8 = new TextField();
        textFields.add(textField8);

        for (TextField tf : textFields){
            tf.setScaleY(1.1);
            tf.setBackground(background_text);
        }

        //button to search artist
        Button button1 = new Button("Search");
        buttons.add(button1);

        //button to search an album
        Button button2 = new Button("Search");
        buttons.add(button2);

        //button to search a song
        Button button3 = new Button("Search");
        buttons.add(button3);

        //button to add artist
        Button button4 = new Button("Add");
        buttons.add(button4);

        //button to add an album
        Button button5 = new Button("Add");
        buttons.add(button5);

        //button to add a song
        Button button6 = new Button("Add");
        buttons.add(button6);

        //button to create a user
        Button button7 = new Button("Create");
        buttons.add(button7);

        //button to access a user account
        Button button8 = new Button("Access");
        buttons.add(button8);

        for (Button b : buttons){
            b.setStyle("-fx-font-size: 12px; -fx-background-color: #A6B1E1");
        }


        artist.getChildren().addAll(textfield1 , button1 , textfield4, button4);
        album.getChildren().addAll(textfield2 , button2 , textfield5, button5);
        song.getChildren().addAll(textfield3 , button3 , textfield6, button6);
        user.getChildren().addAll(textField7, button7, textField8, button8 );

        artistLabel.getChildren().add(labelArtist);
        albumLabel.getChildren().add(labelAlbum);
        songLabel.getChildren().add(labelSong);
        userLabel.getChildren().add(labelUser);

        album.setSpacing(10);
        album.setAlignment(Pos.CENTER);
        albumLabel.setAlignment(Pos.CENTER);
        artist.setSpacing(10);
        artist.setAlignment(Pos.CENTER);
        artistLabel.setAlignment(Pos.CENTER);
        song.setSpacing(10);
        song.setAlignment(Pos.CENTER);
        songLabel.setAlignment(Pos.CENTER);
        user.setSpacing(10);
        user.setAlignment(Pos.CENTER);
        userLabel.setAlignment(Pos.CENTER);

        VBox.setMargin(artistLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setMargin(artist, new Insets(0.0d, 10.0d, 50.0d, 10.0d));
        VBox.setMargin(albumLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setMargin(album, new Insets(0.0d, 10.0d, 50.0d, 10.0d));
        VBox.setMargin(song, new Insets(0.0d, 10.0d, 50.0d, 10.0d));
        VBox.setMargin(songLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setMargin(userLabel, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setMargin(user, new Insets(0.0d, 10.0d, 50.0d, 10.0d));


        vbox.getChildren().addAll(userLabel, user, artistLabel , artist , albumLabel , album,  songLabel , song);


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

                ObservableList<Album> items =FXCollections.observableArrayList (foundArtist.get().getAlbumsList());
                ListView<Album> list = new ListView<>(items);
                list.setFixedCellSize(50);
                list.setPrefHeight(180);
                list.setPrefWidth(250);
                list.setPadding(new Insets(30));

                HBox ButtonBox = new HBox();
                Button playButton = new Button("Play");
                Button pauseButton = new Button("Pause");
                Button resumeButton = new Button("Resume");
                Button restartButton = new Button("Restart");
                Button stopButton = new Button("Stop");
                Button addToPlayList = new Button("Add to Playlist");
                ButtonBox.getChildren().addAll(playButton, pauseButton, resumeButton, restartButton, stopButton, addToPlayList);

                ButtonBox.setAlignment(Pos.CENTER);
                ButtonBox.setPadding(new Insets(10));
                ButtonBox.setSpacing(10);


                playButton.setOnAction(actionEvent1 -> {
                        assert list.getSelectionModel().getSelectedItem() != null;
                    list.getSelectionModel().getSelectedItem();
                        list.getSelectionModel().getSelectedItem().play();});

                pauseButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().pause();});

                resumeButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                    list.getSelectionModel().getSelectedItem().resumeAudio();});

                restartButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                    list.getSelectionModel().getSelectedItem().restart();});

                stopButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().stop();});

                addToPlayList.setOnAction(actionEvent1 -> {
                            Stage s = new Stage();
                            VBox v = new VBox();

                            HBox userBox = new HBox();
                            Label userL = new Label("User: ");
                            userL.setTextFill(Color.web("F4EEFF"));
                            TextField userTf = new TextField();
                            userBox.getChildren().addAll(userL , userTf);
                            userBox.setSpacing(10);
                            userBox.setAlignment(Pos.CENTER_LEFT);

                            HBox PLBox = new HBox();
                            Label PLL = new Label("PlayList: ");
                            PLL.setTextFill(Color.web("F4EEFF"));
                            TextField PLTf = new TextField();
                            PLBox.getChildren().addAll(PLL , PLTf);
                            PLBox.setSpacing(10);
                            PLBox.setAlignment(Pos.CENTER_RIGHT);

                            HBox bBox = new HBox();
                            Button addButton = new Button("Add");
                            bBox.getChildren().addAll(addButton);
                            bBox.setAlignment(Pos.CENTER);

                            v.getChildren().addAll(userBox, PLBox, bBox);
                            v.setSpacing(10);
                            v.setPadding(new Insets(20));
                            VBox.setMargin(bBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                            VBox.setMargin(PLBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                            VBox.setMargin(userBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                            addButton.setOnAction(actionEvent4->{
                                assert userTf.getText() != null && PLTf.getText() != null;
                                User found = usersDB.get(userTf.getText());
                                if ( found != null){
                                    PlayList foundPL = null;
                                    for (PlayList pl : found.getPlayListsList()){
                                        if (pl.getTitle().equals(PLTf.getText())){
                                            foundPL = pl;
                                        }
                                    }
                                    if (foundPL != null){
                                        assert list.getSelectionModel().getSelectedItem() != null;
                                        foundPL.addAlbum( list.getSelectionModel().getSelectedItem());
                                        PLTf.setText("ADDED SUCCESSFULLY!");
                                    }else{
                                        PLTf.setText("PLAYLIST NOT FOUND!");
                                    }
                                }else{
                                    userTf.setText("USER NOT FOUND!");
                                }
                            });
                            // create a scene
                            Scene scene1 = new Scene(v);

                            // create a background fill
                            BackgroundFill background_fill1 = new BackgroundFill(Color.web("27496D"),
                                    CornerRadii.EMPTY, Insets.EMPTY);

                            // create Background
                            Background background1 = new Background(background_fill1);

                            // set background
                            v.setBackground(background1);

                            // set the scene
                            s.setScene(scene1);

                            s.show();

                        });



                HBox hbx = new HBox();
                name.setScaleX(2);
                name.setScaleY(2);
                hbx.getChildren().add(name);
                hbx.setAlignment(Pos.CENTER);
                hbx.setPadding(new Insets(10));

                HBox imageBox = new HBox();
                ImageView imageView = new ImageView(foundArtist.get().getProfilePicture());
                imageView.setFitHeight(150);
                imageView.setFitWidth(150);
                imageBox.getChildren().add(imageView);
                imageBox.setAlignment(Pos.CENTER);
                imageBox.setPadding(new Insets(30));
                vbox1.getChildren().addAll( hbx, imageBox ,list, ButtonBox );



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
                        textfield4.setText("Added successfully!");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());

                    }
                }

                response.close();


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


                ObservableList<Album> items =FXCollections.observableArrayList (foundAlbum.get());
                ListView<Album> list = new ListView<>(items);
                list.setFixedCellSize(40);
                list.setPrefHeight(80);
                list.setPrefWidth(100);

                HBox ButtonBox = new HBox();
                Button playButton = new Button("Play");
                Button pauseButton = new Button("Pause");
                Button resumeButton = new Button("Resume");
                Button restartButton = new Button("Restart");
                Button stopButton = new Button("Stop");
                Button addToPlayList = new Button("Add to Playlist");
                ButtonBox.getChildren().addAll(playButton, pauseButton, resumeButton, restartButton, stopButton, addToPlayList);

                ButtonBox.setAlignment(Pos.CENTER);
                ButtonBox.setPadding(new Insets(10));
                ButtonBox.setSpacing(10);


                playButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().play();});

                pauseButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().pause();});

                resumeButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().resumeAudio();});

                restartButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().restart();});

                stopButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().stop();});

                addToPlayList.setOnAction(actionEvent1 -> {
                    Stage s = new Stage();
                    VBox v = new VBox();

                    HBox userBox = new HBox();
                    Label userL = new Label("User: ");
                    userL.setTextFill(Color.web("F4EEFF"));
                    TextField userTf = new TextField();
                    userBox.getChildren().addAll(userL , userTf);
                    userBox.setSpacing(10);
                    userBox.setAlignment(Pos.CENTER_LEFT);

                    HBox PLBox = new HBox();
                    Label PLL = new Label("Playlist: ");
                    PLL.setTextFill(Color.web("F4EEFF"));
                    TextField PLTf = new TextField();
                    PLBox.getChildren().addAll(PLL , PLTf);
                    PLBox.setSpacing(10);
                    PLBox.setAlignment(Pos.CENTER_RIGHT);

                    HBox bBox = new HBox();
                    Button addButton = new Button("Add");
                    bBox.getChildren().addAll(addButton);
                    bBox.setAlignment(Pos.CENTER);

                    v.getChildren().addAll(userBox, PLBox, bBox);
                    v.setSpacing(10);
                    v.setPadding(new Insets(20));
                    VBox.setMargin(bBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                    VBox.setMargin(PLBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                    VBox.setMargin(userBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                    addButton.setOnAction(actionEvent4->{
                        assert userTf.getText() != null && PLTf.getText() != null;
                        User found = usersDB.get(userTf.getText());
                        if ( found != null){
                            PlayList foundPL = null;
                            for (PlayList pl : found.getPlayListsList()){
                                if (pl.getTitle().equals(PLTf.getText())){
                                    foundPL = pl;
                                }
                            }
                            if (foundPL != null)
                            {
                                assert list.getSelectionModel().getSelectedItem() != null;
                                foundPL.addAlbum( list.getSelectionModel().getSelectedItem());
                                PLTf.setText("ADDED SUCCESSFULLY!");
                            }else{
                                PLTf.setText("PLAYLIST NOT FOUND!");
                            }
                        }else{
                            userTf.setText("USER NOT FOUND!");
                        }
                    });
                    // create a scene
                    Scene scene1 = new Scene(v);

                    // create a background fill
                    BackgroundFill background_fill1 = new BackgroundFill(Color.web("27496D"),
                            CornerRadii.EMPTY, Insets.EMPTY);

                    // create Background
                    Background background1 = new Background(background_fill1);

                    // set background
                    v.setBackground(background1);

                    // set the scene
                    s.setScene(scene1);

                    s.show();

                });


                vbox12.getChildren().addAll(  list , ButtonBox);



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

                        if (a.isEmpty()){
                            Stage errorStage = new Stage();
                            VBox errorBox = new VBox();
                            errorBox.setPadding( new Insets(40) );

                            Label error =  new Label(albumArtist.getText() + " does not currently exist in the library. Please add the artist first.");
                            error.setTextFill(Color.web("F4EEFF"));
                            errorBox.getChildren().add(error);

                            // create a scene
                            Scene errorScene = new Scene(errorBox);

                            // create a background fill
                            BackgroundFill Error_background_fill = new BackgroundFill(Color.web("27496D"),
                                    CornerRadii.EMPTY, Insets.EMPTY);

                            // create Background
                            Background error_background = new Background(Error_background_fill);

                            // set background
                            errorBox.setBackground(error_background);

                            // set the scene
                            errorStage.setScene(errorScene);

                            // set title for the stage
                            errorStage.setTitle("Error");

                            errorStage.show();


                        }else{

                        Album newAlbum = new Album( a.get() , albumName, parseInt(albumYear.getText()), albumLang.getText(), albumStudio.getText(),albumCoverImage.get(0));
                        a.get().addAlbum(newAlbum);
                        MusicLibrary.addArtist(a.get());
                        response.close();
                        textfield5.setText("Added successfully!");
                        }

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


                ObservableList<Song> items =FXCollections.observableArrayList (foundSong.get());
                ListView<Song> list = new ListView<>(items);
                list.setFixedCellSize(40);
                list.setPrefHeight(80);
                list.setPrefWidth(100);

                HBox ButtonBox = new HBox();
                Button playButton = new Button("Play");
                Button pauseButton = new Button("Pause");
                Button resumeButton = new Button("Resume");
                Button restartButton = new Button("Restart");
                Button stopButton = new Button("Stop");
                Button addToPlayList = new Button("Add to Playlist");
                ButtonBox.getChildren().addAll(playButton, pauseButton, resumeButton, restartButton, stopButton, addToPlayList);

                ButtonBox.setAlignment(Pos.CENTER);
                ButtonBox.setPadding(new Insets(10));
                ButtonBox.setSpacing(10);


                playButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                   for (Observer o :  list.getSelectionModel().getSelectedItem().getObservers()){
                       if (o.getName().equals( "NowPlayingObserver")){
                           String msg = ((NowPlayingObserver) o).getMsg();
                           response.setTitle(msg);
                       }
                   }
                        list.getSelectionModel().getSelectedItem().play();});

                pauseButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().pause();});

                resumeButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().resumeAudio();});

                restartButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().restart();});

                stopButton.setOnAction(actionEvent1 ->
                {
                    assert list.getSelectionModel().getSelectedItem() != null;
                        list.getSelectionModel().getSelectedItem().stop();});

                addToPlayList.setOnAction(actionEvent1 -> {
                    Stage s = new Stage();
                    VBox v = new VBox();

                    HBox userBox = new HBox();
                    Label userL = new Label("User: ");
                    userL.setTextFill(Color.web("F4EEFF"));
                    TextField userTf = new TextField();
                    userBox.getChildren().addAll(userL , userTf);
                    userBox.setSpacing(10);
                    userBox.setAlignment(Pos.CENTER_LEFT);

                    HBox PLBox = new HBox();
                    Label PLL = new Label("Playlist: ");
                    PLL.setTextFill(Color.web("F4EEFF"));
                    TextField PLTf = new TextField();
                    PLBox.getChildren().addAll(PLL , PLTf);
                    PLBox.setSpacing(10);
                    PLBox.setAlignment(Pos.CENTER_RIGHT);

                    HBox bBox = new HBox();
                    Button addButton = new Button("Add");
                    bBox.getChildren().addAll(addButton);
                    bBox.setAlignment(Pos.CENTER);

                    v.getChildren().addAll(userBox, PLBox, bBox);
                    v.setSpacing(10);
                    v.setPadding(new Insets(20));
                    VBox.setMargin(bBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                    VBox.setMargin(PLBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                    VBox.setMargin(userBox, new Insets(10.0d, 10.0d, 10.0d, 10.0d));
                    addButton.setOnAction(actionEvent4->{
                        assert userTf.getText() != null && PLTf.getText() != null;
                        User found = usersDB.get(userTf.getText());
                        if ( found != null){
                            PlayList foundPL = null;
                            for (PlayList pl : found.getPlayListsList()){
                                if (pl.getTitle().equals(PLTf.getText())){
                                    foundPL = pl;
                                }
                            }
                            if (foundPL != null){
                                assert list.getSelectionModel().getSelectedItem() != null;
                                foundPL.addSong( list.getSelectionModel().getSelectedItem());
                                PLTf.setText("ADDED SUCCESSFULLY!");
                            }else{
                                PLTf.setText("PLAYLIST NOT FOUND!");
                            }
                        }else{
                            userTf.setText("USER NOT FOUND!");
                        }
                    });
                    // create a scene
                    Scene scene1 = new Scene(v);

                    // create a background fill
                    BackgroundFill background_fill1 = new BackgroundFill(Color.web("27496D"),
                            CornerRadii.EMPTY, Insets.EMPTY);

                    // create Background
                    Background background1 = new Background(background_fill1);

                    // set background
                    v.setBackground(background1);

                    // set the scene
                    s.setScene(scene1);

                    s.show();

                });


                vbox13.getChildren().addAll(  list , ButtonBox);

            }else{
                Label error = new Label("No Songs with the name '" + textfield3.getText() +"' exists in the Music Library!" );
                error.setTextFill(Color.web("F4EEFF"));
                vbox13.getChildren().add(error);
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

            HBox albm = new HBox();
            Label songAlbumLabel = new Label("Album: ");
            songAlbumLabel.setTextFill(Color.web("F4EEFF"));
            TextField songAlbum = new TextField();
            albm.getChildren().addAll(songAlbumLabel, songAlbum);
            albm.setSpacing(10);
            albm.setPadding(new Insets(30));
            albm.setAlignment(Pos.CENTER);

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

            vbox14.getChildren().addAll( path, artst, albm, year, lang, studio, length, feat, submit);

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
                        && songStudio.getText() != null && songLength.getText() != null && songPath.getText() != null
                        && songAlbum.getText() != null;

                Optional<Artist> a = MusicLibrary.getArtist(songArtist.getText());
                Optional<HashSet<Album>> albums_set = MusicLibrary.getAlbum(songAlbum.getText());

                if (a.isEmpty() || albums_set.isEmpty()){
                    Stage errorStage = new Stage();
                    VBox errorBox = new VBox();
                    errorBox.setPadding( new Insets(40) );
                    Label error;

                    if (a.isEmpty()){
                        error =  new Label(songArtist.getText() + " does not currently exist in the library. Please add the artist first.");

                    }else{
                        error =  new Label(songAlbum.getText() + " does not currently exist in the library. Please add the album first.");
                    }
                    error.setTextFill(Color.web("F4EEFF"));
                    errorBox.getChildren().add(error);

                    // create a scene
                    Scene errorScene = new Scene(errorBox);

                    // create a background fill
                    BackgroundFill Error_background_fill = new BackgroundFill(Color.web("27496D"),
                            CornerRadii.EMPTY, Insets.EMPTY);

                    // create Background
                    Background error_background = new Background(Error_background_fill);

                    // set background
                    errorBox.setBackground(error_background);

                    // set the scene
                    errorStage.setScene(errorScene);

                    // set title for the stage
                    errorStage.setTitle("Error");

                    errorStage.show();


                }else{

                    Album songsAlbum = null;

                    for (Album al : albums_set.get()){
                        if (al.getArtist().getName().equals(a.get().getName())){
                            songsAlbum = al;
                            break;
                        }
                    }

                    if (songsAlbum == null){
                        throw new IllegalArgumentException("No album with the artist as :" + a.get().getName()+ " was found in the music library!");
                    }

                    Song newSong = new Song( new File(songPath.getText()), a.get() , songsAlbum ,songName, parseInt(songYear.getText()), songLang.getText(), songStudio.getText(), parseLong(songLength.getText()));
                    songsAlbum.addSong(newSong);
                    a.get().addSong(newSong);

                    if (!songCollabs.getText().isEmpty()) {
                        String[] collabsList = songCollabs.getText().split(",", -1);
                        for (String s : collabsList){
                            newSong.addCollab(new Artist(s));
                        }
                    }
                    MusicLibrary.addArtist(a.get());
                    response.close();
                    textfield6.setText("Added successfully!");

                }


            });
        });

        //create a user
        button7.setOnAction(actionEvent -> {
            assert textField7.getText() != null;

            if (usersDB.get(textField7.getText()) != null){
                textField7.setText("DUPLICATE USER! try again.");
            }else{
                User newUser = new User(textField7.getText());
                usersDB.put(textField7.getText(), newUser);
                textField7.setText("Created Successfully!");
            }

        });



        //access a user account
        button8.setOnAction(actionEvent -> {
            assert textField8.getText() != null;
            User foundUser = usersDB.get(textField8.getText());

            if (foundUser == null){
                textField8.setText("USER NOT FOUND!");
            }else{
               Stage userStage = new Stage();
               userStage.setTitle(foundUser.getName());
               VBox user_vbox = new VBox();

               HBox PlayListBox = new HBox();
               Button newPlayListButton = new Button("Create new PlayList");
               Button getAllPlaylistsButton = new Button("Get All PlayLists");
               PlayListBox.getChildren().addAll(newPlayListButton , getAllPlaylistsButton);
               PlayListBox.setAlignment(Pos.CENTER);
               PlayListBox.setSpacing(20);

               user_vbox.getChildren().add(PlayListBox);
               VBox.setMargin(PlayListBox, new Insets(40.0d, 10.0d, 10.0d, 10.0d));
               user_vbox.setPrefHeight(100);
               user_vbox.setPrefWidth(300);

               newPlayListButton.setOnAction(actionEvent1 -> {
                    Stage newPLayList = new Stage();
                    VBox vb = new VBox();
                    newPLayList.setTitle("New PlayList");
                    TextField tf = new TextField();
                    Label l = new Label("Name: ");
                    l.setTextFill(Color.web("F4EEFF"));
                    Button btn = new Button("Create");
                    HBox hb = new HBox();
                    hb.getChildren().addAll(l , tf, btn);
                    hb.setAlignment(Pos.CENTER);
                    hb.setSpacing(10);

                    vb.getChildren().add(hb);
                    VBox.setMargin(hb, new Insets(20.0d, 10.0d, 20.0d, 10.0d));
                    vb.setPrefHeight(100);
                    vb.setPrefWidth(300);

                    btn.setOnAction(actionEvent2 -> {
                        assert tf.getText() != null;
                        try{
                            foundUser.createAndAddPlayList(tf.getText());
                            tf.setText("Created Successfully!");
                        }catch (IllegalArgumentException e){
                            tf.setText("DUPLICATE PLAYLIST! try again.");
                        }
                    });
                   // create a scene
                   Scene scene14 = new Scene(vb);

                   // create a background fill
                   BackgroundFill background_fill14 = new BackgroundFill(Color.web("27496D"),
                           CornerRadii.EMPTY, Insets.EMPTY);

                   // create Background
                   Background background14 = new Background(background_fill14);

                   // set background
                   vb.setBackground(background14);

                   // set the scene
                   newPLayList.setScene(scene14);

                   newPLayList.show();

               });

               getAllPlaylistsButton.setOnAction(actionEvent1 -> {

                   List<PlayList> lists = new ArrayList<>();
                   lists.add(foundUser.getFavorites());
                   lists.addAll( foundUser.getPlayListsList());

                   Stage response = new Stage();
                   VBox vbox13 = new VBox();
                   vbox13.setPadding( new Insets(40) );

                   // set title for the stage
                   response.setTitle("PlayLists");

                   ObservableList<PlayList> items =FXCollections.observableArrayList (lists);
                   ListView<PlayList> list = new ListView<>(items);
                   list.setFixedCellSize(40);
                   list.setPrefHeight(80);
                   list.setPrefWidth(100);

                   HBox ButtonBox = new HBox();
                   Button playButton = new Button("Play");
                   Button pauseButton = new Button("Pause");
                   Button resumeButton = new Button("Resume");
                   Button restartButton = new Button("Restart");
                   Button stopButton = new Button("Stop");
                   Button getInfoButton = new Button("Get Info");
                   ButtonBox.getChildren().addAll(playButton, pauseButton, resumeButton, restartButton, stopButton, getInfoButton);

                   ButtonBox.setAlignment(Pos.CENTER);
                   ButtonBox.setPadding(new Insets(10));
                   ButtonBox.setSpacing(10);


                   playButton.setOnAction(actionEvent3 ->
                   {
                       assert list.getSelectionModel().getSelectedItem() != null;
                       list.getSelectionModel().getSelectedItem().play();});

                   pauseButton.setOnAction(actionEvent3 ->
                   {
                       assert list.getSelectionModel().getSelectedItem() != null;
                           list.getSelectionModel().getSelectedItem().pause();});

                   resumeButton.setOnAction(actionEvent3 ->
                   {
                       assert list.getSelectionModel().getSelectedItem() != null;
                           list.getSelectionModel().getSelectedItem().resumeAudio();});

                   restartButton.setOnAction(actionEvent3 ->
                   {
                       assert list.getSelectionModel().getSelectedItem() != null;
                       list.getSelectionModel().getSelectedItem().restart();});

                   stopButton.setOnAction(actionEvent3 ->
                   {
                       assert list.getSelectionModel().getSelectedItem() != null;
                           list.getSelectionModel().getSelectedItem().stop();});

                   getInfoButton.setOnAction(actionEvent3 ->{
                       Stage infoStage = new Stage();
                       infoStage.setTitle(list.getSelectionModel().getSelectedItem().getTitle());
                        VBox vb = new VBox();
                       TableView table = new TableView();

                       final Label label = new Label("PlayList Information");
                       label.setFont(new Font("Arial", 20));
                       label.setTextFill(Color.web("F4EEFF"));

                       TableColumn firstCol = new TableColumn(" Total Artists ");
                       TableColumn lastCol = new TableColumn(" Total length ");


                       TotalArtistsVisitor artistsVisitor = new TotalArtistsVisitor();
                       TotalLengthVisitor lengthVisitor = new TotalLengthVisitor();
                       assert list.getSelectionModel().getSelectedItem() != null;
                       list.getSelectionModel().getSelectedItem().acceptVisitor(artistsVisitor);
                       list.getSelectionModel().getSelectedItem().acceptVisitor(lengthVisitor);



                       final ObservableList<DataOBJ> data = FXCollections.observableArrayList(new DataOBJ(String.valueOf(lengthVisitor.getTotalLength()), artistsVisitor.getTotalArtists().toString()));
                       lastCol.setCellValueFactory(
                               new PropertyValueFactory<DataOBJ,String>("length")
                       );
                       firstCol.setCellValueFactory(
                               new PropertyValueFactory<DataOBJ,String>("artists")
                       );

                       table.setItems(data);
                       table.getColumns().addAll(firstCol, lastCol);
                       table.setFixedCellSize(60);

                       vb.getChildren().addAll(label, table);
                       vb.setSpacing(5);
                       vb.setPadding(new Insets(10, 0, 0, 10));

                       // create a scene
                       Scene scene13 = new Scene(vb);

                       // create a background fill
                       BackgroundFill background_fill13 = new BackgroundFill(Color.web("27496D"),
                               CornerRadii.EMPTY, Insets.EMPTY);

                       // create Background
                       Background background13 = new Background(background_fill13);

                       // set background
                       vb.setBackground(background13);

                       // set the scene
                       infoStage.setScene(scene13);

                       infoStage.show();
                   });


                   vbox13.getChildren().addAll(  list , ButtonBox);


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

                // create a scene
                Scene User_scene = new Scene(user_vbox);

                // create a background fill
                BackgroundFill background_fill14 = new BackgroundFill(Color.web("27496D"),
                        CornerRadii.EMPTY, Insets.EMPTY);

                // create Background
                Background background14 = new Background(background_fill14);

                // set background
                user_vbox.setBackground(background14);

                // set the scene
                userStage.setScene(User_scene);

                userStage.show();
            }
        });

    }
}
