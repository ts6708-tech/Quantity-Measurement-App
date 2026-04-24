package main;

public class QuantityMeasurementApp {

    // 🔹 ENUM for units
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

    // 🔹 Quantity Class
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        // 🔹 Equality (UC3+)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisVal = this.unit.toBase(this.value);
            double otherVal = other.unit.toBase(other.value);

            return Double.compare(thisVal, otherVal) == 0;
        }

        // 🔹 ADDITION (UC6)
        public static Quantity add(Quantity q1, Quantity q2) {

            if (q1 == null || q2 == null) {
                throw new IllegalArgumentException("Quantity cannot be null");
            }

            double base1 = q1.unit.toBase(q1.value);
            double base2 = q2.unit.toBase(q2.value);

            double sumBase = base1 + base2;

            // result in unit of first operand
            double resultValue = sumBase / q1.unit.toBase(1.0);

            return new Quantity(resultValue, q1.unit);
        }
    }

    // 🔹 CONVERSION (UC5)
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

    // 🔹 MAIN METHOD (optional demo)
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2);

        System.out.println("Result: " + result.getValue() + " " + result.getUnit());
    }
}