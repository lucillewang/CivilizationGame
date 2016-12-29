package view;

import controller.GameController;
import model.Convertable;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {

    private Button move;
    private Button convert;

    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */

    public WorkerMenu() {
        move = new Button("Move");
        convert = new Button("Convert");

        move.setOnMouseClicked(e -> {
                GameController.moving();
            });

        convert.setOnMouseClicked(e -> {
                TerrainTile last = GameController.getLastClicked().getTile();
                if (((Convertable) last.getOccupant()).
                    canConvert(last.getType())) {
                    last.setOccupant(
                        ((Convertable) last.getOccupant()).convert());
                    GameScreen.getResources().update();
                    GameController.getLastClicked().updateTileView();
                } else {
                    //alert
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Cannot Convert Tile");
                    alert.setContentText("Tile not convertable.");
                    alert.showAndWait();
                }
                GameScreen.getResources().update();
            });

        addMenuItem(move);
        addMenuItem(convert);
    }
}
