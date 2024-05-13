import java.util.Scanner;

public class QS {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        System.out.println("Enter the size : ");
        int[] a = new int[sc.nextInt()];

        System.out.println("Enter the elements : ");
        for(int i =0;i<a.length;i++)
            a[i]=sc.nextInt();

        quicksort(a,0,a.length-1);

        for(int i : a)
            System.out.print(i+" , ");
        System.out.println();

    }
    static int partition(int[]a , int p,int r){

        int pivot = a[r];
        int i = p-1;

        for(int j = p ;j<=r-1;j++ )
            if(a[j]<=pivot){
                i++;
                swap(a,i,j);
            }


        swap(a,i+1,r);
        return(i+1);

    }

    static void swap(int[]a , int i,int j){

        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;

    }

    static void quicksort(int[]a,int p, int r){

        if(p<r){
            int m =partition(a,p,r);

            quicksort(a,p,m-1);
            quicksort(a,m+1,r);
        }
    }
}
