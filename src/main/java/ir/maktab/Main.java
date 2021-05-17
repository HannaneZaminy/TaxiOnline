package ir.maktab;

import ir.maktab.configoration.Config;
import ir.maktab.data.domain.Account;
import ir.maktab.data.domain.Driver;
import ir.maktab.data.domain.Passenger;
import ir.maktab.data.enums.DriverState;
import ir.maktab.data.enums.PassengerState;
import ir.maktab.servic.exception.InvalidAgeException;
import ir.maktab.servic.exception.InvalidChoiceException;
import ir.maktab.servic.exception.InvalidInformationException;
import ir.maktab.servic.exception.InvalidPhoneException;
import ir.maktab.web.AccountController;
import ir.maktab.web.DriverController;
import ir.maktab.web.PassengerController;
import ir.maktab.web.TripController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class Main {
    public static ApplicationContext iocContainer = new AnnotationConfigApplicationContext(Config.class);
    public static DriverController driverController = iocContainer.getBean(DriverController.class);
    public static PassengerController passengerController = iocContainer.getBean(PassengerController.class);
    public static TripController tripController = iocContainer.getBean(TripController.class);
    public static Scanner scanner = (Scanner) iocContainer.getBean("scanner");

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("wel come to taxi online");
        int choice = 0;
        do {
            System.out.println(mainMenu());
            choice = scanner.nextInt();
            try {
                if (validChoice(choice)) {
                    switch (choice) {
                        case 1:
                            System.out.println("Number of driver: ");
                            int numberOfDriver = scanner.nextInt();
                            addGroupDrivers(numberOfDriver);

                            break;
                        case 2:
                            System.out.println("Number of passengers: ");
                            int numberOfPassenger = scanner.nextInt();
                            addGroupPassengers(numberOfPassenger);
                            break;
                        case 3:
                            System.out.print("Your user name: ");
                            registerOrLoginDriver(scanner.nextInt());
                            break;
                        case 4:
                            System.out.print("Your user name: ");
                            registerOrLoginPassenger(scanner.nextInt());
                            break;
                        case 5:
                            tripController.showAllTrips();
                            break;
                        case 6:
                            driverController.showDrivers();
                            break;
                        case 7:
                            passengerController.showPassengers();
                            break;
                    }
                }
            } catch (InvalidChoiceException | InvalidPhoneException | InvalidInformationException | InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 8);
    }

    private static String mainMenu() {
        return "1. Add a group of drivers" +
                "\n2. Add a group of passengers" +
                "\n3. Driver sign up or login" +
                "\n4. Passenger sign up or login" +
                "\n5. Show on going travels" +
                "\n6. Show a list of drivers" +
                "\n7. Show a list of passengers" +
                "\n8. Exit";
    }

    private static boolean validChoice(int choice) throws InvalidChoiceException {

        if (choice >= 1 && choice <= 9) {
            return true;
        }
        throw new InvalidChoiceException("Your choice is invalid. Please try again.");
    }

    private static void addGroupDrivers(int number) throws InvalidPhoneException, InvalidInformationException {
        for (int i = 0; i < number; i++) {
            String info = scanner.next();
            String carInfo=scanner.next();
            driverController.addDrivers(info,carInfo);

        }
    }

    private static void addGroupPassengers(int number) throws InvalidPhoneException, InvalidInformationException {
        for (int i = 0; i < number; i++) {
            String info = scanner.next();
            passengerController.addPassenger(info);

        }
    }

    private static void registerOrLoginDriver(int id) throws Exception {
        Driver foundDriver = driverController.findDriver((long) id);
        if (foundDriver == null) {
            String info = scanner.next();
            String carInfo=scanner.next();
            driverController.addDrivers(info,carInfo);
        } else {
            driverController.loginDriver(foundDriver);
        }
    }
    private static void registerOrLoginPassenger(int id) throws Exception {
        Passenger passenger=passengerController.findPassenger((long) id);
        if (passenger == null) {
           passengerController.registerNewPassenger();
        } else {
            passengerController.loginPassenger(passenger);
        }
    }

}