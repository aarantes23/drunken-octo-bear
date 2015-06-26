/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */

package Beans;

/**
 *
 * @author Arthur
 */
public class Room {
    
    private int id;
    private int number;
    private String floor;
    private String type;
    private double daily_value;

    public Room() {
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDaily_value() {
        return daily_value;
    }

    public void setDaily_value(double daily_value) {
        this.daily_value = daily_value;
    }

    
}
