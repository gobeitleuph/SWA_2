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
                carReservationDialog(language);
                break;
            }
            case "2":{
                AuthenticationDialog authenticationDialog = new AuthenticationDialog();
                authenticationDialog.showMenu();

                break;
            }
            case "3":{
                BookingDialog bookingDialog = new BookingDialog();
                bookingDialog.showMenu();
                break;
            }
            case "4":{
                ContentDialog contentDialog = new ContentDialog();
                contentDialog.showMenu();
                break;
            }
            case "5":{
                PaymentDialog paymentDialog = new PaymentDialog();
                paymentDialog.showMenu();
                break;
            }
            case "6":{
                PersonDialog personDialog = new PersonDialog();
                personDialog.showMenu();
                break;
            }
            case "7":{
                ResourceDialog resourceDialog = new ResourceDialog();
                resourceDialog.showMenu();
                break;
            }
            case "8":{
                StatisticsDialog statisticsDialog = new StatisticsDialog();
                statisticsDialog.showMenu();
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

    public void carReservationDialog (BookingType language){
        System.out.println("Welcome to the Car Reservation Service");
        System.out.println("Please give in some details to your person to continue.");
    }


}
