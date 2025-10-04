package metrics;


public class PerformanceTracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;

    public void recordComparison() { comparisons++; }
    public void recordArrayAccess() { arrayAccesses++; }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void reset() { comparisons = 0; arrayAccesses = 0; }

    @Override
    public String toString() {
        return "comparisons=" + comparisons + ", arrayAccesses=" + arrayAccesses;
    }
}