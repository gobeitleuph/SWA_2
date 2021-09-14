package Statistics;

import Booking.Booking;
import Payment.Payment;

public interface Visitor {
    String visitBooking(Booking bk);
    String visitPayment(Payment pm);
}
