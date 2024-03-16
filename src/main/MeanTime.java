package main;

import java.util.*;
import java.io.*;
import main.SortArray;

public class MeanTime {
    /**
     * Generate a random array of a given size.
     * 
     * @param size The size of the array to generate.
     * @return A randomly generated array.
     */
    public static List<Integer> generateRandomArray(int size) {
        Random random = new Random();
        List<Integer> array = new ArrayList<>();
        int bound = 10 * size;
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(bound));
        }
        return array;
    }

    /**
     * Calculate the mean time taken to sort arrays of different sizes using the
     * specified sorting algorithm.
     * 
     * @param sortingAlgorithm The sorting algorithm to use ("bubble", "merge", or
     *                         "counting").
     * @param sizes            The sizes of arrays to test.
     * @param iterations       The number of iterations to run for each array size.
     * @return A list of mean times for each array size.
     */
    public static List<Double> calculateMeanSortingTime(String sortingAlgorithm, int[] sizes, int iterations) {
        Random random = new Random();
        System.out.println("Testing " + sortingAlgorithm + " sort...");
        List<Double> meanTimes = new ArrayList<>();
        for (int size : sizes) {
            System.out.println("Testing array size " + size + "...");
            long totalTime = 0;
            for (int i = 0; i < iterations; i++) {
                System.out.println("Iteration " + (i + 1) + "...");
                List<Integer> array = generateRandomArray(size);
                long startTime = System.nanoTime();
                switch (sortingAlgorithm) {
                    case "bubble":
                        new SortArray(array).bubbleSort(random.nextBoolean());
                        break;
                    case "merge":
                        new SortArray(array).mergeSort(array, random.nextBoolean());
                        break;
                    case "counting":
                        new SortArray(array).countingSort(random.nextBoolean());
                        break;
                    default:
                        return null;
                }
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            double meanTime = (double) totalTime / iterations / 1_000_000; // Convert nanoseconds to milliseconds
            meanTimes.add(meanTime);
        }
        return meanTimes;
    }

    public static void main(String[] args) {
        int[] sizes = { 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000 };
        int iterations = 30;
        System.out.println("Calculating mean sorting times for different array sizes...");
        List<Double> countingSortTimes = calculateMeanSortingTime("counting", sizes, iterations);
        List<Double> mergeSortTimes = calculateMeanSortingTime("merge", sizes,
                iterations);
        List<Double> bubbleSortTimes = calculateMeanSortingTime("bubble", sizes,
                iterations);
        System.out.println("Array Size\tBubble Sort\tMerge Sort\tCounting Sort");
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%d\t\t%.3f\t\t%.3f\t\t%.3f\n", sizes[i], bubbleSortTimes.get(i), mergeSortTimes.get(i),
                    countingSortTimes.get(i));
        }
    }
}
