import entity.Room;

public class test {
    public enum eStatus {
        Rented, Available, Repair;
    }

    public static void main(String[] args) {
        entity.Room.eStatus es = Room.eStatus.valueOf(Room.eStatus.class, "Rented");
        System.out.println(es.ordinal());

    }
}
