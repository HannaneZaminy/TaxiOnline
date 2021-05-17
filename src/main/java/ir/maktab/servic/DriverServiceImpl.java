package ir.maktab.servic;

import java.util.List;

import ir.maktab.data.domain.Passenger;
import ir.maktab.data.domain.Trip;
import ir.maktab.data.enums.*;
import ir.maktab.data.repository.DriverRepository;
import ir.maktab.servic.dto.*;
import ir.maktab.servic.exception.InvalidChoiceException;
import ir.maktab.servic.mapper.DriverMapper;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public void create(DriverDto driverDto) {
        driverRepository.create(driverMapper.toDriver(driverDto));
    }

    @Override
    public void update(DriverDto driverDto) throws Exception {
        driverRepository.update(driverMapper.toDriver(driverDto));
    }

    @Override
    public DriverDto get(Long id) throws Exception {
     // ??  driverRepository.get(id);
        return null;
    }

    @Override
    public List getAll() {
        return driverRepository.getAll();
    }

    @Override
    public PaymentType getPaymentType(DriverDto driverDto) throws Exception {
        DriverDto foundDriverDto = get((long) driverDto.getDriverId());
        int lastTravelIndex = foundDriverDto.getTrips().size();
        return foundDriverDto.getTrips().get(lastTravelIndex).getPaymentType();
    }

    @Override
    public DriverState getDriverState(DriverDto driverDto) throws Exception {
        DriverDto foundDriverDto = get((long) driverDto.getDriverId());
        return foundDriverDto.getState();
    }

    @Override
    public void requestForFinishTrip(DriverDto driverDto) throws Exception {
        DriverDto foundDriverDto = get((long) driverDto.getDriverId());
        int lastTravelIndex = foundDriverDto.getTrips().size();
        Trip trip = foundDriverDto.getTrips().get(lastTravelIndex);
        if (trip.getConfirmationState().equals(TripConfirmationState.APPROVED)) {
            trip.setState(TripState.FINISHED);
            Passenger passenger = trip.getPassenger();
            passenger.setState(PassengerState.NON_ATTENDANCE_THE_TRIP);
            foundDriverDto.setState(DriverState.WAITING_TO_TRAVEL);
            foundDriverDto.setLocation(trip.getDestination());
            passenger.setLocation(trip.getDestination());
            driverRepository.update(driverMapper.toDriver(foundDriverDto));
        } else {
            System.out.println("Trip must first be confirmed.");
        }
    }

    @Override
    public void setConfirmationState(DriverDto driverDto) throws Exception {
        DriverDto foundDriverDto = get((long) driverDto.getDriverId());
        int lastTravelIndex = foundDriverDto.getTrips().size();
        foundDriverDto.getTrips().get(lastTravelIndex).setConfirmationState(TripConfirmationState.APPROVED);
    }

    @Override
    public boolean validChoice(int choice) throws InvalidChoiceException {
        return exceptionHandler.validChoice(choice);
    }
}

