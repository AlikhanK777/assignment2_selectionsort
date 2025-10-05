package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void testEmptyArray() {
        SelectionSort sorter = new SelectionSort();
        int[] array = {};
        sorter.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testSingleElement() {
        SelectionSort sorter = new SelectionSort();
        int[] array = {5};
        sorter.sort(array);
        assertArrayEquals(new int[]{5}, array);
    }

    @Test
    void testAlreadySorted() {
        SelectionSort sorter = new SelectionSort();
        int[] array = {1, 2, 3, 4, 5};
        sorter.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        assertTrue(sorter.isEarlyTerminated());
    }

    @Test
    void testReverseSorted() {
        SelectionSort sorter = new SelectionSort();
        int[] array = {5, 4, 3, 2, 1};
        sorter.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        assertFalse(sorter.isEarlyTerminated());
    }

    @Test
    void testSort() {
        SelectionSort sorter = new SelectionSort();
        int[] array = {5, 2, 6, 1, 3};
        sorter.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6}, array);
    }
}