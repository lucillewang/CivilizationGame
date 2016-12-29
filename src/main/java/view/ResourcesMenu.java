package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ResourcesMenu {
    private Text stratLevel, resources, settlements, money, food, happiness;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        stratLevel = new Text("Strat Level: "
            + GameController.getCivilization().
            getStrategy().getStrategyLevel());
        resources = new Text("Resources: "
            + GameController.getCivilization().
            getResources());
        settlements = new Text("Settlements: "
            + GameController.getCivilization().
            getNumSettlements());
        money = new Text("Money: "
            + GameController.getCivilization().
            getTreasury().getCoins());
        happiness = new Text("Happiness: "
            + GameController.getCivilization().
            getHappiness());
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        stratLevel.setText("Strat Level: "
            + GameController.getCivilization().
            getStrategy().getStrategyLevel());
        resources.setText("Resources: "
            + GameController.getCivilization().
            getResources());
        settlements.setText("Settlements: "
            + GameController.getCivilization().
            getNumSettlements());
        money.setText("Money: "
            + GameController.getCivilization().
            getTreasury().getCoins());
        happiness.setText("Happiness: "
            + GameController.getCivilization().
            getHappiness());
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(
            stratLevel, resources, settlements, money, happiness);
        return hbox;
    }
}