package ir.maktab.servic;

import java.util.List;

import ir.maktab.data.domain.Trip;
import ir.maktab.data.repository.TripRepository;
import ir.maktab.servic.dto.*;
import ir.maktab.servic.mapper.TripMapper;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Override
    public void create(TripDto tripDto) {
        tripRepository.create(tripMapper.toTrip(tripDto));
    }

    @Override
    public void update(TripDto tripDto) throws Exception {

    }

    @Override
    public TripDto get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Trip> getAll() {
       return tripRepository.getAll();
    }
}
