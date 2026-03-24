package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineWorkerTest {

    @Test
    void calculate_salary_includes_internet_fee_and_discount() {
        OnlineWorker worker = new OnlineWorker("Marcos", "Gutierrez", 10);

        double salary = worker.calculateSalary(10);

        assertThat(salary).isCloseTo(125.0, org.assertj.core.data.Offset.offset(0.0001));
    }

    @Test
    void deprecated_calculate_online_worker_salary_excludes_internet_fee() {
        OnlineWorker worker = new OnlineWorker("Marcos", "Gutierrez", 10);

        @SuppressWarnings("deprecation")
        double salary = worker.calculateOnlineWorkerSalary(10);

        assertThat(salary).isCloseTo(95.0, org.assertj.core.data.Offset.offset(0.0001));
    }
}
