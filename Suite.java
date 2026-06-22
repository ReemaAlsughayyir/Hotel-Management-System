/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public class Suite extends Accommodation {

    private int numOfRooms;
    private int maxGuests;

    public Suite(String desc, double size, double price, int numOfRooms, int maxGuests) {
        super(desc, size, price);
        setNumOfRooms(numOfRooms);
        setMaxGuests(maxGuests);
    }

    public Suite() {

        this("", 0.0, 0.0, 0, 0);
    }

    //methods
    @Override
    public void showAmenities() {
        System.out.println("Swimming Pool");
        System.out.println("Restaurant Options");
    }

    @Override
    public String serviceType() {
        return "VIP Services and Butler Service";
    }

    //specific method
    public void spaServicestype() {
        System.out.println("Spa services for the suite");
        System.out.println("1. Massages");
        System.out.println("2. Hydrotherapy");
        System.out.println("3. Day Spa");
    }

    //setters & getters
    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    @Override
    public String toString() {
        return String.format("%sNum of rooms:%d\nMax guests: %d\n", super.toString(), getNumOfRooms(), getMaxGuests());
    }

}