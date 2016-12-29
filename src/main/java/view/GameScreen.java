package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static ResourcesMenu resourcesMenu;
    private static AbstractMenu menu;
    private static VBox vbox;

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {

        //center
        setCenter(GridFX.getInstance());

        //left
        menu = new AbstractMenu();
        vbox = new VBox();
        vbox.getChildren().add(menu.getRootNode());
        setLeft(vbox);
        //top
        resourcesMenu = new ResourcesMenu();
        setTop(resourcesMenu.getRootNode());
        update();


    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        resourcesMenu.update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourcesMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        switch (state) {
        case NEUTRAL:
            menu = new StatusMenu();
            break;
        case MILITARY:
            menu = new MilitaryMenu();
            break;
        case WORKER:
            menu = new WorkerMenu();
            break;
        case BUILDING:
            menu = new BuildingMenu();
            break;
        case RECRUITING:
            menu = new RecruitMenu();
            break;
        default:
            menu = new AbstractMenu();
            break;
        }
        vbox.getChildren().setAll(menu.getRootNode());
    }
}

