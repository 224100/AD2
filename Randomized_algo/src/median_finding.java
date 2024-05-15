import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class median_finding {
    void int select(int[] a , int k){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:- ");
        int[] a = new int[sc.nextInt()];
        System.out.println("Enter the elements:- ");
        for(int i =0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        if((a.length%2)==0){
            System.out.println(select(a,a.length/2));
        }
        else{
            System.out.println(select(a,(a.length+1)/2));
        }
    }
}
