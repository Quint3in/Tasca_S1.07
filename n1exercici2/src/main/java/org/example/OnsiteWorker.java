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


    /**
     *This method calculates the hours without FUEL.

     @deprecated This method is obsolete.
     Use {@link #calculateSalary(int hoursMonth)} instead to include the fuel bonus.
     @param hours number of hours the employer has worked
     @return the salary without extras
     */
    @Deprecated
    public double calculateOnSiteWorkerSalary(int hours) {
        return 1.05 * super.calculateSalary(hours);
    }
}
