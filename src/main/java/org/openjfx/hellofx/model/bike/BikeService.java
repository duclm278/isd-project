package org.openjfx.hellofx.model.bike;

import static com.mongodb.client.model.Filters.eq;

import org.openjfx.hellofx.model.common.BaseService;

public class BikeService extends BaseService<Bike> {
    public BikeService() {
        super("bikes", Bike.class);
    }

    public Bike findByBarcode(String barcode) {
        return getCollection().find(eq("barcode", barcode)).first();
    }
}
