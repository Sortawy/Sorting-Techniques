import static java.util.Collections.reverse;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.SortArray;

public class SortArrayTest {

    @Test
    public void simpleTestOneBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<Integer> expectedSorted = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 9);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void simpleTestOneBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<List<Integer>> actualSteps = sortArray.bubbleSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        expectedSteps.add(Arrays.asList(1, 3, 4, 1, 5, 9, 2, 6));
        expectedSteps.add(Arrays.asList(1, 3, 1, 4, 5, 9, 2, 6));
        expectedSteps.add(Arrays.asList(1, 3, 1, 4, 5, 2, 9, 6));
        expectedSteps.add(Arrays.asList(1, 3, 1, 4, 5, 2, 6, 9));

        expectedSteps.add(Arrays.asList(1, 1, 3, 4, 5, 2, 6, 9));
        expectedSteps.add(Arrays.asList(1, 1, 3, 4, 2, 5, 6, 9));

        expectedSteps.add(Arrays.asList(1, 1, 3, 2, 4, 5, 6, 9));

        expectedSteps.add(Arrays.asList(1, 1, 2, 3, 4, 5, 6, 9));
        assertEquals(expectedSteps, actualSteps);
    }
    @Test
    public void bestCaseTestOneBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i=-5000;i <=5000;i++){
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    @Test
    public void bestCaseTestTwoBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i=-100000;i <=100000;i++){
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    @Test
    public void bestCaseTestOneBubbleSortWithSteps() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i=-5000;i <=5000;i++){
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<List<Integer>> expectedReturn=new ArrayList<>();
        expectedReturn.add(expectedSorted);
        assertEquals(expectedReturn, sortedLists);
    }
    @Test
    public void bestCaseTestTwoBubbleSortWithSteps() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i=-100000;i <=100000;i++){
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<List<Integer>> expectedReturn=new ArrayList<>();
        expectedReturn.add(expectedSorted);
        assertEquals(expectedReturn, sortedLists);
    }
    @Test
    public void worstCaseTestOneBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i=5000;i >=-5000;i--){
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        reverse(expectedSorted);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    @Test
    public void worstCaseTestTwoBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i=10000;i >=-10000;i--){
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        reverse(expectedSorted);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void EmptyTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(List.of(), sortedLists.get(0));
    }

    @Test
    public void EmptyTestCaseBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(List.of(List.of()), sortedLists);
    }

    @Test
    public void MergeAverageSteps() {
        SortArray sortArray = new SortArray(List.of());
        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 67, -1, 64, 52, 1));
        List<List<Integer>> result = sortArray.mergeSort(arr, true);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3, 5, 67, -1, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(3, 5, -1, 67, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 64, 52, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 52, 64, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 1, 52, 64)),
                new ArrayList<>(Arrays.asList(-1, 1, 3, 5, 52, 64, 67))));
        assertEquals(expected, result);
    }

    @Test
    public void MergeWorstSteps() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 2, 1));
        List<List<Integer>> result = m.mergeSort(arr, true);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(6, 7, 5, 4, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(6, 7, 4, 5, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 2, 3, 1)),
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))

        ));
        assertEquals(expected, result);
    }

    @Test
    public void MergeBestCase() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<List<Integer>> result = m.mergeSort(arr, false);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
        assertEquals(expected, result);
    }

    @Test
    public void MergeAverageCase() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>(Arrays.asList(27, 3, 12, 25, 8, 21, 17, 1, 30, 24, 19, 14, 9, 4, 29, 23, 18,
                13, 7, 2, 26, 20, 15, 10, 5, 28, 22, 16, 11, 6));
        List<List<Integer>> result = m.mergeSort(arr, false);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                        22, 23, 24, 25, 26, 27, 28, 29, 30))));
        assertEquals(expected, result);
    }

    @Test
    public void MergeWorstCase() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>();
        for (int i = 30; i > 0; i--) {
            arr.add(i);
        }
        List<List<Integer>> result = m.mergeSort(arr, false);

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            ans.add(i);
        }
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(ans));
        assertEquals(expected, result);
    }

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
}