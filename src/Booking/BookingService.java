package Booking;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class BookingService {


	public static void main(String[] args){

		BookingDirector bd1 = new BookingDirector();

		EnglishBookingBuilder engbb = new EnglishBookingBuilder();

		bd1.createEnglishBooking(engbb);

		EnglishBooking engB = engbb.getResult();

		System.out.println("\nEnglsih Booking built:\n" + engB.print());


	}






}//end BookingService