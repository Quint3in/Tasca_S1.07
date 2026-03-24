package org.example;

public class OnlineWorker extends Worker {

    private final double FLAT_INTERNET_FEE = 30;

    public OnlineWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return (0.95 * super.calculateSalary(hours)) + FLAT_INTERNET_FEE;
    }

    /**
     *This method calculates the hours without INTERNET FEE.

     @deprecated This method is obsolete.
     Use {@link #calculateSalary(int hoursMonth)} instead to include the INTERNET bonus.
     @param hours number of hours the employer has worked
     @return the salary without extras
     */
    @Deprecated
    public double calculateOnlineWorkerSalary(int hours) {
        return 0.95 * super.calculateSalary(hours);
    }
}
