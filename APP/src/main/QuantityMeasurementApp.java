package main;

public class QuantityMeasurementApp {

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

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisVal = this.unit.toBase(this.value);
            double otherVal = other.unit.toBase(other.value);

            return Double.compare(thisVal, otherVal) == 0;
        }
    }

    // 🔥 NEW METHOD (UC5 CORE)
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        // Validation
        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        // Convert to base (feet)
        double base = source.toBase(value);

        // Convert base → target
        return base / target.toBase(1.0);
    }
}