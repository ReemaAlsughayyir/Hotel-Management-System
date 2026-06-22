/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public class Restaurant implements Bookable {

    private String name;
    private String cuisine;
    private int capacity;
    private double rating;

    //constructors
    public Restaurant(String name, String cuisine, int capacity, double rating) {
        setName(name);
        setCuisine(cuisine);
        setCapacity(capacity);
        setRating(rating);
    }

    //methods
    @Override
    public void book() {
        System.out.println("Booking has been confirmed.");
    }

    @Override
    public double calcTotal() {

        double total = 0;
        if (rating > 3) {
            total = 300;

        } else if (rating > 4) {
            total = 400;

        } else if (rating > 5) {
            total = 500;

        } else {
            total = 200;
        }
        total = total + (total * Bookable.VAT);
        return total;
    }

    //setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Resturant name: %s\nCuisine: %s\nCapacity: %s\nRating: %s\n", getName(), getCuisine(), getCapacity(), getRating());
    }

}