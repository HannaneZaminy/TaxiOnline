package ir.maktab.web;

import ir.maktab.data.domain.*;
import ir.maktab.data.enums.PassengerState;
import ir.maktab.data.enums.PaymentType;
import ir.maktab.servic.PassengerService;
import ir.maktab.servic.dto.PassengerDto;
import ir.maktab.servic.exception.InvalidChoiceException;
import ir.maktab.servic.exception.InvalidInformationException;
import ir.maktab.servic.exception.InvalidPhoneException;
import ir.maktab.servic.mapper.PassengerMapper;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@Controller
public class PassengerController {
    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;
    public static Scanner scanner = new Scanner(System.in);

    public PassengerController(PassengerService passengerService, PassengerMapper passengerMapper) {
        this.passengerService = passengerService;
        this.passengerMapper = passengerMapper;
    }

    public Passenger findPassenger(Long id) throws Exception {
        PassengerDto passengerDto = passengerService.get(id);
        return passengerMapper.toPassenger(passengerDto);
    }

    public void registerPassenger(Passenger passenger) {
        passengerService.create(passengerMapper.toPassengerDto(passenger));
    }

    public void addPassenger(String info) throws InvalidInformationException, InvalidPhoneException {
        String[] splitInfo = info.split(",");
        for (String s : splitInfo) {
            if (s == null) {
                throw new InvalidInformationException("Please enter your information correctly.");
            }
        }
        if (!Pattern.matches("09(0[1-2]|1[0-9]|3[0-9]|2[0-1])-?[0-9]{3}-?[0-9]{4}", splitInfo[4])) {
            throw new InvalidPhoneException("Please enter your phone number correct.");
        }
        Passenger passenger = new Passenger(splitInfo[0], splitInfo[1], splitInfo[2], Integer.parseInt(splitInfo[3]), splitInfo[4]);
        registerPassenger(passenger);
    }

    public void loginPassenger(Passenger passenger) throws Exception {
        PassengerState passengerState = passengerService.getPassengerState(passengerMapper.toPassengerDto(passenger));
        if (passengerState == PassengerState.ATTEND_THE_TRIP) {
            System.out.println("Passenger: " + passenger.toString());
            travellingPassengerOperation(passenger);
        }
        if (passengerState == PassengerState.NON_ATTENDANCE_THE_TRIP) {
            passengerOperationWithOutTravel(passenger);
        }
    }

    private void passengerOperationWithOutTravel(Passenger passenger) {
        int choice = 0;
        System.out.println(passenger.toString());
        do {
            try {
                PassengerState passengerState = passengerService.getPassengerState(passengerMapper.toPassengerDto(passenger));
                if (passengerState == PassengerState.NON_ATTENDANCE_THE_TRIP) {
                    System.out.println("1. Travel request (pay by cash)" +
                            "\n2. Travel request (pay by account balance)" +
                            "\n3. Increase account balance" +
                            "\n4. Exit");

                    choice = scanner.nextInt();
                    if (passengerService.validChoice(4)) {
                        switch (choice) {
                            case 1:
                                requestTravel(passenger, PaymentType.PAY_BY_CASH);
                                break;
                            case 2:
                                requestTravel(passenger, PaymentType.PAY_BY_ACCOUNT_BALANCE);
                                break;
                            case 3:
                                int amount = scanner.nextInt();
                                passengerService.increaseAccountBalance(passengerMapper.toPassengerDto(passenger),amount);
                                break;
                            case 4:
                                break;
                        }
                    }

                }
                if (passenger.getState() == PassengerState.ATTEND_THE_TRIP) {
                    travellingPassengerOperation(passenger);
                    break;
                }
            } catch (InvalidChoiceException  e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice !=4);
    }

    public void requestTravel(Passenger passenger, PaymentType paymentType) {
        Location origin = new Location(scanner.nextInt(), scanner.nextInt());
        Location destination = new Location(scanner.nextInt(), scanner.nextInt());
        passengerService.requestTravel(passengerMapper.toPassengerDto(passenger), paymentType, origin, destination);
    }

    private void travellingPassengerOperation(Passenger passenger) {
        int choice;
        do {
            System.out.println("1. Increase account balance" +
                    "\n2. Exit");
            choice = scanner.nextInt();
            try {
                if (passengerService.validChoice(choice)) {
                    if (choice == 1) {
                        int amount = scanner.nextInt();
                        passengerService.increaseAccountBalance(passengerMapper.toPassengerDto(passenger), amount);
                    }
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice != 2);
    }

    public void registerNewPassenger() {
        int choice;
        do {
            System.out.println("1. Register" +
                    "\n2. Exit");
            choice = scanner.nextInt();
            try {
                if (passengerService.validChoice(choice)) {
                    if (choice == 1) {
                        Passenger passenger = new Passenger(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next());
                        registerPassenger(passenger);
                    }
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 2);
    }
    public List showPassengers(){
       return passengerService.getAll();
    }
}
