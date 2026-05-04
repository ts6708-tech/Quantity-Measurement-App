package main;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    private void validate(Quantity<U> other) {
        if (other == null) throw new IllegalArgumentException("Null quantity");
        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement types");
    }

    // ✅ EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass())) return false;

        double base1 = this.toBase();
        double base2 = ((Quantity<?>) obj).unit.convertToBaseUnit(((Quantity<?>) obj).value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round(toBase()));
    }

    // ✅ CONVERSION
    public Quantity<U> convertTo(U targetUnit) {
        double base = toBase();
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }

    // ✅ ADD
    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validate(other);

        double result = this.toBase() + other.toBase();
        double converted = targetUnit.convertFromBaseUnit(result);

        return new Quantity<>(round(converted), targetUnit);
    }

    // ✅ SUBTRACT (UC12)
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validate(other);

        double result = this.toBase() - other.toBase();
        double converted = targetUnit.convertFromBaseUnit(result);

        return new Quantity<>(round(converted), targetUnit);
    }

    // ✅ DIVIDE (UC12)
    public double divide(Quantity<U> other) {
        validate(other);

        double divisor = other.toBase();
        if (Math.abs(divisor) < EPSILON)
            throw new ArithmeticException("Division by zero");

        return this.toBase() / divisor;
    }
}