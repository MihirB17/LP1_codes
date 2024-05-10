import java.util.ArrayList;
import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the capacity (number of page frames): ");
        int capacity = scanner.nextInt();
        
        System.out.print("Enter the number of page references: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the page reference sequence:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> s = new ArrayList<>(capacity);
        int count = 0;
        int page_faults = 0;

        for (int i : arr) {
            if (!s.contains(i)) {
                if (s.size() == capacity) {
                    s.remove(0);
                    s.add(capacity - 1, i);
                } else {
                    s.add(count, i);
                }
                page_faults++;
                ++count;
            } else {
                s.remove((Object) i);
                s.add(s.size(), i);
            }
        }

        System.out.println("Total Page Faults: " + page_faults);
        
        scanner.close();
    }
}
