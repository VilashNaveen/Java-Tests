import java.util.Random;
import java.util.Scanner;

public class simple_Startup {
    private int[] sea;
    private int hits;
    private int tries;
    public simple_Startup (int length) {
        sea = new int[length];
        Random random = new Random();
        int location = random.nextInt((length-3) - 0) + 0;
        sea[location] = 1; sea[location+1] = 1; sea[location+2] = 1;
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Battleship test 1");
        System.out.println("sea is "+ sea.length +" miles long");
        while (hits < 3) {
            tries++;
            System.out.println("fire");
            int shot = scanner.nextInt();
            if (sea[shot] == 1) {
                System.out.println("hit");
                hits++;
                sea[shot] = 0;
            }
            else {
                System.out.println("miss");
            }
        }
        System.out.println("kill");
        System.out.println("tries " + tries);
    }
}
