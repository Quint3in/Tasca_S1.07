package org.example;

public class OnlineWorker extends Worker {

    public OnlineWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return 0.95 * super.calculateSalary(hours);
    }
}
