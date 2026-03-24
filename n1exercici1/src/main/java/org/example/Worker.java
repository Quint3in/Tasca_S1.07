package org.example;

public class Worker {
    private final String name;
    private final String surname;
    private final double pricePerHour;

    public Worker(String name, String surname, double pricePerHour) {
        this.name = name;
        this.surname = surname;
        this.pricePerHour = pricePerHour;
    }

    public double calculateSalary(int hours) {
        return hours * pricePerHour;
    }
}
