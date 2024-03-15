package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

class RangeExceededException extends Exception {
    public RangeExceededException() {
        super("Range of numbers exceeds the limits of the algorithm");
    }
}

public class SortArray {

    private List<Integer> numbers;
    private int numsCount; // Length of array (for readability)

    // Default constructor
    SortArray() {
    }

    SortArray(List<Integer> nums) {
        this.numbers = nums;
        this.numsCount = this.numbers.size();
    }

    public SortArray(File list_file) {
        this.numbers = new ArrayList<>();
        readFromFile(list_file);
        this.numsCount = this.numbers.size();
    }

    /**
     * Method implements Bubble Sort Algorithm to sort the array in time complexity
     * O(n^2)
     * 
     * @param withSteps: True if the user wants the intermediate arrays, False if
     *                   only the result is needed
     * @return : List of the final array or List of Intermediate arrays
     */
    public List<List<Integer>> simpleSort(boolean withSteps) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>(this.numbers);
        if (withSteps) {
            steps.add(new ArrayList<>(sorted));
        }
        // Algorithm
        boolean swapped;
        for (int i = 0; i < numsCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < numsCount - 1 - i; j++) {
                if (sorted.get(j) > sorted.get(j + 1)) {
                    Collections.swap(sorted, j, j + 1);
                    swapped = true;
                    if (withSteps)
                        steps.add(new ArrayList<>(sorted));
                }
            }
            if (!swapped)
                break;
        }
        if (!withSteps) {
            steps.add(new ArrayList<>(sorted));
        }
        return steps;
    }

    /**
     * Method implements Counting Sort Algorithm to sort the array in time
     * complexity O(n)
     * 
     * @param withSteps: True if the user wants the intermediate arrays, False if
     *                   only the result is needed
     * @return : List of the final array or List of Intermediate arrays
     */
    public List<List<Integer>> countingSort(boolean withSteps) throws RangeExceededException {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : this.numbers) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        long range = (long) max - (long) min + 1;
        int MAXSIZE = 200000000;
        if (range > MAXSIZE) {
            throw new RangeExceededException();
        }
        int count[] = new int[(int) range];
        for (int i : this.numbers)
            count[i - min]++;
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>(this.numbers);
        if (withSteps) {
            steps.add(new ArrayList<>(sorted));
        }
        for (int i : this.numbers) {
            sorted.set(--count[i - min], i);
            if (withSteps)
                steps.add(new ArrayList<>(sorted));
        }
        if (!withSteps) {
            steps.add(new ArrayList<>(sorted));
        }
        return steps;
    }

    /**
     * Method initializes the list of numbers by reading the comma seperated list
     * from file
     * 
     * @param input_file : the file of comma seperated array
     */
    public void readFromFile(File input_file) {
        if (input_file == null) {
            return;
        }
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(input_file));
            String line = buffReader.readLine();
            while (line != null) {
                String[] numberStrings = line.split("\\s*,\\s*");
                for (String numberString : numberStrings) {
                    this.numbers.add(Integer.parseInt(numberString));
                }
                line = buffReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}