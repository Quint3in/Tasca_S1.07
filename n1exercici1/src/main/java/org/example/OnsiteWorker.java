package org.example;

public class OnsiteWorker extends Worker {

    private static final double FUEL = 50;

    public OnsiteWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hoursMonth) {
        return (1.05 * super.calculateSalary(hoursMonth)) + FUEL;
    }
}
