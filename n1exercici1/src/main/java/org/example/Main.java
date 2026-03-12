package org.example;

public class Main {
    static void main() {
        Worker worker1 = new Worker("Maria", "Gomez", 10);
        OnlineWorker worker2 = new OnlineWorker("Marcos", "Gutierrez", 10);
        OnsiteWorker worker3 = new OnsiteWorker("Alejandro", "Cortés", 10);

        System.out.println(worker1.calculateSalary(10));
        System.out.println(worker2.calculateSalary(10));
        System.out.println(worker3.calculateSalary(10));
    }
}
