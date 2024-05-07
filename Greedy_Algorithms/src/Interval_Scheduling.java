import java.util.Scanner;

public class Interval_Scheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of intervals: ");
        node[] n = new node[sc.nextInt()];
        for(int i =0;i<n.length;i++){
            System.out.println("Enter the start and end time of interval "+(i+1)+": ");
            n[i]=new node((char)(i+65),sc.nextInt(),sc.nextInt());
        }
        for(int i =0;i<n.length;i++){
            for(int j =0 ; j < n.length-i-1;j++){
                if(n[j].et>n[j+1].et)
                {
                    node temp = n[j];
                    n[j]=n[j+1];
                    n[j+1]=temp;
                }
            }
        }
        System.out.println("Intervals are:");
        node temp = new node('1',0,0);
        for(int i =0;i<n.length;i++){
            if(temp.et<=n[i].st){
                System.out.println(n[i]);
                temp=n[i];
            }
        }

    }
}
class node{
    char a;
    int st;
    int et;
    node(char a , int st,int et){
        this.a =a;
        this.st=st;
        this.et=et;
    }
    @Override
    public String toString(){
        return a+" "+st+" "+et;
    }

        }
