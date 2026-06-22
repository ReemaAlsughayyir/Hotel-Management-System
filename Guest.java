/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
public class Guest {

    private final int ID;
    private String name;
    private String email;
    private String phoneNo;

    //constructors

    public Guest(int ID, String name, String email, String phoneNo) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    

    public Guest() {
        this(0, "", "", "");
    }

    //setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
     public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nEmail: %s\nPhone number: %s\n", ID, name, email, phoneNo);
    }

}