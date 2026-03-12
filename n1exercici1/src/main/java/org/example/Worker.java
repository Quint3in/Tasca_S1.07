package org.example;

public class Worker {
    private String name;
    private String surname;
    private double pricePerHour;

    public double calculateSalary(int hours) {
        return hours * pricePerHour;
    }
}
