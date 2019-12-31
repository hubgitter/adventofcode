package test.java.domain;

import main.java.domain.FuelCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuelCalculatorTest {
    private FuelCalculator fuelCalculator = new FuelCalculator();

    @Test
    public void testFuelCalculationsMatchSpecification(){
        assertEquals(fuelCalculator.getFuel(12), 2);
        assertEquals(fuelCalculator.getFuel(14), 2);
        assertEquals(fuelCalculator.getFuel(100756), 33583);
    }

    @Test
    public void testGetFuelRecursiveMatchesSpecification(){
        assertEquals(fuelCalculator.getFuelRecursive(14), 2);
        assertEquals(fuelCalculator.getFuelRecursive(1969), 966);
        assertEquals(fuelCalculator.getFuelRecursive(100756), 50346);

    }

}
