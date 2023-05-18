import java.util.HashMap;

class StudyRoomUnavailableException extends Exception {
    public StudyRoomUnavailableException() {
        super("Study Room not Available");
    }
}

class StudyRoom {
    public int getRoom_number() {
        return Room_number;
    }
    public int getCapacity() {
        return Capacity;
    }
    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
    public int getMax_capacity() {
        return Max_Capacity;
    }
    public boolean isAvailabilty_status() {
        return Availabilty_status;
    }
    public void setAvailabilty_status(boolean availabilty_status) {
        Availabilty_status = availabilty_status;
    }
    public void incCapacity() {
        Capacity++;
    }
    public void decCapacity() {
        Capacity--;
    }

    private int Room_number;
    private int Capacity;
    private int Max_Capacity;
    private boolean Availabilty_status;

    private Object CapacityLock = new Object();
    private Object AvailabilityLock = new Object();


    public StudyRoom(int room_number, int capacity) {
        Room_number = room_number;
        Capacity = capacity;
        Max_Capacity = capacity;
        Availabilty_status = true;
    }
}

class StudyRoomReservationSystem {

    private HashMap<Integer,StudyRoom> AvailableRooms = new HashMap<>();

    public  void addStudyRoom(StudyRoom room) {
        AvailableRooms.put(room.getRoom_number(),room);
    }

    public void reserveStudyRoom(int roomNUmber) throws StudyRoomUnavailableException {
        synchronized (AvailableRooms.get(roomNUmber)) {
            if (AvailableRooms.get(roomNUmber).isAvailabilty_status() == false) {
                throw new StudyRoomUnavailableException();

            }
            else {
                AvailableRooms.get(roomNUmber).decCapacity();
                if (AvailableRooms.get(roomNUmber).getCapacity() <= 0) {
                    AvailableRooms.get(roomNUmber).setAvailabilty_status(false);
                }
            }
        }
    }

    public void releaseStudyRoom(int roomNumber) {
        var room = AvailableRooms.get(roomNumber);
        synchronized (room) {
            if (room.getCapacity() == 0) {
                room.setAvailabilty_status(true);
            }
            if (room.getMax_capacity() > room.getCapacity()) {
                room.incCapacity();
            }
        }
    }

    public void displayStudyRoomStatus() {
        System.out.println("Study Room Status:");
        for (var x : AvailableRooms.keySet()) {
            System.out.println("Room Number: "+ x + ", Capacity: " +
                    AvailableRooms.get(x).getCapacity()+ ", Availability: " +
                    ((AvailableRooms.get(x).isAvailabilty_status()) ? "Available":"Not Available"));
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        StudyRoom room1 = new StudyRoom(1, 4);
        StudyRoom room2 = new StudyRoom(2, 6);
        StudyRoom room3 = new StudyRoom(3, 8);

        StudyRoomReservationSystem reservationSystem = new StudyRoomReservationSystem();

        reservationSystem.addStudyRoom(room1);
        reservationSystem.addStudyRoom(room2);
        reservationSystem.addStudyRoom(room3);

        reservationSystem.displayStudyRoomStatus();

        try {
            reservationSystem.reserveStudyRoom(1);
            //System.out.println("Student 1 reserved Study Room 1.");
        }
        catch (StudyRoomUnavailableException e) {
            //System.out.println("Error: " + e.getMessage());
        }
    }
}