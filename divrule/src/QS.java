public class QS {
    public static void main(String[] args) {
        int[] a = {9,5,8,14,3,6,7,14,41,16,56,26,1};
        quicksort(a,0,a.length-1);
        for(int i : a){
            System.out.print(i+" , ");
        }
    }
    static int partition(int[]a , int p,int r){
        int pivot = a[r];
        int i = p-1;
        for(int j = p ;j<=r-1;j++ ){
            if(a[j]<=pivot){
                i++;
                swap(a,i,j);
            }
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
