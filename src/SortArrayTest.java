import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortArrayTest {

    @Test
    public void testOneBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<List<Integer>> sortedLists = sortArray.simpleSort(false);
        List<Integer> expectedSorted = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 9);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    @Test
    public void testOneBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<List<Integer>> actualSteps = sortArray.simpleSort(true);
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
    public void EmptyTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.simpleSort(false);
        assertEquals(List.of(), sortedLists.get(0));
    }
    @Test
    public void EmptyTestCaseBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.simpleSort(false);
        assertEquals(List.of(List.of()), sortedLists);
    }
    @Test
    public void MergeAverageSteps() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,5,67,-1,64,52,1));
        List<List<Integer>> result = m.mergeSort(arr,true);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(3, 5, 67, -1, 64, 52, 1)),
            new ArrayList<>(Arrays.asList(3, 5, -1, 67, 64, 52, 1)),
            new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 64, 52, 1)),
            new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 52, 64, 1)),
            new ArrayList<>(Arrays.asList(-1, 3, 5, 67, 1, 52, 64)),
            new ArrayList<>(Arrays.asList(-1, 1, 3, 5, 52, 64, 67))
        ));
        assertEquals(expected, result);
    }
    
    @Test
    public void MergeWorstSteps() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>(Arrays.asList(7,6,5,4,3,2,1));
        List<List<Integer>> result = m.mergeSort(arr,true);

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
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        ));
        assertEquals(expected, result);
    }
    
    @Test
    public void MergeAverageCase() {
        SortArray m = new SortArray();
        List<Integer> arr = new ArrayList<>(Arrays.asList(27, 3, 12, 25, 8, 21, 17, 1, 30, 24, 19, 14, 9, 4, 29, 23, 18, 13, 7, 2, 26, 20, 15, 10, 5, 28, 22, 16, 11, 6));
        List<List<Integer>> result = m.mergeSort(arr, false);

        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30))
        ));
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
}