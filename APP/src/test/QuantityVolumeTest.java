package test;

import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityVolumeTest {

    @Test
    void shouldCompareLitreAndMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertTrue(v1.compare(v2));
    }

    @Test
    void shouldCompareLitreAndGallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertTrue(v1.compare(v2));
    }

    @Test
    void shouldConvertLitreToMillilitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = v.add(new Quantity<>(0, VolumeUnit.LITRE), VolumeUnit.MILLILITRE);

        assertEquals(1000, result.getValue(), 0.01);
    }

    @Test
    void shouldAddVolumes() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = v1.add(v2);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    void shouldAddVolumesInGallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.GALLON);

        assertEquals(1.264, result.getValue(), 0.01);
    }
}