import Overview.Booking.BookingService;
import org.junit.platform.engine.support.descriptor.FileSystemSource;

public class Hello {

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("test1");

        BookingService bk1 = new BookingService();

        bk1.createBooking();

        System.out.println();
    }

}
