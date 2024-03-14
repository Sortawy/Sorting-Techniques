import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Demo Main (Remove)
        List<Integer> test= Arrays.asList(5,4,1,6,4,12,0);
        SortArray sorter=new SortArray(test);
        List<List<Integer>> output=sorter.simpleSort(false);
        List<Integer> sorted=output.get(output.size()-1);
        for (int x : sorted){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}