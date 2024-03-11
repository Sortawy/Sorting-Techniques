import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SortArray {

    private List<Integer> numbers;
    // Default constructor
    SortArray(){}

    SortArray(File list_file) {
        this.numbers=new ArrayList<>();
        readFromFile(list_file);
    }

    void readFromFile(File input_file) {
        if (input_file == null){
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
        }
        catch (IOException e){
            System.out.println("Error reading file.");
            throw new RuntimeException(e);
        }
    }
}
