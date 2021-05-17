package ir.maktab.servic.mapper;

import ir.maktab.data.domain.Driver;
import ir.maktab.servic.dto.*;

public interface DriverMapper {
    Driver toDriver(DriverDto driverDto);

    DriverDto toDriverDto(Driver driver);
}
