package ir.maktab.servic;

import java.util.List;

import ir.maktab.data.domain.Driver;
import ir.maktab.data.domain.Location;
import ir.maktab.data.domain.Trip;
import ir.maktab.data.enums.PassengerState;
import ir.maktab.data.enums.PaymentType;
import ir.maktab.data.enums.TripConfirmationState;
import ir.maktab.data.repository.PassengerRepository;
import ir.maktab.servic.dto.*;
import ir.maktab.servic.exception.InvalidChoiceException;
import ir.maktab.servic.mapper.PassengerMapper;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
   private final PassengerRepository passengerRepository;
   private final PassengerMapper passengerMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    @Override
    public void requestTravel(PassengerDto passengerDto, PaymentType paymentType,Location origin,Location destination) {
        Trip trip = null;
        if (paymentType == PaymentType.PAY_BY_CASH) {
            trip = new Trip(origin, destination, passengerMapper.toPassenger(passengerDto), TripConfirmationState.NON_APPROVED, PaymentType.PAY_BY_CASH);
        }
        if (paymentType == PaymentType.PAY_BY_ACCOUNT_BALANCE) {
            trip = new Trip(origin, destination, passengerMapper.toPassenger(passengerDto),TripConfirmationState.NON_APPROVED, PaymentType.PAY_BY_ACCOUNT_BALANCE);
        }
        Driver driver = trip.getDriver();
        if (driver != null) {
            System.out.println("Your request accepted by: " + driver.toString());
            driver.getTrips().add(trip);
            passengerRepository.update(passengerMapper.toPassenger(passengerDto));
        }
    }

    @Override
    public void increaseAccountBalance(PassengerDto passengerDto, int amount) throws Exception {
        PassengerDto foundPassengerDto = get((long) passengerDto.getPassengerId());
        foundPassengerDto.getAccount().setBalance(amount);
        passengerRepository.update(passengerMapper.toPassenger(passengerDto));
    }

    @Override
    public PassengerState getPassengerState(PassengerDto passengerDto) throws Exception {
        PassengerDto foundPassengerDto = get((long) passengerDto.getPassengerId());
        return foundPassengerDto.getState();
    }

    @Override
    public boolean validChoice(int choice) throws InvalidChoiceException {
        return exceptionHandler.validChoice(choice);
    }

    @Override
    public void create(PassengerDto passengerDto) {

    }

    @Override
    public void update(PassengerDto passengerDto) throws Exception {

    }

    @Override
    public PassengerDto get(Long id) throws Exception {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
}
