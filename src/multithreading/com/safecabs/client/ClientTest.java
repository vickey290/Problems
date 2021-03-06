package multithreading.com.safecabs.client;


import multithreading.com.safecabs.Gender;
import multithreading.com.safecabs.app.CabProvider;
import multithreading.com.safecabs.cab.Cab;
import multithreading.com.safecabs.exceptions.UnRegisteredPassengerException;
import multithreading.com.safecabs.passenger.Passenger;
import multithreading.com.safecabs.passenger.RegisteredPassenger;

import java.util.Random;

public class ClientTest {
    public static void main(String args[]) throws Exception {

        RegisteredPassenger registeredPassenger = new RegisteredPassenger();
        CabProvider cabProvider = new CabProvider(registeredPassenger);

        int cabId = 1;
        for (int passengerId = 0; passengerId < 21; passengerId++) {
            int rand = new Random().nextInt(2);

            Passenger passenger = new Passenger(passengerId, rand == 0 ? Gender.MALE : Gender.FEMALE);

            if (passengerId != 5)
                registeredPassenger.register(passenger); // Passenger 5 not registered for testing
            try {
                cabProvider.requestCab(passenger);
            } catch (UnRegisteredPassengerException e) {
                System.out.println(e.getMessage());
            }
            if (passengerId % 4 == 0)
                cabProvider.addNewAvailableCab(new Cab(cabId++));

            Thread.sleep(1000);
        }
    }

}
