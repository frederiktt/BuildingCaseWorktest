/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingWorkshop.logic;

import java.util.Date;

/**
 * @author Frederik
 */
public class Measurement
{
    private Date date;
    private double value;

    public Measurement(Date date, double value)
    {
        this.date = date;
        this.value = value;
    }

    public Date getDate()
    {
        return date;
    }

    public double getValue()
    {
        return value;
    }

}
