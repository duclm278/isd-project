package org.openjfx.hellofx.model.bike;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.SimpleService;
import org.openjfx.hellofx.repository.bike.BikeRepository;
import org.openjfx.hellofx.repository.bike.IBikeRepository;

public class BikeService extends SimpleService<Bike, ObjectId> implements IBikeService {
    private IBikeRepository bikeRepository;

    public BikeService() {
        super(new BikeRepository());
        bikeRepository = (IBikeRepository) getRepository();
    }

    // Implement extra specifications if needed
    @Override
    public Bike findByBarcode(String barcode) {
        List<Bike> bikes = bikeRepository.findByField("barcode", String.class, barcode);
        return bikes.isEmpty() ? null : bikes.get(0);
    }
}
