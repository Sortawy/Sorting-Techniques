package test;

import main.MeanTime;
import main.SortArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

public class MergeSortTest {

    @Test
    public void mergeAverageSteps() {
        SortArray sortArray = new SortArray((Arrays.asList(3, 5, 67, -1, 64, 52, 1)));
        List<List<Integer>> result = sortArray.mergeSort( true);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3, 5, 67, -1, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(3, 5, -1, -1, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(3, 5, -1, 67, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 5, -1, 67, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, -1, 67, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 52, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 52, 64, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 1, 64, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 1, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 1, 52, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 5, 67, 1, 52, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 3, 67, 1, 52, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 3, 5, 1, 52, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 3, 5, 52, 52, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 3, 5, 52, 64, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 3, 5, 52, 64, 67))
        ));
        assertEquals(expected, result);
    }

    @Test
    public void mergeWorstSteps() {
        SortArray sortArray = new SortArray((Arrays.asList(7, 6, 5, 4, 3, 2, 1)));
        List<List<Integer>> result = sortArray.mergeSort(true);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(6, 6, 5, 4, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(6, 7, 5, 4, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(6, 7, 4, 4, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(6, 7, 4, 5, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 7, 4, 5, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 4, 5, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 5, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 2, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 2, 3, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 1, 3, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 1, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 5, 6, 7, 1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 6, 7, 1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 7, 1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))

        ));
        assertEquals(expected, result);
    }

    @Test
    public void mergeBestCase() {
        SortArray sortArray = new SortArray((Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        List<List<Integer>> result = sortArray.mergeSort(false);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
        assertEquals(expected, result);
    }

    @Test
    public void mergeAverageCase() {

        SortArray sortArray =new SortArray(Arrays.asList(27, 3, 12, 25, 8, 21, 17, 1, 30, 24, 19, 14, 9, 4, 29, 23, 18,
                13, 7, 2, 26, 20, 15, 10, 5, 28, 22, 16, 11, 6));
        List<List<Integer>> result = sortArray.mergeSort(false);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                        22, 23, 24, 25, 26, 27, 28, 29, 30))));
        assertEquals(expected, result);
    }

    @Test
    public void mergeWorstCase() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 30; i > 0; i--) {
            arr.add(i);
        }
        SortArray sortArray = new SortArray(arr);
        List<List<Integer>> result = sortArray.mergeSort(false);

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            ans.add(i);
        }
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(ans));
        assertEquals(expected, result);
    }

    @Test
    public void mergeNegativeCase() {
        SortArray sortArray = new SortArray(Arrays.asList(-10, 0, 10, 1, -55, 105, 2, 3, 1, 4));
        List<List<Integer>> sortedLists = sortArray.mergeSort(false);
        List<Integer> expectedSorted = Arrays.asList(-55, -10, 0, 1, 1, 2, 3, 4, 10, 105);
        assertEquals(expectedSorted, sortedLists.get(0));
    }


    @Test
    public void mergeGreatNumbersCase() {
        SortArray sortArray = new SortArray(Arrays.asList(1000520,115208,889532,214387,1000520,115208));
        List<List<Integer>> sortedLists = sortArray.mergeSort(false);
        List<Integer> expectedSorted = Arrays.asList(115208, 115208, 214387, 889532, 1000520, 1000520);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void mergeSmallNumbersCase() {
        SortArray sortArray = new SortArray(Arrays.asList(-524812, -967432, -745213, -7843160, -784554, -745213));
        List<List<Integer>> sortedLists = sortArray.mergeSort(false);
        List<Integer> expectedSorted = Arrays.asList(-7843160, -967432, -784554, -745213, -745213, -524812);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void mergeOneNumberCase() {
        SortArray sortArray = new SortArray(Arrays.asList(77));
        List<List<Integer>> sortedLists = sortArray.mergeSort(false);
        List<Integer> expectedSorted = Arrays.asList(77);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void mergeEmptyCase() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.mergeSort(false);
        assertEquals(List.of(), sortedLists.get(0));
    }

    @Test
    public void testMergeSortWithRandomLargeArray() {
        List<Integer> array = MeanTime.generateRandomArray(10000);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.mergeSort(false);
        assertEquals(expected, sortedLists.get(0));
    }
}
