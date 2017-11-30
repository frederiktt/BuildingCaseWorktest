package buildingWorkshop.presentation;

import buildingWorkshop.acq.ILogicFacade;
import buildingWorkshop.acq.IUserInterface;
import buildingWorkshop.logic.Building;
import buildingWorkshop.logic.Room;
import buildingWorkshop.logic.SystemWorld;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerEditRooms implements ILogicFacade, IUserInterface
{
    public ComboBox chooseSensor1;
    public Label numberOfRooms;
    public TextField roomName;
    public ListView listOfSensors;


    @FXML
    ListView<String> listOfRooms;//=new ListView<>();//;
    List<Room> rooms;
    List<String> roomNames = new ArrayList<>();
    ListProperty<String> listProperty = new SimpleListProperty<>();

    private String sensorNameString;
    private String roomNameString;
    private int buildingIndex;

    int i = 0;

    ILogicFacade logic;

    @FXML
    public void handleChooseSensor(ActionEvent event)
    {
        if (chooseSensor1.getSelectionModel().getSelectedIndex() == 0)
        {
            sensorNameString = "Temp. sensor ";
        }
        else if (chooseSensor1.getSelectionModel().getSelectedIndex() == 1)
        {
            sensorNameString = "Co2 sensor";
        }
        else
        {
            sensorNameString = "No sensor";
        }
    }

    @FXML
    public void handleAddRooms(ActionEvent event)
    {
        if (logic.getSystemWorld().getBuildingList().get(buildingIndex).getRoomList().size() == 0)
        {
            i = 0;
        }
        roomNameString = roomName.getText();
        logic.getSystemWorld().getBuildingList().get(buildingIndex).addRoom(roomNameString);
        roomNames.add(logic.getSystemWorld().getBuildingList().get(buildingIndex).getRoomList().get(i).getName());
        listProperty.set(FXCollections.observableArrayList((roomNames)));
        listOfRooms.itemsProperty().bind(listProperty);
        i++;
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddBuilding.fxml"));
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
    public void handleAddSensor(ActionEvent event)
    {
    }

    @FXML
    public void handleRemoveRoom(ActionEvent event)
    {
        if (logic.getSystemWorld().getBuildingList().get(buildingIndex).getRoomList().size() > 0)
        {
            if (!listOfRooms.getSelectionModel().isEmpty())
            {
                logic.getSystemWorld().getBuildingList().get(buildingIndex).
                        getRoomList().remove(listOfRooms.getSelectionModel().getSelectedIndex());

            }
            listOfRooms.getItems().removeAll();
            roomNames.clear();
            for (int i = 0; i < rooms.size(); i++)
            {
                roomNames.add(rooms.get(i).getName());
                this.i = i + 1;
            }

            listProperty.set(FXCollections.observableArrayList((roomNames)));
            listOfRooms.itemsProperty().bind(listProperty);
        }
    }

    @FXML
    public void handleRemoveSensor(ActionEvent event)
    {
    }

    @Override
    public SystemWorld getSystemWorld()
    {
        return null;
    }

    @Override
    public void injectLogic(ILogicFacade logicLayer)
    {
        logic = logicLayer;
        rooms = logic.getSystemWorld().getBuildingList().get(buildingIndex).getRoomList();
        i = (logic.getSystemWorld().getBuildingList().get(buildingIndex).getRoomList().size());
        for (int i = 0; i < rooms.size(); i++)
        {
            roomNames.add(rooms.get(i).getName());
        }
        listProperty.set(FXCollections.observableArrayList((roomNames)));
        listOfRooms.itemsProperty().bind(listProperty);
    }

    @Override
    public void injectBuildingIndex(int i)
    {
        this.buildingIndex = i;
    }
}
