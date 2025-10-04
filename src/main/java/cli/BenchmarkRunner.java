package cli;

import algorithms.BoyerMoore;
import metrics.PerformanceTracker;

import java.util.Random;


public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = new int[] {100, 1000, 10000, 100000};
        System.out.println("n,time_ms,candidate,comparisons,arrayAccesses");
        for (int n : sizes) {
            int[] arr = generateRandomArray(n, 10); // small alphabet to create duplicates
            PerformanceTracker tracker = new PerformanceTracker();
            long t0 = System.currentTimeMillis();
            Integer cand = BoyerMoore.majorityElement(arr, tracker);
            long t1 = System.currentTimeMillis();
            System.out.printf("%d,%d,%s,%d,%d%n", n, (t1 - t0), cand == null ? "null" : cand.toString(),
                    tracker.getComparisons(), tracker.getArrayAccesses());
        }
    }

    private static int[] generateRandomArray(int n, int maxValue) {
        Random r = new Random(12345);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(maxValue);
        return a;
    }
}