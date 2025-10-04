# Boyer–Moore Majority Vote Algorithm
 SE-2435
---
 Mirasbek Idiatulla 
---
 Partner Abylay Dossymbek
---


## Project Overview
This project implements the **Boyer–Moore Majority Vote Algorithm** in Java as part of Assignment 2 (Algorithmic Analysis and Peer Code Review). The algorithm detects whether a majority element exists in an array, defined as an element that appears more than ⌊n/2⌋ times.

The implementation is designed with:
- Clean, documented Java code
- Comprehensive unit tests covering edge cases
- Performance tracking of comparisons and array accesses
- CLI benchmark runner for empirical testing
- Maven project structure with reproducible Git workflow

---

## Repository Structure  
# Boyer–Moore Majority Vote Algorithm

## Project Overview
This project implements the **Boyer–Moore Majority Vote Algorithm** in Java as part of Assignment 2.  
The algorithm finds whether a majority element exists in an array (appearing more than ⌊n/2⌋ times).

---

## Repository Structure

```text
assignment2-boyer-moore/
├── src/
│   ├── main/java/
│   │   ├── algorithms/
│   │   │   └── BoyerMoore.java          # Algorithm implementation
│   │   ├── metrics/
│   │   │   └── PerformanceTracker.java  # Tracks comparisons & array accesses
│   │   └── cli/
│   │       └── BenchmarkRunner.java     # CLI benchmark runner
│   └── test/java/
│       └── algorithms/
│           └── BoyerMooreTest.java      # JUnit 5 unit tests
│
├── docs/
│   └── analysis-report.pdf              # Partner analysis report
│
├── performance/
│   └── benchmark_results.csv            # CSV benchmark results (empirical data)
│
├── pom.xml                              # Maven build file
└── README.md                            # Project documentation
```

---

## Implementation Features

- **Algorithm:**
    - Single-pass candidate selection + verification phase
    - O(n) time, O(1) space
    - Works even when no majority element exists

- **Code Quality:**
    - Clear structure with `algorithms`, `metrics`, `cli` packages
    - JavaDoc comments and consistent naming
    - Handles edge cases: empty arrays, null input, single elements, no-majority

- **Performance Tracking:**
    - `PerformanceTracker` records comparisons and array accesses
    - Can be extended for swaps, allocations, or recursive calls

- **CLI Benchmark:**
    - Runs algorithm on arrays of size 100, 1,000, 10,000, 100,000
    - Generates CSV output:
      ```
      n,time_ms,candidate,comparisons,arrayAccesses
      100,0,3,150,200
      1000,1,7,2000,3000
      ...
      ```  
    - Supports reproducible experiments

---

## Testing

Unit tests are implemented with **JUnit 5** in `BoyerMooreTest.java`.

### Covered cases:
- Empty array → returns `null`
- Single element → returns that element
- Array with clear majority → returns majority
- Array with no majority → returns `null`
- Array with all elements equal → returns that element

## Complexity Analysis

- **Time Complexity**
  - Best Case: O(1) (empty or single-element array)
  - Average Case: Θ(n) (two passes are required in most cases)
  - Worst Case: O(n) (no majority element, full scans performed)

- **Space Complexity**
  - O(1) auxiliary memory, since only a candidate variable, counters, and constants are maintained.

---

## Optimizations

1. **Early Termination**
  - The verification step can stop once the candidate’s count surpasses n/2, saving unnecessary comparisons.

2. **Refined Performance Tracking**
  - Distinguish between element comparisons and structural operations to produce more accurate metrics.

3. **Improved Benchmarking**
  - Redirect benchmark results directly to CSV files and integrate plotting scripts for automated visualization.

---

## Empirical Validation

- Benchmarks confirm that runtime grows linearly with input size.
- Comparisons and array accesses also scale proportionally to n.
- Constant factors remain small, since the algorithm uses very few operations per element.
- Memory usage is constant across all inputs, as predicted by the theoretical analysis.

---

## Git Workflow Example

- `init`: Maven project setup
- `feat(algorithm)`: Implement `BoyerMoore.java`
- `feat(metrics)`: Add `PerformanceTracker.java`
- `test(algorithm)`: Add JUnit test suite
- `feat(cli)`: Add `BenchmarkRunner` CLI for benchmarks
- `feat(optimization)`: Add early stopping optimization
- `docs(report)`: Add analysis report (PDF)
- `perf(benchmark)`: Add CSV results from benchmark runs  
## Conclusion

The Boyer–Moore Majority Vote algorithm was implemented in Java with careful attention to correctness,
efficiency, and clarity. The solution achieves linear time and constant space complexity, while also
handling edge cases such as empty arrays, single elements, and scenarios with no majority element.

Unit tests confirm correctness across diverse cases, and empirical benchmarks validate the theoretical
analysis by showing linear runtime growth with input size. The implementation integrates performance
tracking and provides a CLI benchmark runner, making it suitable for both analysis and experimentation.

Potential improvements include refining performance tracking for greater accuracy, adding early stopping
in the verification step, and extending the benchmarking process with automated CSV outputs and plots.

Overall, the project demonstrates strong programming practice, clear algorithmic understanding, and a
complete workflow from theory to empirical validation.  



