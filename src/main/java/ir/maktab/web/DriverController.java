package ir.maktab.web;

import ir.maktab.data.domain.Car;
import ir.maktab.data.domain.Driver;
import ir.maktab.data.enums.DriverState;
import ir.maktab.data.enums.PaymentType;
import ir.maktab.servic.DriverService;
import ir.maktab.servic.dto.DriverDto;
import ir.maktab.servic.exception.InvalidChoiceException;
import ir.maktab.servic.exception.InvalidInformationException;
import ir.maktab.servic.exception.InvalidPhoneException;
import ir.maktab.servic.mapper.DriverMapper;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class DriverController {
    private final DriverService driverService;
    private final DriverMapper driverMapper;
    public static Scanner scanner = new Scanner(System.in);
    public DriverController(DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    public void registerDriver(Driver driver) {
        driverService.create(driverMapper.toDriverDto(driver));
    }

    public Driver findDriver(Long id) throws Exception {
        DriverDto driverDto = driverService.get(id);
        return driverMapper.toDriver(driverDto);
    }

    public void addDrivers(String personalInfo , String carInfo) throws InvalidInformationException, InvalidPhoneException {
        String[] splitInfo = personalInfo.split(",");
        for (String s : splitInfo) {
            if (s == null) {
                throw new InvalidInformationException("Please enter your information correctly.");
            }
        }
        String[] splicerInfo = carInfo.split(",");
        for (String s : splicerInfo) {
            if (s == null) {
                throw new InvalidInformationException("Please enter your information correctly.");
            }
        }
        Car car=new Car(splicerInfo[0],splitInfo[1],splitInfo[2]);
        Driver driver = new Driver(splitInfo[0], splitInfo[1], splitInfo[2], Integer.parseInt(splitInfo[3]), splitInfo[4]);
        driver.setCar(car);
        registerDriver(driver);
    }
    public void loginDriver(Driver driver) throws Exception {
        DriverState driverState = driverService.getDriverState(driverMapper.toDriverDto(driver));
        switch (driverState) {
            case WAITING_TO_TRAVEL:
                waitingDriverOperation();
                break;
            case DOING_THE_TRAVEL:
                travellingDriverOperation(driver);
                break;
        }
    }
   public void waitingDriverOperation() {
        int choice;
        choice =scanner.nextInt();
        System.out.println("You are waiting for a trip.");
        do {
            System.out.println("1. Exit");
            if (choice == 1) {
                break;
            }
        } while (choice != 1);
    }
    private void travellingDriverOperation(Driver driver) throws Exception {
        System.out.println("Driver: " + driver.toString());
        PaymentType paymentType = driverService.getPaymentType(driverMapper.toDriverDto(driver));
        switch (paymentType) {
            case PAY_BY_CASH:
                payByCash(driver);
                break;
            case PAY_BY_ACCOUNT_BALANCE:
                payByAccountBalance(driver);
                break;
        }
    }
    public void payByCash(Driver driver) {
        int choice;
        do {
            System.out.println("1. Confirm cash receipt" +
                    "\n2. Travel finished" +
                    "\n3. Exit");
            choice = scanner.nextInt();
            try {
                if (driverService.validChoice(choice)) {
                    switch (choice) {
                        case 1:
                            driverService.setConfirmationState(driverMapper.toDriverDto(driver));
                            break;
                        case 2:
                            driverService.requestForFinishTrip(driverMapper.toDriverDto(driver));
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Your choice is invalid. Please try again.");
                    }
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice != 3);
    }
    private void payByAccountBalance(Driver driver) throws Exception {
        int choice;
        do {
            System.out.println("1. Travel finished" +
                    "\n2. Exit");
            choice = scanner.nextInt();
            try {
                if (driverService.validChoice(choice)) {
                    if (choice == 1) {
                        driverService.requestForFinishTrip(driverMapper.toDriverDto(driver));
                    }
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 2);
    }
    public List showDrivers(){
       return driverService.getAll();
    }
}

