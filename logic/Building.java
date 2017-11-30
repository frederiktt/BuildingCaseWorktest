/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingWorkshop.logic;

import java.util.ArrayList;

/**
 * @author Frederik
 */
public class Building //implements IBuilding
{

    ArrayList<Room> roomList;// = new ArrayList<>();
    private String name;
    String address;
    private String description;
    private Location location;

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public Location getLocation()
    {
        return location;
    }


    public Building( String name,String address, String description, Location location)
    {
        this.name = name;
        this.address = address;
        this.description=description;
        this.location = location;
        this.roomList = new ArrayList<>();
    }

    public void addRoom (String name)
    {
       Room room = new Room(name);
        roomList.add(room);
    }
    
    public void removeRoom (int index)
    {
        roomList.remove(index);
    }

    public ArrayList<Room> getRoomList()
    {
        return roomList;
    }
}
