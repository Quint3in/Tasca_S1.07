package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnsiteWorkerTest {

    @Test
    void calculate_salary_includes_fuel_and_bonus() {
        OnsiteWorker worker = new OnsiteWorker("Alejandro", "Cortes", 10);

        double salary = worker.calculateSalary(10);

        assertThat(salary).isCloseTo(155.0, org.assertj.core.data.Offset.offset(0.0001));
    }
}
