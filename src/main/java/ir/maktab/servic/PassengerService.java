package ir.maktab.servic;

import ir.maktab.data.domain.Location;
import ir.maktab.data.enums.PassengerState;
import ir.maktab.data.enums.PaymentType;
import ir.maktab.servic.dto.PassengerDto;
import ir.maktab.servic.exception.InvalidChoiceException;

import java.util.List;

public interface PassengerService {
    void requestTravel(PassengerDto passengerDto, PaymentType paymentType, Location origin, Location destination);
    void increaseAccountBalance(PassengerDto passengerDto, int amount) throws Exception;
    PassengerState getPassengerState(PassengerDto passengerDto) throws Exception;
    boolean validChoice(int choice) throws InvalidChoiceException;
    void create(PassengerDto passengerDto);
    void update(PassengerDto passengerDto) throws Exception;
    PassengerDto get(Long id) throws Exception;
    List getAll();
}
