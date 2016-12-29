package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Civilization;
import view.GridFX;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Optional<String> answer;
    private CivEnum chosenCivEnum;
    private GameScreen gameScreen;
    private StartScreen startScreen;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to Civilization");

        startScreen = new StartScreen();

        startScreen.getStartButton().setOnMouseClicked(e -> {
                if (!(startScreen.getCivList().getSelectionModel().isEmpty())) {
                    TextInputDialog nameSettlement = new TextInputDialog();
                    chosenCivEnum =
                        startScreen.getCivList().
                            getSelectionModel().getSelectedItem();
                    nameSettlement.setTitle("A New Settlement");
                    nameSettlement.setHeaderText(
                        "You have built a Settlement!");
                    nameSettlement.setContentText(
                        "Enter the name of your first town:");
                    answer = nameSettlement.showAndWait();
                    answer.ifPresent(
                        input -> primaryStage.setScene(startGame()));
                }
            });

        primaryStage.setScene(new Scene(startScreen));
        primaryStage.show();

        //getting the result

        //TODO connect answer to the first settlement name
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        //getting civilization
        Civilization chosenCiv = null;
        if (chosenCivEnum == CivEnum.ANCIENT_EGYPT) {
            chosenCiv = new Egypt();
        } else if (chosenCivEnum == CivEnum.QIN_DYNASTY) {
            chosenCiv = new QinDynasty();
        } else if (chosenCivEnum == CivEnum.ROMAN_EMPIRE) {
            chosenCiv = new RomanEmpire();
        }
        //Setting civilization
        GameController.setCivilization(chosenCiv);
        GridFX.getMap().putSettlement(answer.get(), chosenCiv, 0, 9);
        Bandit bandit = new Bandit();
        GridFX.getMap().putSettlement("Bandit Settlement", bandit, 9, 0);
        //Create gameScreen
        gameScreen = new GameScreen();
        return new Scene(gameScreen);
    }




}
