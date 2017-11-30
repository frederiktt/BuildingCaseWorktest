/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingWorkshop.logic;

import buildingWorkshop.acq.ISystemWorld;

import java.util.ArrayList;

/**
 * @author Frederik
 */
public class SystemWorld implements ISystemWorld
{
    private Location location;
    private ArrayList<Building> buildingList;

    public SystemWorld()
    {
        this.buildingList = new ArrayList<>();
    }

    public void removeBuilding(int index)
    {
        buildingList.remove(index);
    }

    @Override
    public void addBuilding(String name,String address, String description)
{
    Building building = new Building(name,address,description, location);
    buildingList.add(building);
}

    public ArrayList<Building> getBuildingList()
    {
        return buildingList;
    }

}
