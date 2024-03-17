package test;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import main.MeanTime;
import org.junit.Test;

import main.SortArray;

public class SortArrayTest {
/**
     * TODO: Bubble Sort Unit Tests
     * pure random (small size) (check only sort) (Using Random)
     * random with medium size (check only sort)    (Using Random)
     * random with big size (check only sort) (check time too) (Using Random)
     * all same number(big/small)(with/without)steps, (large/small n)
    done * n=1 
    done * n=2
     * add more simple (with and without steps) ( 2 more )
    done * array with all negative
    done * array with mixed negative and positive
    done * array with very large numbers
     * array with very negative numbers
     * ---------------------------------
     * TODO: Merge Sort Unit Tests
     * large n's random && time check (without steps) (using Random)
     * random small n (using Random)
     * time check in worst cases
     * all same number (big/small)
     * add more simple with/without steps (like 2 more)
     * n=2
     * ---------------------------------
     * TODO: Counting Sort Unit Tests
     * add 2 more simple with/without steps
     * n=2
     * random small n (using Random)
     * random  (using Random) large ns && time check (without steps)
     * random using Random large numbers && time check (without steps)
     * time check in worst cases
     * mixed negative with positive
     */

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
        for (int i = -5000; i <= 5000; i++) {
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void bestCaseTestTwoBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i = -100000; i <= 100000; i++) {
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void bestCaseTestOneBubbleSortWithSteps() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i = -5000; i <= 5000; i++) {
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<List<Integer>> expectedReturn = new ArrayList<>();
        expectedReturn.add(expectedSorted);
        assertEquals(expectedReturn, sortedLists);
    }

    @Test
    public void bestCaseTestTwoBubbleSortWithSteps() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i = -100000; i <= 100000; i++) {
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<List<Integer>> expectedReturn = new ArrayList<>();
        expectedReturn.add(expectedSorted);
        assertEquals(expectedReturn, sortedLists);
    }

    @Test
    public void worstCaseTestOneBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i = 5000; i >= -5000; i--) {
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        long startTime = System.currentTimeMillis();
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        long stopTime = System.currentTimeMillis();
        long elapsed_time=stopTime-startTime;
        long expected_time = 1000 ; // in ms
        assertTrue(elapsed_time <= expected_time );
        reverse(expectedSorted);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void worstCaseTestTwoBubbleSort() {
        List<Integer> expectedSorted = new ArrayList<>();
        for (int i = 10000; i >= -10000; i--) {
            expectedSorted.add(i);
        }
        SortArray sortArray = new SortArray(expectedSorted);
        long startTime = System.currentTimeMillis();
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        long stopTime = System.currentTimeMillis();
        long elapsed_time=stopTime-startTime;
        long expected_time = 3500 ; // in ms
        assertTrue(elapsed_time <= expected_time );
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


    /////////////////////////////basmeta///////////////////////////
    @Test
    public void oneNumberTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(1));
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(Arrays.asList(1), sortedLists.get(0));
    }

    @Test
    public void twoNumbersTestCaseBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(2, 1));
        List<List<Integer>> actualSteps = sortArray.bubbleSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(2, 1));
        expectedSteps.add(Arrays.asList(1, 2));
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    public void negativeNumbersTestCaseBubbleSort() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = -1; i >= -5000; i--) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); 
        SortArray sortArray = new SortArray(numbers);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<Integer> expectedSorted = new ArrayList<>(numbers);
        Collections.sort(expectedSorted);

        assertEquals(expectedSorted, sortedLists.get(0));
    }

    @Test
    public void mixedNumbersTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(-1, 5, -6, 12, -100, -1, 15, -20, 25, -30, 35, -40, 45, -50, 55, -60, 65, -70, 75, -80, 85));
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<Integer> expectedSorted = Arrays.asList(-100, -80, -70, -60, -50, -40, -30, -20, -6, -1, -1, 5, 12, 15, 25, 35, 45, 55, 65, 75, 85);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    
    @Test
    public void greatNumbersTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(2000520, 215208, 1889532, 314387, 2000520, 215208, 3000000, 4000000, 5000000, 6000000, 7000000));
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<Integer> expectedSorted = Arrays.asList(215208, 215208, 314387, 1889532, 2000520, 2000520, 3000000, 4000000, 5000000, 6000000, 7000000);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    
    @Test
    public void smallNumbersTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(-524812, -967432, -745213, -7843160, -784554, -745213));
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<Integer> expectedSorted = Arrays.asList(-7843160, -967432, -784554, -745213, -745213, -524812);
        assertEquals(expectedSorted, sortedLists.get(0));
    }

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
    public void testBubbleSortPositiveNegativeArrayWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(-1, 5, -6, 12, -100, -1));
        List<List<Integer>> actualSteps = sortArray.bubbleSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();

        expectedSteps.add(Arrays.asList(-1, 5, -6, 12, -100, -1));
        expectedSteps.add(Arrays.asList(-1, -6, 5, 12, -100, -1));
        expectedSteps.add(Arrays.asList(-1, -6, 5, -100, 12, -1));
        expectedSteps.add(Arrays.asList(-1, -6, 5, -100, -1, 12));
        expectedSteps.add(Arrays.asList(-6, -1, 5, -100, -1, 12));
        expectedSteps.add(Arrays.asList(-6, -1, -100, 5, -1, 12));
        expectedSteps.add(Arrays.asList(-6, -1, -100, -1, 5, 12));
        expectedSteps.add(Arrays.asList(-6, -100, -1, -1, 5, 12));
        expectedSteps.add(Arrays.asList(-100, -6, -1, -1, 5, 12));
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    public void testBubbleSortWithRandomLargeArray() {
        List<Integer> array = MeanTime.generateRandomArray(10000);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expected, sortedLists.get(0));
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
    public void testBubbleSortWithRandomSmallTwoElementArray() {
        List<Integer> array = MeanTime.generateRandomArray(2);
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testBubbleSortWithRandomPositiveNegativeArrayBestCase() {
        List<Integer> array = new ArrayList<>();
        for(int i = 10000; i >= -1000; i--) {
            array.add(i);
        }
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expected, sortedLists.get(0));
    }

    @Test
    public void testBubbleSortWithRandomPositiveNegativeArrayWorstCase() {
        List<Integer> array = new ArrayList<>();
        for(int i = -1000; i <= 10000; i++) {
            array.add(i);
        }
        List<Integer> expected = new ArrayList<>(array);
        sort(expected);
        SortArray sortArray = new SortArray(array);
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        assertEquals(expected, sortedLists.get(0));
    }

}