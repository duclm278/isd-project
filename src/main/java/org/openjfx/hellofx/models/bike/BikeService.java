package org.openjfx.hellofx.models.bike;

import org.openjfx.hellofx.models.common.BaseService;

import com.mongodb.client.MongoCollection;

public class BikeService extends BaseService<Bike> {
    private final MongoCollection<Bike> collection;

    public BikeService() {
        super("bikes", Bike.class);
        this.collection = super.getCollection();
    }
}
