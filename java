import java.util.ArrayList;
import java.util.List;

class Baggage {
    private int weight;
    private String description;

    public Baggage(int weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}

class Passenger {
    private String name;
    private List<Baggage> baggage = new ArrayList<>();

    public Passenger(String name) {
        this.name = name;
    }

    public void addBaggage(Baggage baggageItem) {
        baggage.add(baggageItem);
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public String getName() {
        return name;
    }
}

class Flight {
    private String flightNumber;
    private List<Passenger> passengers = new ArrayList<>();

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void displayPassengerBaggage() {
        System.out.println("Багаж на авіарейсі " + flightNumber + ":");
        for (Passenger passenger : passengers) {
            System.out.println("Пасажир: " + passenger.getName());
            List<Baggage> baggage = passenger.getBaggage();
            for (Baggage item : baggage) {
                System.out.println("  Багаж: " + item.getDescription() + ", Вага: " + item.getWeight() + " кг");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight("AA123");

        Passenger passenger1 = new Passenger("Петро");
        passenger1.addBaggage(new Baggage(20, "Великий чемодан"));
        passenger1.addBaggage(new Baggage(5, "Ручна сумка"));

        Passenger passenger2 = new Passenger("Марія");
        passenger2.addBaggage(new Baggage(15, "Спортивна сумка"));

        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);

        flight.displayPassengerBaggage();
    }
}
