
interface Vehicle {
    void drive();
}
class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Drives a car");
    }
}
class MotorBike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Drives a bike");
    }
}
class car_factory {
    Car create_car() {
        return new Car();
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
