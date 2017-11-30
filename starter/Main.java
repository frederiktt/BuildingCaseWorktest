package buildingWorkshop.starter;

import buildingWorkshop.acq.ILogicFacade;
import buildingWorkshop.acq.IUserInterface;
import buildingWorkshop.logic.LogicFacade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../presentation/MainScene.fxml"));
        Parent root = loader.load();

        ILogicFacade logic = new LogicFacade();

        IUserInterface controller = loader.getController();
        controller.injectLogic(logic);

        stage.setTitle("Workshop");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
