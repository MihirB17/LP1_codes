import java.util.Scanner;

class WF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of partitions: ");
        int npart = sc.nextInt();
        System.out.print("Enter size of partitions: ");
        int part[] = new int[npart];
        for (int i = 0; i < npart; i++)
            part[i] = sc.nextInt();
        System.out.print("Enter no. of processes: ");
        int npro = sc.nextInt();
        System.out.print("Enter size of processes: ");
        int pro[] = new int[npro];
        for (int i = 0; i < npro; i++)
            pro[i] = sc.nextInt();

        int filled[] = new int[npart];

        for (int i = 0; i < npro; i++) {
            int diff[] = new int[npart];
            for (int j = 0; j < npart; j++) {
                if (filled[j] != 1) {
                    diff[j] = part[j] - pro[i];
                } else {
                    diff[j] = -1;
                }
            }
            int max = -1, k = -1;
            for (int j = 0; j < npart; j++) {
                if (diff[j] >= 0 && part[j] > max) {
                    max = part[j];
                    k = j;
                }
            }
            if (k != -1) {
                filled[k] = 1;
                System.out.println("Worst Fit for process " + (i + 1) + " is " + part[k] + " and Hole of " + diff[k] + " is created.");
            } else {
                System.out.println("Worst Fit not found for process " + (i + 1) + ".");
            }
        }
    }
}

