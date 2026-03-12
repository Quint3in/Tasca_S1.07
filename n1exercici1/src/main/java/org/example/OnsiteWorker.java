package org.example;

public class OnsiteWorker extends Worker {
    @Override
    public double calculateSalary(int hours) {
        return 1.05 * super.calculateSalary(hours);
    }
}
