import java.util.Scanner;

public class counting_inversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int[] a = new int[sc.nextInt()];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int n = a.length;
        System.out.println("Number of inversions are " + mergeSort(a, 0, n - 1));
        System.out.println("PS C:\\Aman_2241001030>");
    }
    static int mergeSort(int[] a, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSort(a, l, m);
            count += mergeSort(a, m + 1, r);
            count += merge(a, l, m, r);
        }
        return count;
    }
    static int merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        int count = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
                count += n1 - i;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
        return count;
    }
}
