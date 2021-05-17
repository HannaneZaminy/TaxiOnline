package ir.maktab.servic;

import java.util.List;

import ir.maktab.data.domain.Driver;
import ir.maktab.data.enums.DriverState;
import ir.maktab.data.enums.PaymentType;
import ir.maktab.data.enums.TripConfirmationState;
import ir.maktab.servic.dto.*;
import ir.maktab.servic.exception.InvalidChoiceException;

public interface DriverService {
    void requestForFinishTrip(DriverDto driverDto) throws Exception;
    void setConfirmationState(DriverDto driverDto) throws Exception;
    boolean validChoice(int choice) throws InvalidChoiceException;

    PaymentType getPaymentType(DriverDto driverDto) throws Exception;

    DriverState getDriverState(DriverDto driverDto) throws Exception;

    void create(DriverDto driverDto);

    void update(DriverDto driverDto) throws Exception;

    DriverDto get(Long id) throws Exception;

    List getAll();
}
