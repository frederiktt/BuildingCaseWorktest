/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingWorkshop.logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Frederik
 */
public class Sensor
{
    ArrayList<Measurement> measurementList;
    private double minValue;
    private double maxValue;
    private String unit;
    private String name;

    public Sensor(double minValue, double maxValue, String unit, String name)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.name = name;
    }
    
    public void chooseUnit()
    {

    }
    
    public void limit()
    {
        
    }
    
    public void addMessurement(Date date, double value)
    {
        Measurement measurement = new Measurement(date, value);
        measurementList.add(measurement);
    }

    public ArrayList<Measurement> getMeasurementList()
    {
        return measurementList;
    }
    
    public void removeMessurement(int index)
    {
        measurementList.remove(index);
    }
    
    
}


