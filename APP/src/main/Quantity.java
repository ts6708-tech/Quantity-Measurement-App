package main;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public double toBase() {
        return unit.toBase(value);
    }

    public boolean compare(Quantity<U> other) {
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    public Quantity<U> add(Quantity<U> other) {
        double sumBase = this.toBase() + other.toBase();
        double finalValue = unit.fromBase(sumBase);
        return new Quantity<>(finalValue, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sumBase = this.toBase() + other.toBase();
        double finalValue = targetUnit.fromBase(sumBase);
        return new Quantity<>(finalValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}