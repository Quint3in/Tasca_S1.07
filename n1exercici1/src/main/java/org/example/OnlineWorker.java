package org.example;

public class OnlineWorker extends Worker {
    @Override
    public double calculateSalary(int hours) {
        return 0.95 * super.calculateSalary(hours);
    }
}
