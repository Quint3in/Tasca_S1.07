package org.example;

public class OnsiteWorker extends Worker {


    public OnsiteWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return 1.05 * super.calculateSalary(hours);
    }
}
