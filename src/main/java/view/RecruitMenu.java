package view;

import controller.GameController;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */

    private ListView<String> workerList;
    private Button select;
    private String selected;

    public RecruitMenu() {
        workerList = new ListView<String>(FXCollections.observableArrayList(
                "Melee Unit", "Range Unit", "Hybrid Unit", "Siege Unit",
                "Settlers", "Farmers", "Coal Miners",
                "Anglers", "Master Builder"));

        select = new Button("Select");

        select.setOnMouseClicked(e -> {
                selected = workerList.getSelectionModel().getSelectedItem();
                boolean notAffordable = false;

                if (!(workerList.getSelectionModel().isEmpty())) {
                    if (selected.equals("Melee Unit")) {
                        Unit unit = GameController.
                            getCivilization().getMeleeUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Range Unit")) {
                        Unit unit = GameController.
                            getCivilization().getRangedUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Hybrid Unit")) {
                        Unit unit = GameController.
                            getCivilization().getHybridUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Siege Unit")) {
                        Unit unit = GameController.
                            getCivilization().getSiegeUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Settlers")) {
                        TextInputDialog nameSettlement = new TextInputDialog();
                        nameSettlement.setTitle("A New Settlement");
                        nameSettlement.setHeaderText(
                            "You have built a Settlement!");
                        nameSettlement.setContentText(
                            "Enter the name of your first town:");
                        Optional<String> answer = nameSettlement.showAndWait();
                        Unit unit = GameController.
                            getCivilization().getSettlerUnit(answer.get());
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Farmers")) {
                        Unit unit = GameController.
                            getCivilization().getFarmerUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Coal Miners")) {
                        Unit unit = GameController.
                            getCivilization().getCoalMinerUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Anglers")) {
                        Unit unit = GameController.
                            getCivilization().getAnglerUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }

                    } else if (selected.equals("Master Builder")) {
                        Unit unit = GameController.
                            getCivilization().getMasterBuilderUnit();
                        if (unit.isAffordable()) {
                            GameController.getLastClicked().getTile().
                                setOccupant(unit);
                            unit.applyInitialCosts();
                        } else {
                            notAffordable = true;
                        }
                    }
                    GameController.getLastClicked().updateTileView();
                } else {
                    //alert box
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Select a unit to recruit");
                    alert.setContentText("You cannot recruit unit/worker.");
                    alert.showAndWait();
                }

                if (notAffordable) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Unit/Worker is not affordable.");
                    alert.setContentText("You cannot recruit unit/worker.");
                    alert.showAndWait();
                }
            });


        addMenuItem(workerList);
        addMenuItem(select);
    }


}
