package buildingWorkshop.presentation;

import buildingWorkshop.acq.ILogicFacade;
import buildingWorkshop.acq.ISystemWorld;
import buildingWorkshop.acq.IUserInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Frederik
 */

public class ControllerShowHistory implements Initializable,ILogicFacade,IUserInterface
{
    public ComboBox chooseSensor3;
    public ComboBox chooseSensor2;
    public ComboBox chooseSensor1;
    public TextArea textArea1;


    public NumberAxis yAxis;
    public CategoryAxis xAxis;
    public LineChart lineChart;

    ILogicFacade logic;

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

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        XYChart.Series<String,Number> series = new XYChart.Series();
        series. getData().add(new XYChart.Data<String,Number>("jan",4));
        series. getData().add(new XYChart.Data<String,Number>("feb",3));
        series. getData().add(new XYChart.Data<String,Number>("mar",8));
        series. getData().add(new XYChart.Data<String,Number>("apr",11));
        series. getData().add(new XYChart.Data<String,Number>("may",14));
        series. getData().add(new XYChart.Data<String,Number>("jun",17));
        lineChart.getData().add(series);
    }

    @Override
    public ISystemWorld getSystemWorld()
    {
        return null;
    }

    @Override
    public void injectLogic(ILogicFacade logicLayer)
    {
        logic = logicLayer;
    }

    @Override
    public void injectBuildingIndex(int i)
    {

    }
}
