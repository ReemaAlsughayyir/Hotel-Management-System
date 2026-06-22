/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public class DoubleRoom extends Room {

    private String bedType; //(e.g., "Two Single Beds", "One King Size Bed").

    //constructors
    public DoubleRoom(String desc, double size, double price, int numOfBeds, String bedType) {
        super(desc, size, price, numOfBeds);
        setBedType(bedType);
    }

    public DoubleRoom() {
        this("", 0.0, 0.0, 0, "");
    }

    //methods
    @Override
    public void showAmenities() {
        System.out.println("Special Requests");
        System.out.println("Wake-up Calls");
    }

    @Override
    public String serviceType() {
        return "Personalized Services";
    }

    //setters & getters
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public String toString() {
        return String.format("%sBed type: %s\n", super.toString(), getBedType());
    }

}