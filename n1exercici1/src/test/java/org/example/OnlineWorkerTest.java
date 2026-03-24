package org.example;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineWorkerTest {

    @Test
    void calculate_salary_includes_internet_fee_and_discount() {
        OnlineWorker worker = new OnlineWorker("Marcos", "Gutierrez", 10);

        double salary = worker.calculateSalary(10);

        assertThat(salary).isCloseTo(125.0, org.assertj.core.data.Offset.offset(0.0001));
    }
}
