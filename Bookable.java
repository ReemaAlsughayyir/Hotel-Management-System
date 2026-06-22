/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public interface Bookable {

    public static final double VAT = 0.15;

    public static final int MAX_BOOKING = 3;

    public abstract void book();

    public abstract double calcTotal();

}