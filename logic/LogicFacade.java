package buildingWorkshop.logic;


import buildingWorkshop.acq.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Frederik
 */

public class LogicFacade implements ILogicFacade
{
    ISystemWorld systemWorld= new SystemWorld();
    List<String> buildings = new ArrayList<>();
    ListProperty<String> listProperty = new SimpleListProperty<>();

    @Override
    public ISystemWorld getSystemWorld()
    {
        return systemWorld;
    }

}
