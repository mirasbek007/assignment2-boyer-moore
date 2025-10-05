package cli;

import algorithms.BoyerMoore;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = new int[] {100, 1000, 10000, 100000};
        String outputFile = "performance/benchmark_results.csv";

        System.out.println("Running benchmarks...");
        System.out.println("n,time_ms,candidate,comparisons,arrayAccesses");

        try (FileWriter writer = new FileWriter(outputFile)) {
            // Write header to CSV
            writer.write("n,time_ms,candidate,comparisons,arrayAccesses\n");

            for (int n : sizes) {
                int[] arr = generateRandomArray(n, 10); // small alphabet to create duplicates
                PerformanceTracker tracker = new PerformanceTracker();

                long t0 = System.currentTimeMillis();
                Integer cand = BoyerMoore.majorityElement(arr, tracker);
                long t1 = System.currentTimeMillis();

                long time = t1 - t0;

                // Print to console
                System.out.printf("%d,%d,%s,%d,%d%n", n, time,
                        cand == null ? "null" : cand.toString(),
                        tracker.getComparisons(), tracker.getArrayAccesses());

                // Write to CSV
                writer.write(String.format("%d,%d,%s,%d,%d\n",
                        n, time, cand == null ? "null" : cand.toString(),
                        tracker.getComparisons(), tracker.getArrayAccesses()));
            }

            System.out.println("\nBenchmark completed. Results saved to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    private static int[] generateRandomArray(int n, int maxValue) {
        Random r = new Random(12345);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(maxValue);
        }
        return a;
    }
}
