/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public class SingleRoom extends Room {

    private boolean hasDesk;

    //constructors
    public SingleRoom(String desc, double size, double price, int numOfBeds, boolean hasDesk) {
        super(desc, size, price, numOfBeds);
        this.hasDesk = hasDesk;
    }

    public SingleRoom() {
        this("", 0.0, 0.0, 0, false);
    }

    //methods
    @Override
    public void showAmenities() {
        System.out.println("TV");
        System.out.println("Wi-Fi");
    }

    @Override
    public String serviceType() {

        return "Laundry and Dry Cleaning";
    }

    //setters & getters
    public boolean isHasDesk() {
        return hasDesk;
    }

    public void setHasDesk(boolean hasDesk) {
        this.hasDesk = hasDesk;
    }

    @Override
    public String toString() {
        return String.format("%sHas desk? %b\n", super.toString(), isHasDesk());
    }

}
