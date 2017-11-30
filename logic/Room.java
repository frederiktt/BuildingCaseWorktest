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
public class Room
{
    private String name;
    private ArrayList<Sensor> sensorList=new ArrayList<>();
    private Sensor sensor;
    
    public void addSensor(double minValue, double maxValue, String unit, String name)
    {
        Sensor sensor = new Sensor(minValue, maxValue, unit, name);
        sensorList.add(sensor);
    }

    public void removeSensor(int index)
    {
        sensorList.remove(index);
    }

    public Room(String name)
    {
        this.name = name;
    }

    public ArrayList<Sensor> getSensorList()
    {
        return sensorList;
    }

    public String getName()
    {
        return name;
    }
}
