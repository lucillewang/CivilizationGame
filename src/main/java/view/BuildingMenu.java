package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {

    private Button invest;
    private Button demolish;
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        invest = new Button("Invest");
        invest.setOnMouseClicked(e -> {
                TerrainTile last = GameController.getLastClicked().getTile();
                if (GameController.getCivilization().
                        getTreasury().getCoins() >= 25) {
                    ((Settlement) last.getOccupant()).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                } else {
                    //alert
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Cannot Invest");
                    alert.setContentText("You cannot invest.");
                    alert.showAndWait();
                }
                GameScreen.getResources().update();
            });

        demolish = new Button("Demolish");
        demolish.setOnMouseClicked(e -> {
                TerrainTile last = GameController.getLastClicked().getTile();
                if (last.getOccupant().getOwner().getNumSettlements() > 1
                        && last.getOccupant() instanceof Settlement) {
                    ((Building) last.getOccupant()).demolish();
                    last.setOccupant(null);
                    GameController.getCivilization().decrementNumSettlements();
                    GameController.getLastClicked().updateTileView();
                } else {
                        //alert
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Cannot Demolish");
                    alert.setContentText("Cannot demolish settlement.");
                    alert.showAndWait();
                }
            });

        addMenuItem(invest);
        addMenuItem(demolish);
    }
}
