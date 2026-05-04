package main;

public enum LengthUnit implements IMeasurable {

    METER(1.0),
    CENTIMETERS(0.01),
    KILOMETER(1000.0),
    FEET(0.3048),
    INCHES(0.0254),
    YARDS(0.9144);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBase(double value) {
        return value * conversionFactor;
    }

    @Override
    public double fromBase(double value) {
        return value / conversionFactor;
    }
}