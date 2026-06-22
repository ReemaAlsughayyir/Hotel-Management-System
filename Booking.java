/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public class Booking implements Bookable {

    private final int BOOKING_ID; //booking id
    private Guest guest; //main guest 
    private Accommodation accommodation[];
    private String status;
    private static int numOfBookings;

    //constructors
    public Booking(Guest guest, Accommodation[] accommodation) {
        this.BOOKING_ID = (int) (Math.random() * ((1000 - 1) + 1)) + 1;
        setGuest(guest);
        setAccommodation(accommodation);
        setStatus("New");
        numOfBookings++;
    }

    public Booking() {
        this(null, null);
    }

    //methods
    private final int generateId() {
        int min = 1;
        int max = 1000;
        int id = (int) (Math.random() * ((max - min) + 1)) + min;
        return id;
    }

    @Override
    public final void book() {
        setStatus("Confirmed");
        System.out.println("Booking has been confirmed.");
    }

    public final void cancel() {
        setStatus("Cancelled");
        System.out.println("Booking has been cancelled.");
    }

    @Override
    public double calcTotal() {
        double total = 0;
        for (Accommodation ac : accommodation) {
            total += ac.getPrice();
        }

        total += total * Bookable.VAT;

        return total;
    }

    //setters & getters
    public int getBOOKING_ID() {
        return BOOKING_ID;
    }

    public int getNumOfBookings() {
        return numOfBookings;
    }

    public void setNumOfBookings(int numOfBookings) {
        this.numOfBookings = numOfBookings;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Accommodation[] getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation[] accommodation) {
        this.accommodation = accommodation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String accommodations() {
        String s = "";
        for (Accommodation ser : accommodation) {
            s += ser + "\n-----------------------------------------------------------------\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return String.format("Booking id: %d\nGuest information:\n%sAccommodation:\n%sStatus: %s\nTotal: %.2f SAR",
                getBOOKING_ID(), getGuest(), accommodations(), getStatus(), calcTotal());
    }

}