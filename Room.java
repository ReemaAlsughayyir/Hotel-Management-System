/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public abstract class Room extends Accommodation {

    private int numOfBeds;

    
    //constructors
    public Room(String desc, double size, double price, int numOfBeds) {
        super(desc, size, price);
        setNumOfBeds(numOfBeds);
    }

    public Room() {
        this("", 0.0, 0.0, 0);
    }

    //setters & getters
    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    @Override
    public String toString() {
        return String.format("%sNumber of beds: %d\n", super.toString(), numOfBeds);
    }

}