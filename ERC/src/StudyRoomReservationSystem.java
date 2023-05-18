import java.util.HashMap;

class StudyRoomUnavailableException extends Exception {
    public StudyRoomUnavailableException() {
        super("Study Room not Avaiilable");
    }
}

class StudyRoom {
    public int getRoom_number() {
        return Room_number;
    }
    public int getCapacity() {
        synchronized (CapacityLock){
            return Capacity;
        }
    }
    public void setCapacity(int capacity) {
        synchronized (CapacityLock) {
            Capacity = capacity;
        }
    }
    public int getMax_capacity() {
        return Max_Capacity;
    }
    public boolean isAvailabilty_status() {
        synchronized (AvailabilityLock) {
            return Availabilty_status;
        }
    }
    public void setAvailabilty_status(boolean availabilty_status) {
        synchronized (AvailabilityLock) {
            Availabilty_status = availabilty_status;
        }
    }
    public void incCapacity() {
        synchronized (CapacityLock) {
            Capacity++;
        }
    }
    public void decCapacity() {
        synchronized (CapacityLock) {
            Capacity--;
        }
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


public class StudyRoomReservationSystem {

    private static HashMap<Integer,StudyRoom> AvailableRooms = new HashMap<>();

    public static void CreateRoom(int room_number, int capacity) {
        AvailableRooms.put(room_number,new StudyRoom(room_number,capacity));
    }

    public static void reserveStudyRoom(int roomNUmber) throws StudyRoomUnavailableException {

        if (AvailableRooms.get(roomNUmber).isAvailabilty_status() == false) {
            throw new StudyRoomUnavailableException();

        }
        else {
            AvailableRooms.get(roomNUmber).decCapacity();
            System.out.println("room Booked " + roomNUmber);
            if (AvailableRooms.get(roomNUmber).getCapacity() <= 0) {
                AvailableRooms.get(roomNUmber).setAvailabilty_status(false);
            }
        }
    }

    public static void releaseStudyRoom(int roomNumber) {
        var room = AvailableRooms.get(roomNumber);
        if (room.getCapacity() == 0) {
            room.setAvailabilty_status(true);
        }
        if (room.getMax_capacity() > room.getCapacity()) {
            room.incCapacity();
            //System.out.println("room released " + roomNumber);
        }
    }

    public static void displayStudyRoomStatus() {
        for (var x : AvailableRooms.keySet()) {
            System.out.println(x + " Room availability : " +
                    AvailableRooms.get(x).isAvailabilty_status() + "  Current Capacity : "+
                    AvailableRooms.get(x).getCapacity() + "/" +AvailableRooms.get(x).getMax_capacity());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CreateRoom(210,50);
        CreateRoom(211,2);
        CreateRoom(212,10);
        CreateRoom(213,1);

        displayStudyRoomStatus();

        var thread1 = new Thread(() -> {
            try {
                reserveStudyRoom(213);
                displayStudyRoomStatus();

            } catch (StudyRoomUnavailableException e) {
                System.out.println(e.getMessage());
            }
        });
        thread1.start();

        var thread2 = new Thread(() -> {
            try {
                reserveStudyRoom(212);
                displayStudyRoomStatus();

            } catch (StudyRoomUnavailableException e) {
                System.out.println(e.getMessage());
            }
        });
        thread2.start();

        var thread3 = new Thread(() -> {
            releaseStudyRoom(213);
            displayStudyRoomStatus();

        });
        thread3.start();

        var thread4 = new Thread(() -> {
            try {
                reserveStudyRoom(211);
                displayStudyRoomStatus();

            } catch (StudyRoomUnavailableException e) {
                System.out.println(e.getMessage());
            }
        });
        thread4.start();



        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done");

    }
}