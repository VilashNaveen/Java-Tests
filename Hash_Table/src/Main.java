import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Hash_Table map = new Hash_Table();
        map.Put(1,"a");
        map.Put(2,"dog");
        map.Put(3,"car");
        map.Put(4,"bus");
        System.out.println(map.Get(3));

        map.Delete(3);
        System.out.println(map.Get(3));
        System.out.println(map.Get(4));
    }
}