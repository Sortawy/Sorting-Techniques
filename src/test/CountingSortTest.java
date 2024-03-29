import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;
import static org.junit.Assert.*;

public class CountingSortTest {

    @Test
    public void testOneCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(5, 2, 3, 1, 4, 5, 2, 3, 1, 4));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testNormalCountingSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(5, 2, 3, 1, 4, 5, 2, 3, 1, 4));
        List<List<Integer>> actualSteps = sortArray.countingSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        // sorted => 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
        expectedSteps.add(Arrays.asList(5, 2, 3, 1, 4, 5, 2, 3, 1, 4));
        expectedSteps.add(Arrays.asList(5, 2, 3, 1, 4, 5, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 2, 3, 2, 4, 5, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 2, 3, 2, 4, 3, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 1, 3, 2, 4, 3, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 1, 3, 2, 4, 3, 2, 4, 1, 5));
        expectedSteps.add(Arrays.asList(5, 1, 3, 2, 4, 3, 2, 4, 5, 5));
        expectedSteps.add(Arrays.asList(5, 1, 2, 2, 4, 3, 2, 4, 5, 5));
        expectedSteps.add(Arrays.asList(5, 1, 2, 2, 3, 3, 2, 4, 5, 5));
        expectedSteps.add(Arrays.asList(1, 1, 2, 2, 3, 3, 2, 4, 5, 5));
        expectedSteps.add(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5));
        // steps zero based array
        // expectedSteps.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 5));
        // expectedSteps.add(Arrays.asList(0, 0, 0, 2, 0, 0, 0, 0, 0, 5));
        // expectedSteps.add(Arrays.asList(0, 0, 0, 2, 0, 3, 0, 0, 0, 5));
        // expectedSteps.add(Arrays.asList(0, 1, 0, 2, 0, 3, 0, 0, 0, 5));
        // expectedSteps.add(Arrays.asList(0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
        // expectedSteps.add(Arrays.asList(0, 1, 0, 2, 0, 3, 0, 4, 5, 5));
        // expectedSteps.add(Arrays.asList(0, 1, 2, 2, 0, 3, 0, 4, 5, 5));
        // expectedSteps.add(Arrays.asList(0, 1, 2, 2, 3, 3, 0, 4, 5, 5));
        // expectedSteps.add(Arrays.asList(1, 1, 2, 2, 3, 3, 0, 4, 5, 5));
        // expectedSteps.add(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5));

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    public void testSimpleCountingSortWithoutSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(5, 2, 2, 3, 1, 4));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(1, 2, 2, 3, 4, 5);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testSimpleCountingSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(5, 2, 2, 3, 1, 4));
        List<List<Integer>> sortedLists = sortArray.countingSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(5, 2, 2, 3, 1, 4));
        expectedSteps.add(Arrays.asList(5, 2, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 2, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 2, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(5, 2, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(1, 2, 2, 3, 1, 5));
        expectedSteps.add(Arrays.asList(1, 2, 2, 3, 4, 5));
        assertEquals(expectedSteps, sortedLists);
    }

    @Test
    public void testCountingSortWithSmallArray() { // n = 2
        SortArray sortArray = new SortArray(Arrays.asList(5, 2));
        List<List<Integer>> sortedLists = sortArray.countingSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(5, 2));
        expectedSteps.add(Arrays.asList(5, 5));
        expectedSteps.add(Arrays.asList(2, 5));
        assertEquals(expectedSteps, sortedLists);
    }

    @Test
    public void testNegativeCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(-10, 0, 10, 1, -55, 105, 2, 3, 1, 4));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(-55, -10, 0, 1, 1, 2, 3, 4, 10, 105);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testAllSameCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testEmptyCountingSort() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        assertEquals(List.of(), sortedLists.get(0));
    }

    @Test
    public void testGreatNumbersCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(1000520, 115208, 889532, 214387, 1000520, 115208));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(115208, 115208, 214387, 889532, 1000520, 1000520);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testSmallNumbersCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(-5248120, -9674325, -7452136, -78431602, -7845545, -7452136));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(-78431602, -9674325, -7845545, -7452136, -7452136, -5248120);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testOneNumberCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(1));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        List<Integer> expectedSorted = Arrays.asList(1);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void testRangeExceedCountingSort() {
        SortArray sortArray = new SortArray(Arrays.asList(-2147483648, 2147483647, 0, 0, 0, 0, 0, 0, 0, 0));
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        assertNull(sortedLists);
    }

    @Test
    public void testCountingSortWithRandomLargeArray() {
        List<Integer> array = MeanTime.generateRandomArray(10000);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testCountingSortWithRandomSmallArray() {
        List<Integer> array = MeanTime.generateRandomArray(33);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testCountingSortWithRandomLargeArrayMixedPositiveAndNegative() {
        List<Integer> array = new ArrayList<>();
        for (int i = -1000; i <= 10000; i++) {
            array.add(i);
        }
        Collections.shuffle(array);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testCountingSortWithTimeCheckWithRandomLargeNumbers() {
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            array.add(i * 1000000);
        }
        Collections.shuffle(array);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        long startTime = System.currentTimeMillis();
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        long expectedElapsedTime = 1000;
        assertTrue(elapsedTime <= expectedElapsedTime);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testCountingSortWithTimeCheckWithRandomLargeSize() {
        List<Integer> array = MeanTime.generateRandomArray(1000000);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        long startTime = System.currentTimeMillis();
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        long expectedElapsedTime = 1000;
        assertTrue(elapsedTime <= expectedElapsedTime);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testWorstCaseWithTimeCheck() {
        List<Integer> array = Arrays.asList(-21474839, 21474839, 30, 10, 0, 0, 15, -1444, 123, 103, 0, 0);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        long startTime = System.currentTimeMillis();
        List<List<Integer>> sortedLists = sortArray.countingSort(false);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        long expectedElapsedTime = 1000;
        assertTrue(elapsedTime <= expectedElapsedTime);
        assertEquals(expected, sortedLists.get(0));
    }

}
