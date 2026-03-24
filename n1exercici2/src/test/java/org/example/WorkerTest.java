package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorkerTest {

    @Test
    void worker_calculates_base_salary() {
        Worker worker = new Worker("Maria", "Gomez", 10);

        assertThat(worker.calculateSalary(10)).isEqualTo(100);
    }
}
