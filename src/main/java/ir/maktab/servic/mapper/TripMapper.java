package ir.maktab.servic.mapper;

import ir.maktab.data.domain.Trip;
import ir.maktab.servic.dto.*;

public interface TripMapper {
    Trip toTrip(TripDto tripDto);

    TripDto toTripDto(Trip trip);
}
