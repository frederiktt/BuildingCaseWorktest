package buildingWorkshop.presentation;

import buildingWorkshop.acq.IUserInterface;
import buildingWorkshop.logic.Building;
import buildingWorkshop.logic.SystemWorld;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import buildingWorkshop.acq.ILogicFacade;

/**
 * @author Frederik
 */

public class ControllerAddBuilding implements ILogicFacade,IUserInterface
{
    public TextField name;
    public TextField address;
    public TextField description;

    @FXML
    ListView <String> listOfBuildings;

    List<Building> buildings;// = new ArrayList<>();
    List<String> buildingNames = new ArrayList<>();

    ListProperty<String> listProperty= new SimpleListProperty<>();

    String nameString;
    String addressString;
    String descriptionString;

    int i=0;

    ILogicFacade logic;

    @FXML
    public void handleName(ActionEvent event)
    {
    }
    @FXML
    public void handleAddress(ActionEvent event)
    {
    }

    @FXML
    public void handleDescription(ActionEvent event)
    {
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainScene.fxml"));

        GridPane gridPane = loader.load();
        IUserInterface controller = loader.getController();
        controller.injectLogic(logic);
        Scene scene2 = new Scene(gridPane);
        //Get Stage information

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void handleAddBuilding(ActionEvent event)
    {
        if (logic.getSystemWorld().getBuildingList().size() == 0)
        {
            i=0;
        }
        nameString=name.getText();
        addressString=address.getText();
        descriptionString=description.getText();

        logic.getSystemWorld().addBuilding(nameString,addressString,descriptionString);
        buildingNames.add(logic.getSystemWorld().getBuildingList().get(i).getName());
        listProperty.set(FXCollections.observableArrayList((buildingNames)));
        listOfBuildings.itemsProperty().bind(listProperty);
        i++;
    }

    @FXML
    public void handleAddRooms(ActionEvent event) throws IOException
    {
        if(logic.getSystemWorld().getBuildingList().size() >0)
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EditRooms.fxml"));
            GridPane gridPane = loader.load();
            IUserInterface controller = loader.getController();
            controller.injectBuildingIndex(listOfBuildings.getSelectionModel().getSelectedIndex());
            controller.injectLogic(logic);


            Scene scene2 = new Scene(gridPane);
            //Get Stage information

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene2);
            window.show();

        }

    }

    @Override
    public void injectLogic(ILogicFacade logicLayer)
    {
        logic = logicLayer;

        //Used to set listView, when returning from addRoomScene
        buildings = logic.getSystemWorld().getBuildingList();
        i = (logic.getSystemWorld().getBuildingList().size());


        for (int i = 0; i <buildings.size();i++)
        {
            buildingNames.add(buildings.get(i).getName());
        }
        listProperty.set(FXCollections.observableArrayList((buildingNames)));
        listOfBuildings.itemsProperty().bind(listProperty);
    }

    @Override
    public void injectBuildingIndex(int i)
    {
    }

    @Override
    public SystemWorld getSystemWorld()
    {
        return null;
    }

    public void handleRemoveBuilding(ActionEvent event)
    {
        if (logic.getSystemWorld().getBuildingList().size() > 0)
        {
            if (!listOfBuildings.getSelectionModel().isEmpty())
            {
                logic.getSystemWorld().getBuildingList().remove(listOfBuildings.getSelectionModel().getSelectedIndex());
            }
            listOfBuildings.getItems().removeAll();
            buildingNames.clear();
            for (int i = 0; i <buildings.size();i++)
            {
                buildingNames.add(buildings.get(i).getName());
                this.i=i+1;
            }
            listProperty.set(FXCollections.observableArrayList((buildingNames)));
            listOfBuildings.itemsProperty().bind(listProperty);
        }
    }
}
