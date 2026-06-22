/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.gr3;

/**
 *
 * @author ehiss
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Accommodation> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;
        FillList();
        System.out.print("*** WELCOME TO HOTEI MANAGEMENT SYSTEM ***");
        do {
            try {
                Menu();
                choice = input.nextInt();
                switch (choice) {

                    case 1://Add 
                        Add();
                        break;

                    case 2://Remove 
                        Remove();
                        break;

                    case 3://Display 
                        DisplayRooms();
                        break;

                    case 4://make Booking
                        MakeBooking();
                        break;

                    case 5://Show Booking
                        ShowBooking();
                        break;

                    case 6://Cancel Booking
                        CancelBooking();
                        break;

                    case 7://Restaurant Booking
                        RestaurantBooking();
                        break;

                    case 8://GUI
                        SuiteGUI.main(null); //calling static method
                        break;

                    case 9://Write from text file
                        WriteRoomsFromFile();
                        break;

                    case 10://Read from text file
                        ReadRoomsFromFile();
                        break;

                    case 11://Exit
                        System.out.println("Thank you for using our system!\nHave a nice day.");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input");
                input.nextLine();
            } catch (NullPointerException ex) {
                System.out.println(ex);
            } catch (ClassCastException ex) {
                System.out.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } while (choice != 11);

    }

    public static void Menu() {

        System.out.print("\n1. Add Accommodation.\n"
                + "2. Remove Accommodation.\n"
                + "3. Display Accommodation.\n"
                + "4. New Booking.\n"
                + "5. Show Booking.\n"
                + "6. Cancel Booking.\n"
                + "7. Restaurant Booking\n"
                + "8. GUI.\n"
                + "9. Save Accommodations.\n"
                + "10. Read From File.\n"
                + "11.Exit.\n"
                + ">> ");

    }

    public static void RestaurantBooking() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("The Bistro", "Italian", 50, 4.5));
        restaurants.add(new Restaurant("Spice Delight", "Indian", 80, 4.2));
        restaurants.add(new Restaurant("Chez Pierre", "French", 40, 4.8));

        //show the list
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println(i + ": " + restaurants.get(i));
            System.out.println("------------------------");
        }
        System.out.print("Enter the restaurant index:");
        int index = input.nextInt();
        if (index < 0 || index >= restaurants.size()) {
            System.out.println("invalid index");
            return;
        }
        Restaurant restaurant = restaurants.get(index);
        System.out.printf("Your booking total is: %.2f SAR\n", restaurant.calcTotal());
        System.out.println("Thanks for the booking!");
    }

    public static void Add() {
        System.out.print("1. Suite\n"
                + "2. Single room\n"
                + "3. Double room\n"
                + "Select type of the Accommodation to add >> ");
        int type = input.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Invalid choice.");
        } else {

            Accommodation accommodation;
            System.out.print("Enter description accommodation: ");
            String desc = input.nextLine();
            input.nextLine();
            System.out.print("Enter accommodation size: ");
            int size = input.nextInt();
            System.out.print("Enter price: ");
            double price = input.nextDouble();

            if (price < 0) {
                System.out.println("Invalid price");
                return;
            }
            System.out.print("Enter number of beds ");
            int numOfBeds = input.nextInt();
            
            if (type == 1) {

                System.out.print("Enter number of rooms: ");
                int numOfRooms = input.nextInt();
                System.out.print("Enter max guest: ");
                int maxGuests = input.nextInt();
                accommodation = new Suite(desc, size, price, numOfRooms, maxGuests);
            } else if (type == 2) {

                System.out.print("Is has desk? (true/false): ");
                boolean hasDesk = input.nextBoolean();
                accommodation = new SingleRoom(desc, size, price, numOfBeds, hasDesk);
            } else {

                System.out.print("Enter the bed type: ");
                String bedType = input.next();
                accommodation = new DoubleRoom(desc, size, price, numOfBeds, bedType);
            }
            rooms.add(accommodation);
            System.out.println("Accommodation has been added to the list.");
        }//end else
    }

    public static void Remove() {

        System.out.print("Enter accommodation id to remove: ");
        int accommodationId = input.nextInt();
        boolean removed = false;
        for (int i = 0; i < rooms.size(); i++) {
            Accommodation ele = rooms.get(i);
            if (ele.getId() == accommodationId) {
                rooms.remove(i);
                removed = true;
                break;
            }
        }//end loop
        if (removed) {
            System.out.println("Accommodation with id " + accommodationId + " has been removed.");
        } else {
            System.out.println("No accommodation with id " + accommodationId + " is found.");
        }
    }

    public static void DisplayRooms() {
        for (Accommodation accommodation : rooms) {
            System.out.println(accommodation);
            System.out.printf("Booking Price Per Day: %.2f SAR.\n", accommodation.getPrice());

            //polymorphic methods(abstract and overriden)                       
            System.out.println("Service type: " + accommodation.serviceType());
            System.out.println("Amenities:");
            accommodation.showAmenities();
            //downcasting to call a specific methods
            if (accommodation instanceof Suite) {
                ((Suite) accommodation).spaServicestype();
            }
            System.out.println("***************************************************");
        }
        System.out.println("Total Accommodation: " + Accommodation.getNumOfUnits());//calling static method
    }

    public static void FillList() {

        rooms.add(new Suite("Luxury Suite", 100.0, 500.0, 2, 4));
        rooms.add(new Suite("Deluxe Suite", 80.0, 400.0, 1, 2));

        rooms.add(new SingleRoom("Standard Single Room", 20.0, 100.0, 1, true));
        rooms.add(new DoubleRoom("Deluxe Double Room", 30.0, 150.0, 2, "One King Size Bed"));
    }

    public static void MakeBooking() {
        System.out.print("How many accommodation you want to booking ?(1..3): ");
        int num = input.nextInt();
        if (num < 1 || num > Bookable.MAX_BOOKING) {
            System.out.println("Invalid booking number.");
            return;
        }
        Accommodation[] bookingAccommodation = new Accommodation[num];
        System.out.println("Enter " + num + " accommodation ids:");
        int count = 0;
        while (count < num) {
            System.out.printf("Enter accommodation #%d id: ", (count + 1));
            int accommodationId = input.nextInt();
            //search for accommodation
            boolean isFound = false;
            for (Accommodation ele : rooms) {
                if (ele.getId() == accommodationId) {
                    if (ele.isAvailable()) {
                        bookingAccommodation[count] = ele;

                        isFound = true;
                        count++;
                        break;
                    } else {
                        System.out.println("Sorry is not available...");
                    }

                }
            }
            if (!isFound) {
                System.out.println("Invalid Accommodation id!");
            }
        }//end while loop

        //read guest info
        System.out.print("Enter guest id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter guest name: ");
        String name = input.nextLine();
        System.out.print("Enter guest email: ");
        String email = input.nextLine();
        System.out.print("Enter guest phoneNo: ");
        String phoneNo = input.nextLine();

        Guest guest = new Guest(id, name, email, phoneNo);
        Booking booking = new Booking(guest, bookingAccommodation);
        System.out.print("Confirm booking? (Y/N): ");
        char answer = input.next().charAt(0);
        if (answer == 'y' || answer == 'Y') {

            for (Accommodation accommodation : bookingAccommodation) {
                accommodation.setAvailable(false);
            }
            booking.book();//final method
            bookings.add(booking);
            System.out.println(booking);
        } else {
            System.out.println("Your booking has been cancelled!");
        }
    }

    public static void ShowBooking() {
        System.out.print("Enter booking id: ");
        int bookingId = input.nextInt();
        boolean found = false;
        for (Booking ele : bookings) {
            if (ele.getBOOKING_ID() == bookingId) {
                System.out.println(ele);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Booking with id " + bookingId + " is not found.");
        }
    }

    public static void CancelBooking() {
        System.out.print("Enter booking id: ");
        int bookingId = input.nextInt();
        boolean found = false;
        for (Booking ele : bookings) {
            if (ele.getBOOKING_ID() == bookingId) {
                ele.cancel();
                System.out.println(ele);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Booking with id " + bookingId + " is not found.");
        }
    }

    public static void ReadRoomsFromFile() {
        ReadTextFile rt = new ReadTextFile();

        rt.openTextFile("Rooms.txt");
        rt.readFromFile();
        rt.closeFile();

        System.out.println("Successfully read!");
    }

    public static void WriteRoomsFromFile() {
        WriteTextFile wf = new WriteTextFile();
        wf.openTextFile("Rooms.txt");
        if (rooms.isEmpty()) {
            System.out.println("No rooms yet.");
        } else {
            for (Accommodation ele : rooms) {
                wf.writeToFile(ele);
            }
        }
        wf.closeFile();
        System.out.println("All Rooms saved to the text file Rooms.txt");
    }
}
