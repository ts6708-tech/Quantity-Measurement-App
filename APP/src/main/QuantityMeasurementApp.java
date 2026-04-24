package main;

public class QuantityMeasurementApp {

    // 🔹 ENUM
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.393701 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }
    }

    // 🔹 QUANTITY CLASS
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        // 🔹 EQUALS
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double v1 = this.unit.toBase(this.value);
            double v2 = other.unit.toBase(other.value);

            return Double.compare(v1, v2) == 0;
        }

        // 🔹 UC6 ADD
        public static Quantity add(Quantity q1, Quantity q2) {
            if (q1 == null || q2 == null) {
                throw new IllegalArgumentException("Null quantity");
            }

            double base = q1.unit.toBase(q1.value) + q2.unit.toBase(q2.value);
            double result = base / q1.unit.toBase(1.0);

            return new Quantity(result, q1.unit);
        }

        // 🔥 UC7 ADD WITH TARGET
        public static Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit) {
            if (q1 == null || q2 == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double base = q1.unit.toBase(q1.value) + q2.unit.toBase(q2.value);
            double result = base / targetUnit.toBase(1.0);

            return new Quantity(result, targetUnit);
        }
    }

    // 🔹 UC5 CONVERT
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        double base = source.toBase(value);
        return base / target.toBase(1.0);
    }

    // 🔥 MAIN METHOD (IMPORTANT FOR INTELLIJ)
    public static void main(String[] args) {

        System.out.println("=== Quantity Measurement App Demo ===");

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        // UC6
        Quantity result1 = Quantity.add(q1, q2);
        System.out.println("UC6 Result (Feet): " + result1.getValue() + " " + result1.getUnit());

        // UC7
        Quantity result2 = Quantity.add(q1, q2, LengthUnit.YARD);
        System.out.println("UC7 Result (Yard): " + result2.getValue() + " " + result2.getUnit());

        // UC5
        double converted = convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        System.out.println("Convert 1 ft to inch: " + converted);
    }
}