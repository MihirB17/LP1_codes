import java.util.Scanner;

public class priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        String[] process = new String[n];
        int[] burstTime = new int[n];
        int[] priority = new int[n];

        int totalBurstTime = 0;

        for (int i = 0; i < n; i++) {
            process[i] = "P" + (i + 1);
            System.out.print("Burst Time for " + process[i] + ": ");
            burstTime[i] = sc.nextInt();
            totalBurstTime += burstTime[i];
            System.out.print("Priority for " + process[i] + ": ");
            priority[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (priority[j] > priority[j + 1]) {
                    swap(priority, j, j + 1);
                    swap(burstTime, j, j + 1);
                    swap(process, j, j + 1);
                }
            }
        }

        int[] waitingTime = new int[n];
        int totalTurnaroundTime = 0;

        waitingTime[0] = 0;
        for (int i = 1; i < n; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int turnaroundTime = waitingTime[i] + burstTime[i];
            totalTurnaroundTime += turnaroundTime;
            System.out.println(process[i] + "\tBT: " + burstTime[i] + "\tWT: " + waitingTime[i] + "\tTAT: " + turnaroundTime);
        }

        double avgWaitingTime = (double) (totalTurnaroundTime - totalBurstTime) / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

