package main;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 🔹 Conversion
        QuantityLength length1 = new QuantityLength(1.0, LengthUnit.FEET);
        System.out.println("Convert 1 FEET to INCHES: " + length1.convertTo(LengthUnit.INCHES));

        // 🔹 Equality
        QuantityLength l1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12.0, LengthUnit.INCHES);
        System.out.println("1 FEET == 12 INCHES ? " + l1.equals(l2));

        // 🔹 Addition (same unit result)
        QuantityLength result1 = l1.add(l2, LengthUnit.FEET);
        System.out.println("1 FEET + 12 INCHES (in FEET): " + result1);

        // 🔹 Addition (different target unit)
        QuantityLength result2 = l1.add(l2, LengthUnit.YARDS);
        System.out.println("1 FEET + 12 INCHES (in YARDS): " + result2);

        // 🔹 Direct static conversion
        double converted = QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.FEET);
        System.out.println("1 YARD in FEET: " + converted);

        // 🔹 Extra check (cm)
        QuantityLength cm = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        System.out.println("2.54 CM in INCHES: " + cm.convertTo(LengthUnit.INCHES));
    }
}