import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RangeExceededException extends Exception {
    public RangeExceededException() {
        super("Range of numbers exceeds the limits of the algorithm");
    }
}

public class SortArray {

    private List<Integer> numbers;
    private int numsCount; // Length of array (for readability)

    // Default constructor
    public SortArray() {
    }

    public SortArray(List<Integer> nums) {
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
    public List<List<Integer>> bubbleSort(boolean withSteps) {
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

    
    void merge(List<Integer>arr,boolean withSteps,List<List<Integer>> steps,int start, int mid,int end) 
    {
            int n1 = mid - start + 1;
            int n2 = end - mid;
            List<Integer> leftAr = new ArrayList<>();
            List<Integer> rightAr = new ArrayList<>();

            for (int i = 0; i < n1; ++i)
            leftAr.add(arr.get(start + i));
                
            for (int j = 0; j < n2; ++j)
            rightAr.add(arr.get(mid + 1 + j));

            int i = 0, j = 0;
            int k = start;
            while (i < n1 && j < n2) {
                if (leftAr.get(i) <= rightAr.get(j)) {
                    arr.set(k, leftAr.get(i));
                    i++;
                }
                else {
                    arr.set(k, rightAr.get(j));
                    j++;
                }
                if(withSteps && ((steps.size() == 0) || !steps.get(steps.size() - 1).equals(arr)))
                    steps.add(new ArrayList<>(arr));

                k++;
            }
            while (i < n1) {
                arr.set(k, leftAr.get(i));
                i++;
                k++;
                if(withSteps && ((steps.size() == 0) || !steps.get(steps.size() - 1).equals(arr)))
                 steps.add(new ArrayList<>(arr));
            }
            while (j < n2) {
                arr.set(k, rightAr.get(j));
                j++;
                k++;
                if(withSteps && ((steps.size() == 0) || !steps.get(steps.size() - 1).equals(arr)))
                 steps.add(new ArrayList<>(arr));
            }
            
    }

    List<List<Integer>> mergeSortHelper(List<Integer> arr, boolean withSteps, List<List<Integer>> steps,int start,int end ) {
        if(arr.size()<=1)
            return Arrays.asList(arr);

        if (start < end) {
            int mid = start + (end - start) /2;
            mergeSortHelper(arr,withSteps,steps, start, mid);
            mergeSortHelper(arr,withSteps,steps, mid + 1, end);
            merge(arr, withSteps, steps, start, mid, end);
        }
        if (withSteps)
            return steps;
        else
            return Arrays.asList(arr);
    }
    
    public List<List<Integer>> mergeSort(boolean withSteps) {
        List<Integer> arr=new ArrayList<>(this.numbers);
        List<List<Integer>> steps = new ArrayList<>();
        List<List<Integer>> result = mergeSortHelper(arr,withSteps, steps,0,arr.size()-1);
        if (withSteps)
            return steps;
        else
            return result;
    }
    /**
     * Method implements Counting Sort Algorithm to sort the array in time
     * complexity O(n)
     * 
     * @param withSteps: True if the user wants the intermediate arrays, False if
     *                   only the result is needed
     * @return : List of the final array or List of Intermediate arrays
     */
    public List<List<Integer>> countingSort(boolean withSteps) {
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
            // throw new RangeExceededException();
            System.out.println("Range of numbers exceeds the limits of the algorithm");
            return null;
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
