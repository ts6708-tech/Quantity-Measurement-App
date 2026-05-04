package main;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Convert to base unit
    public double toBase() {
        return unit.toBase(value);
    }

    // ✅ FIXED: epsilon-based comparison
    public boolean compare(Quantity<U> other) {
        if (other == null) return false;

        double epsilon = 0.0001;
        return Math.abs(this.toBase() - other.toBase()) < epsilon;
    }

    // Add and return in same unit
    public Quantity<U> add(Quantity<U> other) {
        double sumBase = this.toBase() + other.toBase();
        double finalValue = unit.fromBase(sumBase);
        return new Quantity<>(finalValue, this.unit);
    }

    // Add and return in target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sumBase = this.toBase() + other.toBase();
        double finalValue = targetUnit.fromBase(sumBase);
        return new Quantity<>(finalValue, targetUnit);
    }

    // ✅ UC11 REQUIRED: conversion method
    public Quantity<U> convertTo(U targetUnit) {
        double base = this.toBase();
        double converted = targetUnit.fromBase(base);
        return new Quantity<>(converted, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}