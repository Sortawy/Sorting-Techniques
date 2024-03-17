package test;

import main.MeanTime;
import main.SortArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
}
