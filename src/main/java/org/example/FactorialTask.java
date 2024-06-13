package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private final long n;

    public FactorialTask(long n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return n;
        } else {
            FactorialTask leftTask = new FactorialTask(n - 1);
            leftTask.fork();
            long rightResult = n;
            long leftResult = leftTask.join();
            return leftResult * rightResult;
        }
    }
}
