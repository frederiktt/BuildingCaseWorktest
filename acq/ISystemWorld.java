package buildingWorkshop.acq;

import buildingWorkshop.logic.Building;

import java.util.ArrayList;

public interface ISystemWorld
{
    void addBuilding(String name,String address, String description);

    ArrayList<Building> getBuildingList();


}
