package test;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import main.MeanTime;
import main.SortArray;
import org.junit.Test;

public class BubbleSortTest {
/**
     * TODO: Bubble Sort Unit Tests
    done * pure random (small size) (check only sort) (Using Random)
    done * random with medium size (check only sort)    (Using Random)
     * random with big size (check only sort) (check time too) (Using Random)
     * all same number(big/small)(with/without)steps, (large/small n)
    done * n=1 
    done * n=2
    done * add more simple (with and without steps) ( 2 more )
    done * array with all negative
    done * array with mixed negative and positive
    done * array with very large numbers
    done * array with very negative numbers
     * ---------------------------------
     * TODO: Merge Sort Unit Tests
     * large n's random && time check (without steps) (using Random)
     * random small n (using Random)
     * time check in worst cases
     * all same number (big/small)
     * add more simple with/without steps (like 2 more)
     * n=2
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
        SortArray sortArray = new SortArray(Arrays.asList(-5555555, -9999999, -4444444, -7777777, -6666666, -8888888));
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        List<Integer> expectedSorted = Arrays.asList(-9999999, -8888888, -7777777, -6666666, -5555555, -4444444);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    
    @Test
    public void simpleNumbersTestCaseBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(5, 2, 3, 1, 4));
        List<List<Integer>> actualSteps = sortArray.bubbleSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(5, 2, 3, 1, 4));
        expectedSteps.add(Arrays.asList(2, 5, 3, 1, 4));
        expectedSteps.add(Arrays.asList(2, 3, 5, 1, 4));
        expectedSteps.add(Arrays.asList(2, 3, 1, 5, 4));
        expectedSteps.add(Arrays.asList(2, 3, 1, 4, 5));
        expectedSteps.add(Arrays.asList(2, 1, 3, 4, 5));
        expectedSteps.add(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expectedSteps, actualSteps);
    }
    @Test
    public void allSameNumbersTestCaseBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(1, 1, 1, 1, 1));
        List<List<Integer>> actualSteps = sortArray.bubbleSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(1, 1, 1, 1, 1));
        assertEquals(expectedSteps, actualSteps);
    }
  
    @Test
    public void simpleNumbersTest2CaseBubbleSortWithSteps(){
        SortArray sortArray = new SortArray(Arrays.asList(4, 5, 6, 7, 1, 2, 3));
        List<List<Integer>> actualSteps = sortArray.bubbleSort(true);
        List<List<Integer>> expectedSteps = new ArrayList<>();
        expectedSteps.add(Arrays.asList(4, 5, 6, 7, 1, 2, 3));
        expectedSteps.add(Arrays.asList(4, 5, 6, 1, 7, 2, 3));
        expectedSteps.add(Arrays.asList(4, 5, 6, 1, 2, 7, 3));
        expectedSteps.add(Arrays.asList(4, 5, 6, 1, 2, 3, 7));
        expectedSteps.add(Arrays.asList(4, 5, 1, 6, 2, 3, 7));
        expectedSteps.add(Arrays.asList(4, 5, 1, 2, 6, 3, 7));
        expectedSteps.add(Arrays.asList(4, 5, 1, 2, 3, 6, 7));
        expectedSteps.add(Arrays.asList(4, 1, 5, 2, 3, 6, 7));
        expectedSteps.add(Arrays.asList(4, 1, 2, 5, 3, 6, 7));
        expectedSteps.add(Arrays.asList(4, 1, 2, 3, 5, 6, 7));
        expectedSteps.add(Arrays.asList(1, 4, 2, 3, 5, 6, 7));
        expectedSteps.add(Arrays.asList(1, 2, 4, 3, 5, 6, 7));
        expectedSteps.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(expectedSteps, actualSteps);
    }
    @Test 
    public void randomWithBigSizeBubbleSort() {
        List<Integer> array = MeanTime.generateRandomArray(30000);
        SortArray sortArray = new SortArray(array);

        long startTime = System.currentTimeMillis();
        
        List<List<Integer>> sortedLists = sortArray.bubbleSort(false);
        
        long stopTime = System.currentTimeMillis();
        long elapsed_time=stopTime-startTime;
        long expected_time = 4000 ; // in ms
        // System.out.println("Elapsed time: " + elapsed_time + " ms");
        List<Integer> expectedSorted = new ArrayList<>(array);
        sort(expectedSorted);
        assertTrue(elapsed_time <= expected_time );
        assertEquals(expectedSorted, sortedLists.get(0));           
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