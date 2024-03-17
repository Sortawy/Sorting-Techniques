
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        File file = new File(path);
        if (!file.exists() || !file.canRead()) {
            System.out.println("Cannot open the file");
            return;
        }
        SortArray sorter = new SortArray(file);

        while (true) {
            printMenu();
            String steps = "";
            List<List<Integer>> ans;
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice != 4) {
                System.out.print("Do you want to see the steps? (y/n): ");
                steps = scanner.nextLine();
            }
            switch (choice) {
                case 1 -> {
                    ans = sorter.bubbleSort(steps.equals("y"));
                    printAnswer(ans);
                }
                case 2 -> {
                    ans = sorter.mergeSort(steps.equals("y"));
                    printAnswer(ans);
                }
                case 3 -> {
                    ans = sorter.countingSort(steps.equals("y"));
                    printAnswer(ans);
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }

    }

    static void printMenu() {
        System.out.println("Choose the desired sorting algorithm: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Counting Sort");
        System.out.println("4. Exit");
        System.out.print("Enter choice (1-4): ");
    }

    static void printAnswer(List<List<Integer>> ans) {
        ans.forEach(System.out::println);
    }
}