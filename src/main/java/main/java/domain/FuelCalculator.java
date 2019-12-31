package main.java.domain;

public class FuelCalculator {
    public static int getFuel(int x){
        return (x/3) - 2;
    }

    public static int getFuelRecursive(int x){
        int sum = 0;
        int mass = x;
        int fuel;
        while ((fuel = FuelCalculator.getFuel(mass)) > 0){
            sum += fuel;
            mass = fuel;
        }
        return sum;
    }
}
