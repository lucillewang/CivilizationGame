package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */

    //private Button attack, move;
    private Button attack;
    private Button move;

    public MilitaryMenu() {
        attack = new Button("Attack");
        move = new Button("Move");

        attack.setOnMouseClicked(e -> {
                GameController.attacking();
                GameScreen.getResources().update();
            });

        move.setOnMouseClicked(e -> {
                GameController.moving();
            });

        addMenuItem(attack);
        addMenuItem(move);
    }
}
