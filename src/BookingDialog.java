import Booking.Booking;
import Booking.BookingType;
import Person.Person;
import Resource.ResourceSelection;
import ViewController.BookingController;
import ViewController.CommandController;
import ViewController.CommandExecutor;


import java.security.PrivateKey;
import java.util.List;
import java.util.Scanner;

public class BookingDialog {
    private CommandExecutor commandExecutor;
    private String menuOption;
    private BookingType bookingType;
    private Person person;
    private ResourceSelection resource;

    public BookingDialog() {
        this.commandExecutor = new CommandExecutor();
    }
    public String showMenu(){
        System.out.println("1: Add Booking\n2: Delete Booking \n3: View Booking");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="31";
                return menuOption;
            }
            case"2":{
                this.menuOption ="32";
                return menuOption;
            }
            case"3":{
                this.menuOption ="33";
                return menuOption;
            }
            default:{
                throw new IllegalStateException("Input not known! Please try again" );
            }
        }
    }
    public List<Booking> dataInput(List<Booking>  bookingList, List<Person> personList, List<ResourceSelection> resourceList){

        System.out.println("Please select person for booking");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + personList.get(i).getName() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String personNumberInput = scanner12.next();
        this.person = personList.get(Integer.parseInt(personNumberInput));

        System.out.println("Please select resource for booking");
        for(int i=0; i < resourceList.size(); i++){
            System.out.println(i + resourceList.get(i).getLabel() );
        }
        Scanner scanner13 = new Scanner(System.in);
        String resourceNumberInput = scanner13.next();
        this.resource = resourceList.get(Integer.parseInt(resourceNumberInput));

        System.out.println("Please select a language for the booking\n1: English\n2: German");
        Scanner scanner3 = new Scanner(System.in);
        String languageOption = scanner3.next();
        switch (languageOption){
            case"1":{
                this.bookingType = BookingType.EnglishBooking;
                break;
            }
            case"2":{
                this.bookingType = BookingType.GermanBooking;
                break;
            }
            default:{
                throw new IllegalStateException("Input '" + languageOption + "' not known! Please try again" );
            }
        }

        CommandController bookcon1 = new BookingController(person, resource, bookingType);
        commandExecutor.executeCommand("creatBooking",bookcon1);
        Booking booking1 = ((BookingController) bookcon1).getBooking();
        bookingList.add(booking1);

        return bookingList;
    }
    public List<Booking> dataDelete(List<Booking>  bookingList){
        System.out.println("Please enter the number of the resource you want to delete");
        for(int i=0; i < bookingList.size(); i++){
            System.out.println(i + bookingList.get(i).getPerson().getName() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String numberInput = scanner12.next();
        bookingList.remove(Integer.parseInt(numberInput));
        return bookingList;
    }
    public void dataOutput(List<Booking>  bookingList){
        System.out.println("Current bookings");
        for(int i=0; i < bookingList.size(); i++){
            System.out.println(i + " " + bookingList.get(i).getPerson().getName() + " " + bookingList.get(i).getResource().getLabel());
        }
    }
}
