package org.openjfx.hellofx.model.policy;

public interface TypeOfBike extends Policy {
    public int depositAmount();

    public int first30minAmount();

    public int after30minAmount();
}
