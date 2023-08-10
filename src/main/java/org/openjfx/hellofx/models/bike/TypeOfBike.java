package org.openjfx.hellofx.models.bike;

public interface TypeOfBike{
    public int depositAmount();
    public int first30minAmount();
    public int after30minAmount();
    public int calculateTotal(int time);
}






