import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int lengthOfLIS = longestIncreasingSubsequence(numbers);

        System.out.println("Length of Longest Increasing Subsequence is " + lengthOfLIS);

        scanner.close();
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];

        // Initialize LIS values for all indexes
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        // Compute LIS values in bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Pick maximum of all LIS values
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }
}
