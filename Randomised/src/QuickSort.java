import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original array: ");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();

        quickSort(arr, 0, n-1);

        System.out.println("Sorted array: ");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private static final Random random = new Random();

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomPartition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int randomPartition(int[] arr, int low, int high) {
        int pivotIndex = low + random.nextInt(high - low + 1);
        swap(arr, pivotIndex, high);
        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}