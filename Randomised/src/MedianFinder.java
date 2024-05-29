import java.util.Scanner;

public class MedianFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length : ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        if (n % 2 == 1) {
            System.out.println("Median is: " + findMedian(array, 0, n - 1, n / 2));
        } else {
            int median1 = findMedian(array, 0, n - 1, n / 2 - 1);
            int median2 = findMedian(array, 0, n - 1, n / 2);
            System.out.println("Median is: " + (median1 + median2) / 2.0);
        }
    }

    public static int findMedian(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int partitionIndex = partition(arr, low, high);
            if (partitionIndex == k) {
                return arr[partitionIndex];
            } else if (partitionIndex > k) {
                return findMedian(arr, low, partitionIndex - 1, k);
            } else {
                return findMedian(arr, partitionIndex + 1, high, k);
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}