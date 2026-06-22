/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public abstract class Accommodation {

    private static int numOfUnits;
    private int id;
    private String desc;
    private double size; //in m^2
    private double price;//per night
    private boolean available;

    //constructors
    public Accommodation(String desc, double size, double price) {
        this.id = ++numOfUnits;
        setDesc(desc);
        setSize(size);
        setPrice(price);
        setAvailable(true);

    }

    public Accommodation() {

      this("",0.0,0.0);
    }

    //methods
    public abstract void showAmenities();

    public abstract String serviceType();

    //setters & getters
    public static int getNumOfUnits() {
        return numOfUnits;
    }

    public static void setNumOfUnits(int numOfUnits) {
        Accommodation.numOfUnits = numOfUnits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Room id:%d\nDescription: %s\nSize: %s\nPrice: %.2f\nAvailable: %b\n", getId(), getDesc(), getSize(), getPrice(), isAvailable());
    }

}