import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {

    @Test
    void testOneBubbleSort() {
        SortArray sortArray = new SortArray(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        List<List<Integer>> sortedLists = sortArray.simpleSort(false);
        List<Integer> expectedSorted = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 9);
        assertEquals(expectedSorted, sortedLists.get(0));
    }
    @Test
    void testOneBubbleSortWithSteps() {
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
    void EmptyTestCaseBubbleSort() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.simpleSort(false);
        assertEquals(List.of(), sortedLists.get(0));
    }
    @Test
    void EmptyTestCaseBubbleSortWithSteps() {
        SortArray sortArray = new SortArray(List.of());
        List<List<Integer>> sortedLists = sortArray.simpleSort(false);
        assertEquals(List.of(List.of()), sortedLists);
    }
}