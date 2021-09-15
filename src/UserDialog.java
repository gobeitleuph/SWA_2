import Booking.BookingType;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserDialog {
    private BookingType languageType;
    private String menuOption;

    public void showMenu(BookingType language){
        switch (language){
            case EnglishBooking :{
                System.out.println("Please select number:\n1 Car Reservation Service\n2 Options Authentication\n3 Options Booking\n4 Options Content\n5 Options Payment\n6 Options Person\n7 Options Resource\n8 Options Statistics");
                Scanner scanner = new Scanner(System.in);
                String menuOption = scanner.next();
                break;
            }
            case GermanBooking:{
                System.out.println("Bitte Nummer wählen:\n1 Car Reservation Service\n2 Optionen Authentifizierung\n3 Optionen Buchung\n4 Optionen Inhalt\n5 Optionen Bezahlung\n6 Optionen Person\n7 Optionen Ressource\n8 Optionen Statistik ");
                Scanner scanner = new Scanner(System.in);
                this.menuOption = scanner.next();
                break;
            }
        }
        switch (menuOption){
            case "1":{
                carReservationDialog();
                break;
            }
            case "2":{
                System.out.println("2");
                break;
            }
            case "3":{
                System.out.println("3");
                break;
            }
            case "4":{
                System.out.println("4");
                break;
            }
            case "5":{
                System.out.println("5");
                break;
            }
            case "6":{
                System.out.println("6");
                break;
            }
            case "7":{
                System.out.println("7");
                break;
            }
            case "8":{
                System.out.println("8");
                break;
            }
        }
    }

    public BookingType selectLanguage(){
        System.out.println("Please select a language by typing the number of your chosen option.\nBiite wählen Sie eine Sprache aus, durch Eingabe der Nummer Ihrer gewaehlen Option.\n Option 1: English \n Option 2: Deutsch");
        Scanner scanner = new Scanner(System.in);
        String languageOption = scanner.next();
        switch (languageOption){
            case"1":{
                this.languageType = BookingType.EnglishBooking;
                break;
            }
            case"2":{
                this.languageType = BookingType.GermanBooking;
                break;
            }
            default:{
                throw new IllegalStateException("Input '" + languageOption + "' not known! Please try again" );
            }
        }
        return this.languageType;

    }

    public void carReservationDialog (){
        System.out.println("Welcome to the Car Reservation Service");
        System.out.println("Please give in some details to your person to continue.");
    }


}
