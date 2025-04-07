import java.util.Arrays;
import java.util.Comparator;
public class Plane {
    private PlaneSeat[] seat;
    private int numEmptySeat;

    public Plane() {
        seat = new PlaneSeat[12];
        numEmptySeat = 12;

        for (int i=0;i<12;i++) {
            seat[i] = new PlaneSeat(i+1);
        }
    }
    
    private PlaneSeat[] sortSeats() {
        PlaneSeat[] sortedSeats = Arrays.copyOf(seat, seat.length);
        Arrays.sort(sortedSeats, Comparator.comparingInt(PlaneSeat::getCustomerID));
        return sortedSeats;
        }

    public void showNumEmptySeats() {
        System.out.println("Number of empty seats: " + numEmptySeat);
    }
    
    public void showEmptySeats() {
        seat = sortSeats();
        System.out.println("The following seats are empty:");
        for (PlaneSeat s: seat) {
            if (!s.isOccupied() || seat == null) {
                System.out.print("SeatID" + s.getSeatID());
            }
        }
    }
    public void showAssignedSeats(boolean bySeatId) {
        System.out.println("The seat assignments are as follows:\n");
        if (bySeatId) {
            seat = sortSeats();
            for (PlaneSeat planeSeat: seat) {
                if (planeSeat != null) {
                    System.out.printf("SeatID %d assigned to CustomerId %d\n", planeSeat.getSeatID(), planeSeat.getCustomerID());
                }
            }
        }
        else {
            seat = sortSeats();
            for (PlaneSeat planeSeat : seat) {
                if (planeSeat != null) {
                    System.out.printf("SeatID %d assigned to CustomerId %d\n", planeSeat.getSeatID(), planeSeat.getCustomerID());
                }
            }
        }
    }
    public void assignSeat(int seatId, int cust_id) {
        int index = -1;
        for (int i=0;i<seat.length;i++) {
            if (seat[i] != null && seat[i].getSeatID() == seatId) {
                index = i;
            } 
        }
        if (index == -1 || !seat[index].isOccupied()) {
            PlaneSeat planeSeat = new PlaneSeat(seatId);
            planeSeat.assign(cust_id);
            seat[12-numEmptySeat] = planeSeat;
            numEmptySeat--;
            System.out.println("Seat Assigned!\n");
        }
        else
            System.out.println("Seat already assigned to a customer.\n");
    }
    public void unAssignSeat(int seatId)
    {
        for (PlaneSeat planeSeat : seat) {
            if (planeSeat != null && planeSeat.getSeatID() == seatId) {
                planeSeat.unAssign();
                System.out.println("Seat Unassigned!\n");
            }
        }
    }
}
