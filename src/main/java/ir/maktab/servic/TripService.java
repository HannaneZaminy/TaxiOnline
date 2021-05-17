package ir.maktab.servic;
import ir.maktab.data.domain.Trip;
import ir.maktab.servic.dto.*;

import java.util.List;

public interface TripService {
    void create(TripDto tripDto);
    void update(TripDto tripDto) throws Exception;
    TripDto get(Long id) throws Exception;
    List<Trip> getAll();
}
