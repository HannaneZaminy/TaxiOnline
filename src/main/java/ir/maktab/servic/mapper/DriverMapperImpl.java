package ir.maktab.servic.mapper;

import ir.maktab.data.domain.Driver;
import ir.maktab.servic.dto.*;

public class DriverMapperImpl implements DriverMapper {
    @Override
    public Driver toDriver(DriverDto driverDto) {
        return (Driver) new Driver().setName(driverDto.getName()).setAge(driverDto.getAge()).setLastName(driverDto.getLastName())
                .setPhone(driverDto.getPhone()).setUserName(driverDto.getUserName()).setLocation(driverDto.getLocation());
    }

    @Override
    public DriverDto toDriverDto(Driver driver) {

    return new DriverDto().setAge(driver.getAge()).setName(driver.getName());
    }
}
