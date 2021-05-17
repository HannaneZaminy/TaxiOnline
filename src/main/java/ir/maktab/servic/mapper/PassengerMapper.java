package ir.maktab.servic.mapper;

import ir.maktab.data.domain.Passenger;
import ir.maktab.servic.dto.*;

public interface PassengerMapper {
    Passenger toPassenger(PassengerDto passengerDto);

    PassengerDto toPassengerDto(Passenger passenger);
}
