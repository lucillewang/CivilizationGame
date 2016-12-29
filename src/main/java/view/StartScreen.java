package view;

import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Label select;
    private Button startButton;
    private ListView<CivEnum> civilizations;
    private ImageView startImgView;
    private Image startImage;

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        super();
        select = new Label("Select a Civilization to Begin");
        select.setTextFill(Color.web("#ff0000"));
        select.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        startButton = new Button("START");
        civilizations = new ListView<CivEnum>(FXCollections.observableArrayList(
                CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY,
                CivEnum.ROMAN_EMPIRE));
        civilizations.setMaxHeight(75);
        civilizations.setMaxWidth(300);
        startImage = new Image("File:./src/main/java/view/civ_background.png");
        startImgView = new ImageView();
        startImgView.setImage(startImage);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(select, civilizations, startButton);

        getChildren().addAll(startImgView, vbox);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return startButton;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return civilizations;
    }
}