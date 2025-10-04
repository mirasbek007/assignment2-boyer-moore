package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreTest {

    @Test
    public void testEmpty() {
        int[] a = new int[] {};
        assertNull(BoyerMoore.majorityElement(a, new PerformanceTracker()));
    }

    @Test
    public void testSingle() {
        int[] a = new int[] {42};
        assertEquals(Integer.valueOf(42), BoyerMoore.majorityElement(a, new PerformanceTracker()));
    }

    @Test
    public void testClearMajority() {
        int[] a = new int[] {1,1,2,1,3,1,1};
        assertEquals(Integer.valueOf(1), BoyerMoore.majorityElement(a, new PerformanceTracker()));
    }

    @Test
    public void testNoMajority() {
        int[] a = new int[] {1,2,3,2,1,3};
        assertNull(BoyerMoore.majorityElement(a, new PerformanceTracker()));
    }

    @Test
    public void testAllSame() {
        int[] a = new int[] {5,5,5,5};
        assertEquals(Integer.valueOf(5), BoyerMoore.majorityElement(a, new PerformanceTracker()));
    }
}