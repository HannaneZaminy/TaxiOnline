package ir.maktab.web;

import ir.maktab.data.domain.Trip;
import ir.maktab.servic.TripService;
import ir.maktab.servic.mapper.TripMapper;
import ir.maktab.*;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class TripController {
    private final TripService tripService;
    private final TripMapper tripMapper;

    public TripController(TripService tripService, TripMapper tripMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
    }
    public void creatTripe(Trip trip){
        tripService.create(tripMapper.toTripDto(trip));
    }

    public List<Trip> showAllTrips(){
        List <Trip> all = tripService.getAll();
        return all;
    }

}
