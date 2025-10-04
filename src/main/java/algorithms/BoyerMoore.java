package algorithms;

import metrics.PerformanceTracker;


public class BoyerMoore {


    public static Integer findCandidate(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) return null;
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < arr.length; i++) {
            if (tracker != null) tracker.recordArrayAccess();
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (candidate == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (tracker != null) tracker.recordComparison(); // rough proxy for comparisons
        }
        return candidate;
    }


    public static boolean isMajority(int[] arr, Integer candidate, PerformanceTracker tracker) {
        if (candidate == null) return false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tracker != null) tracker.recordArrayAccess();
            if (arr[i] == candidate) count++;
            if (tracker != null) tracker.recordComparison();
        }
        return count > arr.length / 2;
    }


    public static Integer majorityElement(int[] arr, PerformanceTracker tracker) {
        Integer cand = findCandidate(arr, tracker);
        if (cand == null) return null;
        boolean ok = isMajority(arr, cand, tracker);
        return ok ? cand : null;
    }
}