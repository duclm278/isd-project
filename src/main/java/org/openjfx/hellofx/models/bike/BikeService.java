package org.openjfx.hellofx.models.bike;

import org.openjfx.hellofx.models.common.BaseService;

public class BikeService extends BaseService<Bike> {
    public BikeService() {
        super("bikes", Bike.class);
    }
}
