import java.util.*;
public class OptimalPageReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of page frames: ");
        int numFrames = scanner.nextInt();
        System.out.print("Enter the number of page references: ");
        int numReferences = scanner.nextInt();
        int[] pageReferences = new int[numReferences];
        System.out.println("Enter the page reference sequence:");
        for (int i = 0; i < numReferences; i++) {
            pageReferences[i] = scanner.nextInt();
        }
        optimalPage(pageReferences, numFrames);
        scanner.close();
    }
    static void optimalPage(int pg[], int fn) {
        int[] fr = new int[fn];
        int hit = 0;
        int index = 0;
        for (int i = 0; i < pg.length; i++) {
            if (search(pg[i], fr)) {
                hit++;
                continue;
            }
            if (index < fn) {
                fr[index++] = pg[i];
            } else {
                int j = predict(pg, fr, i + 1);
                fr[j] = pg[i];
            }
        }
        System.out.println("No. of hits = " + hit);
        System.out.println("No. of misses = " + (pg.length - hit));
    }
    static boolean search(int key, int[] fr) {
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] == key) {
                return true;
            }
        }
        return false;
    }
    static int predict(int pg[], int[] fr, int index) {
        int res = -1, farthest = index;
        for (int i = 0; i < fr.length; i++) {
            int j;
            for (j = index; j < pg.length; j++) {
                if (fr[i] == pg[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }
            if (j == pg.length) {
                return i;
            }
        }
        return (res == -1) ? 0 : res;
    }
}
