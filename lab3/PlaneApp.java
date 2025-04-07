import java.util.Scanner;
public class PlaneApp {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int sel = 0;
        Plane plane = new Plane();

        do {
            System.out.print("""
                             (1) Show the number of empty seats
                             (2) Show the list of empty seats
                             (3) Show the list of customers together with their seat numbers in the order of the seat numbers
                             (4) Show the list of customers together with their seat numbers in the order of the customer ID
                             (5) Assign a customer to a seat
                             (6) Remove a seat assignment
                             (7) Quit
                             Choose an option: """);
            sel = scanner.nextInt();

            switch(sel)
            {
                case 1:
                    plane.showNumEmptySeats();
                    break;
                case 2:
                    plane.showEmptySeats();
                    break;
                case 3:
                    plane.showAssignedSeats(true);
                    break;
                case 4:
                    plane.showAssignedSeats(false);
                    break;
                case 5:
                    System.out.print("Assigning Seat ..\n Please enter SeatID: ");
                    int seatId = scanner.nextInt();
                    System.out.print(" Please enter Customer ID: ");
                    int custId = scanner.nextInt();
                    plane.assignSeat(seatId, custId);
                    break;
                case 6:
                    System.out.print("Enter SeatID to unassign customer from: ");
                    plane.unAssignSeat(scanner.nextInt());
                    break;
            }

        } while (sel != 7);
    }
}
