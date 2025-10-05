package algorithms;

// Selection Sort with early termination optimization
public class SelectionSort {
    private long comparisons;
    private long swaps;
    private boolean earlyTerminated;

    public void sort(int[] array) {
        resetMetrics();
        int n = array.length;
        if (n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean foundSmaller = false;

            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    foundSmaller = true;
                }
            }

            if (minIndex != i) {
                swap(array, i, minIndex);
                swaps++;
            }

            if (!foundSmaller && i == 0) {
                earlyTerminated = true;
                break;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void resetMetrics() {
        comparisons = 0;
        swaps = 0;
        earlyTerminated = false;
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public boolean isEarlyTerminated() { return earlyTerminated; }
}