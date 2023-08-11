package org.openjfx.hellofx.models.bike7;

public interface TypeOfBike {
    public int depositAmount();

    public int first30minAmount();

    public int after30minAmount();

    public int calculateTotal(int time);
}
